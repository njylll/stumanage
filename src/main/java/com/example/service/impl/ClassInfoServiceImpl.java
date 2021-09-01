package com.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.entity.ClassInfo;
import com.example.service.ClassInfoService;
import com.example.dao.ClassInfoMapper;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class ClassInfoServiceImpl extends ServiceImpl<ClassInfoMapper, ClassInfo>
    implements ClassInfoService{

}



