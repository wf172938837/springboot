package com.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller("cont")
@RequestMapping("apis/upload")
@Api(tags = "上传")
public class TestController {

    @RequestMapping(value="up")
    @ResponseBody
    @ApiOperation("上传文件")
    public String show(MultipartFile file){
        if(file.isEmpty()){
            return "上传失败";
        }
        String oldName=file.getOriginalFilename();
        String path="E:/1/";
        File f=new File(path+oldName);
        if(!f.getParentFile().exists()){
            f.getParentFile().mkdirs();
        }
        try {
            file.transferTo(f);
            return "成功";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "失败";
    }
}
