package com.SapPortal.controllers;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.SapPortal.models.PlacementDetails;
import com.SapPortal.repository.PlacementDetailsRepository;
import com.SapPortal.security.services.FileService;


public class PlacementDetailsController {
	
	@Autowired
	PlacementDetailsRepository placementDetailsRepository;
	@Autowired
	FileService fileService;

	@Value("${project.image}")
	private String path;
//@PathVariable("user_id") Long userId, @RequestParam("image") MultipartFile multipartFile
	@PostMapping("/addprofile")
	public ResponseEntity<PlacementDetails> addprofile() throws IOException {
		PlacementDetails oldprofile = placementDetailsRepository.findProfileByUserId(userId);
		String filename = this.fileService.uploadImage(path, multipartFile);
		if (oldprofile == null) {
			PlacementDetails profilePicture = new PlacementDetails();
			profilePicture.setImage(filename);
			profilePicture.setUser(user);
			return new ResponseEntity<PlacementDetails>(placementDetailsRepository.save(profilePicture), HttpStatus.OK);
		} else {
			oldprofile.setImage(filename);
			placementDetailsRepository.save(oldprofile);
			return new ResponseEntity<PlacementDetails>(placementDetailsRepository.save(oldprofile), HttpStatus.OK);
		 }
	    }

	@GetMapping("/getprofilepicture")
	public ResponseEntity<PlacementDetails> getproductbycategory(@PathVariable("user_id") Long userId) {
		PlacementDetails picture = (PlacementDetails) placementDetailsRepository.findAll();
		return new ResponseEntity<>(picture, HttpStatus.OK);
	}

	@GetMapping(value = "serveprofilepicture/{imageName}", produces = MediaType.IMAGE_JPEG_VALUE)
	public void downloadImage(@PathVariable("imageName") String imageName, HttpServletResponse response)
			throws IOException {
		InputStream resource = this.fileService.getResources(path, imageName);
		response.setContentType(MediaType.IMAGE_JPEG_VALUE);
		StreamUtils.copy(resource, response.getOutputStream());
	}

}
