package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.ResponseData;
import com.app.service.AttachmentService;

@RestController
public class AttachmentController {
	
	@Autowired
	private AttachmentService attachmentService;
	
	@PostMapping("/upload")
	public ResponseData uploadFile() {
		
	}

}
