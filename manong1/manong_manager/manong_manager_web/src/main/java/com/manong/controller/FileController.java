package com.manong.controller;

import com.manong.fastdfs.FastDFSClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author APPLE
 * @author 2019-05-06 下午10:49
 * @description 文件上传
 */
@Controller
public class FileController {

    @RequestMapping(value = "uploadfile",method = RequestMethod.POST)
    @ResponseBody
    public String fileupload(@RequestParam MultipartFile uploadfile) throws IOException {
        String fileId = FastDFSClient.uploadFile(uploadfile.getInputStream(), uploadfile.getOriginalFilename());
        if(fileId != null){
            System.out.println("上传文件成功");
        }
        return fileId;
    }
}
