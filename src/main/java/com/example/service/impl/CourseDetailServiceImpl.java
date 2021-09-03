package com.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.dao.CourseDetailMapper;
import com.example.entity.CourseDetail;
import com.example.service.CourseDetailDTOService;
import com.example.service.CourseDetailService;
import org.springframework.stereotype.Service;

@Service
public class CourseDetailServiceImpl extends ServiceImpl<CourseDetailMapper, CourseDetail>
        implements CourseDetailService {
}
