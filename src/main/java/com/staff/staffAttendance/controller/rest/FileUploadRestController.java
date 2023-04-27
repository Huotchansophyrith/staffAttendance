package com.staff.staffAttendance.controller.rest;

import com.staff.staffAttendance.common.constant.ResponseDTO;
import com.staff.staffAttendance.service.SoftFileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/v1/softfiles")
public class FileUploadRestController {

    private final SoftFileService softFileService;

    public FileUploadRestController(SoftFileService softFileService) {
        this.softFileService = softFileService;
    }

    @PostMapping("/upload")
    public ResponseDTO uploadFile(@RequestParam("dir") String[] dir, @RequestParam("files") MultipartFile[] files) {
        return this.softFileService.upload(dir,files);
    }

    @GetMapping("download")
    public ResponseEntity<byte[]> download(
            @RequestParam String fileLocated,
            HttpServletRequest request) {
        return this.softFileService.download(fileLocated, request);
    }

}
