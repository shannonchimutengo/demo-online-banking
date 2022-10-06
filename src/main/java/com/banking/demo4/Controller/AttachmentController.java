//package com.banking.demo4.Controller;
//
//import com.banking.demo4.Entity.Attachment;
//import com.banking.demo4.Service.AttachmentService;
//import org.springframework.core.io.ByteArrayResource;
//import org.springframework.core.io.Resource;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//
//@RestController
//public class AttachmentController {
//
//AttachmentService attachmentService;
//
//    public AttachmentController(AttachmentService attachmentService) {
//        this.attachmentService = attachmentService;
//    }
//
//@PostMapping("/upload")
//@ResponseBody
//    public String upload(@RequestParam("file") MultipartFile file) throws Exception{
//
//        Attachment attachment;
//
//        attachment = attachmentService.saveAttachment(file) ;
//
//       return attachment.getDownloadurl();
//    }
//
////    @GetMapping("/download/{filename}")
//
//    ResponseEntity<Resource> downloadFile(@PathVariable("filename")  String filename) throws Exception{
//
//        Attachment attachment = attachmentService.getAttachment(filename);
//        System.out.println(attachment);
//
//        return ResponseEntity.ok()
//                .contentType(MediaType.parseMediaType(attachment.getContentType()))
//                .header(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename = \" "+attachment.getFilename()+"\"")
//                .body(new ByteArrayResource(attachment.getData()));
//        }
//
//
//    }
//
