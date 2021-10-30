package com.example.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.dao.UserMapper;
import com.example.entity.StudentCourseVo;
import com.example.entity.User;
import com.example.service.impl.AliOssServiceImpl;
import com.example.service.impl.StudentCourseVoServiceImpl;
import com.example.service.impl.UserServiceImpl;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/newVersion/teacher")
public class NewTeacherController {
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private AliOssServiceImpl aliOssService;
    @Autowired
    private StudentCourseVoServiceImpl studentCourseVoService;

    //主页
    @GetMapping(value = {"/","/index"})
    public String toTeacherMainPage(Model model)
    {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        User u= userMapper.selectOne(new QueryWrapper<User>().eq("username",userDetails.getUsername()));
        model.addAttribute("avatar",u.getAvatarUrl());
        return "/newVersion/teacher/index";
    }

    //个人设置
    @GetMapping("/me")
    public String toMePage(Model model)
    {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        User u= userMapper.selectOne(new QueryWrapper<User>().eq("username",userDetails.getUsername()));
        model.addAttribute("avatar",u.getAvatarUrl());
        String id;
        if(u!=null)
            id=u.getId();
        else
            id="";
        model.addAttribute("sId",id);
        return "/newVersion/teacher/me";
    }
    //个人设置
    @PostMapping("/me")
    @ResponseBody
    public String doEditMe(@RequestParam("username")String username,
                           @RequestParam("studentId")String studentId,
                           @RequestParam("password")String password)
    {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        User u= userMapper.selectOne(new QueryWrapper<User>().eq("username",userDetails.getUsername()));
        String originName=u.getUsername();
        if(!StringUtils.isEmpty(username))
            u.setUsername(username);
        if(!StringUtils.isEmpty(studentId))
            u.setId(studentId);
        if(!StringUtils.isEmpty(password))
            u.setPassword(password);
        userService.update(u,new QueryWrapper<User>().eq("username",originName));
        return "{\"message\":修改成功，请重新登陆}";
    }

    //上传头像
    @PostMapping("/me/avatar")
    @ResponseBody
    public String upLoadAvatar(@RequestParam("file") MultipartFile file) throws IOException
    {
        if (file.isEmpty()) {
            return "{" +
                    "  \"code\": 1\n" +
                    "  ,\"msg\": \"上传空文件\"\n" +
                    "  ,\"data\": {\n" +
                    "    \"src\": \"\"\n" +
                    "  }" +
                    "}       ";
        }
        String fileName= RandomString.make(16);
        String imgUrl="avatar/"+fileName+".jpg";
        aliOssService.uploadImg(imgUrl,file.getInputStream());
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        User u= userMapper.selectOne(new QueryWrapper<User>().eq("username",userDetails.getUsername()));
        u.setAvatarUrl("https://sunnynoodlebucket.oss-cn-shanghai.aliyuncs.com/"+imgUrl);
        userService.update(u,new QueryWrapper<User>().eq("username",userDetails.getUsername()));
        return "{" +
                "  \"code\": 0\n" +
                "  ,\"msg\": \"成功\"\n" +
                "  ,\"data\": {\n" +
                "    \"src\": \"https://sunnynoodlebucket.oss-cn-shanghai.aliyuncs.com/avatar/"+ fileName+".jpg" +".jpg\"" +
                "  }" +
                "}       ";
    }
    //课表
    @GetMapping("/curriculum")
    public String toCurriculumPage(Model model)
    {
        String uId=getUserId();
        List<StudentCourseVo> courseList= studentCourseVoService.list(new QueryWrapper<StudentCourseVo>().eq("teacher_id",uId).orderByAsc("day_time"));
        String courseJson= JSON.toJSONString(courseList);
        model.addAttribute("courses",courseJson);
        //System.out.println(courseJson);
        return "/newVersion/teacher/curriculum";
    }

    private String getUserId()
    {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        User u= userMapper.selectOne(new QueryWrapper<User>().eq("username",userDetails.getUsername()));
        return u.getId();
    }

}
