package com.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.entity.AdminAccount;
import com.example.service.AdminAccountService;
import com.example.dao.AdminAccountMapper;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class AdminAccountServiceImpl extends ServiceImpl<AdminAccountMapper, AdminAccount>
    implements AdminAccountService{


}



