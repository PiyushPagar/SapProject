package com.SapPortal.security.services;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
@Service
public class FileService {
	
	public String uploadImage(String path, MultipartFile multipartFile) throws IOException {
		String name = multipartFile.getOriginalFilename();
		String randomID= UUID.randomUUID().toString();
		String filename= randomID.concat(name.substring(name.lastIndexOf(".")));
		String filepath = path + File.separator+ filename;
		File f= new File(path);
		if(!f.exists())
		{
			f.mkdir();
		}
		Files.copy(multipartFile.getInputStream(), Paths.get(filepath), StandardCopyOption.REPLACE_EXISTING);
		return filename;
	}
	
	public InputStream getResources(String path, String fileName) throws FileNotFoundException {
		String fullPath= path + File.separator+ fileName;
		InputStream inputStream= new FileInputStream(fullPath);
		return inputStream;
	}

}
