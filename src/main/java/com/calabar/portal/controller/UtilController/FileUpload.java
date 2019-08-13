package com.calabar.portal.controller.UtilController;

import com.alibaba.fastjson.JSONObject;
import jcifs.smb.SmbFile;
import jcifs.smb.SmbFileOutputStream;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.util.*;

/**
 * 多文件上传
 */
@RestController
public class FileUpload {
    @Value("${calabar.file.d.upLoadIp}")
    private String upLoadIp;
    @Value("${calabar.file.d.getIp}")
    private String getIp;
    @Value("${file.whitelist}")
    private String whitelist;
    @PostMapping("/sczy/updateFile")
    public String handleFileUpload(HttpServletRequest request) {
        MultipartHttpServletRequest params=((MultipartHttpServletRequest) request);
        Map<String, MultipartFile> fileMap = ((MultipartHttpServletRequest) request).getFileMap();
        BufferedOutputStream stream = null;
        Set<String> strings = fileMap.keySet();
        JSONObject obj = new JSONObject();
        Collection<MultipartFile> files = fileMap.values();
        String newFileName ="";
        for (MultipartFile multipartFile:files) {
            if (!multipartFile.isEmpty()) {
              String fileName=multipartFile.getOriginalFilename();
              //获取后缀
                int last=fileName.lastIndexOf(".")+1;
                String suffix= fileName.substring(last);
                String[] split = whitelist.replace( " ", "").replace("/t", "").toLowerCase().split(",");
                boolean b=false;
                for (int i = 0; i <split.length ; i++) {
                    if(split[i].contains(suffix.toLowerCase())){
                        b=true;
                        break;
                    }
                }
                if(!b){
                    obj.put("error", 1);
                    obj.put("url","不支持的文件格式："+fileName);
                }
                try {
                     newFileName = UUID.randomUUID().toString().replace("-", "")+"."+suffix;
                    byte[] bytes = multipartFile.getBytes();
                    SmbFile smbFile = new SmbFile(upLoadIp + newFileName);
                   // smbFile.connect();
                    stream = new BufferedOutputStream(new SmbFileOutputStream(smbFile));
                    stream.write(bytes);
                    stream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                    if(stream!=null){
                        try {
                            stream.close();
                        }catch (Exception se){
                            e.printStackTrace();
                        }
                    }
                    obj.put("error", 1);
                    obj.put("url","这个文件错误：,"+multipartFile.getOriginalFilename());
                    return obj.toString();
                }
            } else {
                obj.put("error", 1);
                obj.put("url","w未获取到文件" );
                return obj.toString();
            }
        }
        obj.put("error", 0);
        obj.put("url",getIp+newFileName);
        return obj.toString();
    }

    public static void main(String[] args) {
        try {
            String url="smb://test:test123@10.165.106.86/reportfiles/" ;
            url+="123321.txt";
            SmbFile smbFile = new SmbFile(url);
            BufferedOutputStream stream = null;
            smbFile.connect();
            stream = new BufferedOutputStream(new SmbFileOutputStream(smbFile));
            stream.write("123".getBytes());
            stream.close();
        }catch (Exception e){
        e.printStackTrace();
        }
    }
}
