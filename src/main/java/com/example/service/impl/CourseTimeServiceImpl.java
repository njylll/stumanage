package com.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.entity.CourseTime;
import com.example.service.CourseTimeService;
import com.example.dao.CourseTimeMapper;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class CourseTimeServiceImpl extends ServiceImpl<CourseTimeMapper, CourseTime>
    implements CourseTimeService{

}



