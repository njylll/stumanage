package com.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.entity.StudentGrade;
import com.example.service.StudentGradeService;
import com.example.dao.StudentGradeMapper;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class StudentGradeServiceImpl extends ServiceImpl<StudentGradeMapper, StudentGrade>
    implements StudentGradeService{

}



