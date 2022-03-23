package com.app.service;

import org.springframework.web.multipart.MultipartFile;

import com.app.entity.Attachment;

public interface AttachmentService {

	Attachment saveAttachment(MultipartFile file) throws Exception;

	Attachment getAttachment(String fileId) throws Exception;

}
