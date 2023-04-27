package com.staff.staffAttendance.service;

import com.staff.staffAttendance.common.constant.ResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

public interface SoftFileService {

    ResponseDTO upload(String[] dir, MultipartFile[] files);

    ResponseEntity<byte[]> download(String fileLocated, HttpServletRequest request);
}
