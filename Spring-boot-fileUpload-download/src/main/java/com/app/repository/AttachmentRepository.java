package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.Attachment;


@Repository
public interface AttachmentRepository extends JpaRepository<Attachment, String> {

}
