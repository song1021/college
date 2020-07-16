package com.college.controller;

import com.college.common.entity.College;
import com.college.common.entity.RespBean;
import com.college.common.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * Created by Hunter on 2020-01-10.
 */
@RestController
@RequestMapping("/college")
public class CollegeController {

    @Autowired
    private CollegeService collegeService;

    @RequestMapping("/list")
    public RespBean list(){
        try {
            List<College> list = collegeService.getList();
            return RespBean.ok("获取列表成功", list);
        }catch (Exception e) {
            e.printStackTrace();
            return RespBean.error("获取列表失败");
        }
    }

    @RequestMapping("/add")
    public RespBean add(College college){
        try {
            if (collegeService.addCollege(college)){
                return RespBean.ok("添加成功");
            }else{
                return RespBean.error("添加失败");
            }
        }catch (Exception e) {
            e.printStackTrace();
            return RespBean.error("未知错误");
        }
    }

    /**
     *
     * @param picFile 接受前台提交的文件，而不是文件名
     * @param request
     * @return 上传的资源的全路径
     */
    @PostMapping("/upload")
    public RespBean upload(MultipartFile picFile, HttpServletRequest request){
        //1、获得上传文件夹的真实路径（是文件在tomcat服务上的路径）
        String realPath=request.getSession().getServletContext().getRealPath("/uploadFile/");
        //2、如果上传的文件夹不存在就创建
        File realPathFolder=new File(realPath);
        if(!realPathFolder.exists()){
            realPathFolder.mkdirs();
        }
        //3、上传文件的原始文件名
        String oldName=picFile.getOriginalFilename();
        //4、创建新文件名，防止上传的文件同名覆盖之前上传的文件
        String newName= UUID.randomUUID().toString()+oldName.substring(oldName.lastIndexOf("."),oldName.length());
        try {
            picFile.transferTo(new File(realPath,newName));

            //返回资源的路径 http://localhost:8080/
            String filePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+
                    "/uploadFile/"+ newName;
            return RespBean.ok("上传成功",filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return RespBean.error("上传失败");
    }

}
