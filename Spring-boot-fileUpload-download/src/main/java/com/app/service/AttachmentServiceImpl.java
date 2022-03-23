package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.app.entity.Attachment;
import com.app.repository.AttachmentRepository;



@Service
public class AttachmentServiceImpl  implements AttachmentService{

	@Autowired
	private AttachmentRepository attachmentRepository;
	
	@Override
	public Attachment saveAttachment(MultipartFile file) throws Exception {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		
		try {
			if(fileName.contains("..")) {
				throw new Exception("File containd invalid path sequence" + fileName);
			}
			
			Attachment attachment = new Attachment(fileName,
					file.getContentType(),
					file.getBytes());
			return attachmentRepository.save(attachment);
		}catch(Exception e){
			throw new Exception("could not save file :" +fileName);
		}
		
	}

}
