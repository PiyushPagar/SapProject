package com.SapPortal.controllers;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.SapPortal.dto.Response;
import com.SapPortal.models.PlacementDetails;
import com.SapPortal.models.Status;
import com.SapPortal.repository.PlacementDetailsRepository;
import com.SapPortal.security.services.FileService;
import com.SapPortal.util.ConstantUtil;
import com.SapPortal.util.DateUtil;
import com.SapPortal.util.ImageUtils;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class PlacementDetailsController {

	@Autowired
	PlacementDetailsRepository placementDetailsRepository;
	@Autowired
	FileService fileService;

	@GetMapping("/getAllPlacement")
	public List<PlacementDetails> getAllPlacement() {
		List<PlacementDetails> getAllPlacement = placementDetailsRepository.findAllByOrderByPackagesDesc();
		return getAllPlacement;
	}

	@RequestMapping(value = "/addNewPlacement", method = RequestMethod.POST)
	@ResponseBody
	public Response updateAlertReadStatus(@RequestParam("image") MultipartFile file ,
			@RequestParam("name") String name,@RequestParam("companyName") String companyName,@RequestParam("moduleName") String moduleName,
			@RequestParam("year") String year ,@RequestParam("packages") Float packages) throws IOException {
		Response response = new Response();
		PlacementDetails placementDetailsinfo = new PlacementDetails();
		String currDateTime = DateUtil.currentformatDateTime(ConstantUtil.DateFormat);
    	String fileName=file.getOriginalFilename()+currDateTime;
		try {
			placementDetailsinfo.setName(name);
			placementDetailsinfo.setCompanyname(companyName);
			placementDetailsinfo.setModule(moduleName);
			placementDetailsinfo.setPlacementYear(year);
			placementDetailsinfo.setPackages(packages);
			placementDetailsinfo.setStudentfilename(fileName);
			placementDetailsinfo.setStudentfiletype(file.getContentType());
			placementDetailsinfo.setStudentimageData(ImageUtils.compressImage(file.getBytes()));
			placementDetailsRepository.save(placementDetailsinfo);
			response.setMessage("Placement added sucessful");
			response.setStatus(Status.SUCCESS);
		} catch (Exception e) {
			response.setMessage("Placement not added" + e.getMessage());
			response.setStatus(Status.FAILED);

		}
		return response;
	}
	
	
	@RequestMapping(value = "/updatePlacement", method = RequestMethod.POST)
	@ResponseBody
	public Response updatePlacement(@RequestBody PlacementDetails placementDetails,@RequestParam(name = "Id") Long id, HttpServletRequest request) {
		Response response = new Response();
		PlacementDetails placementDetailsinfo = placementDetailsRepository.findById(id).get();
		try {
			placementDetailsinfo.setName(placementDetails.getName());
			placementDetailsinfo.setCompanyname(placementDetails.getCompanyname());
			placementDetailsinfo.setStudentfilename(placementDetails.getStudentfilename());
			placementDetailsinfo.setStudentfiletype(placementDetails.getStudentfiletype());
			placementDetailsinfo.setModule(placementDetails.getModule());
			placementDetailsinfo.setPlacementYear(placementDetails.getPlacementYear());
			placementDetailsinfo.setPackages(placementDetails.getPackages());
			placementDetailsRepository.save(placementDetailsinfo);
			response.setMessage("Placement added sucessful");
			response.setStatus(Status.SUCCESS);
		} catch (Exception e) {
			response.setMessage("Placement not added" + e.getMessage());
			response.setStatus(Status.FAILED);

		}
		return response;
	}
	
	@GetMapping("getplacementimage/{fileName}")
	public ResponseEntity<?> downloadImage(@PathVariable String fileName) {
		Optional<PlacementDetails> dbImageData = placementDetailsRepository.findByStudentfilename(fileName);
		byte[] images = ImageUtils.decompressImage(dbImageData.get().getStudentimageData());
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(images);

	}
	
	

}
