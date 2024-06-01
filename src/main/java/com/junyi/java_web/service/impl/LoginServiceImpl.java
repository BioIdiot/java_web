package com.junyi.java_web.service.impl;

import com.junyi.java_web.mapper.ManagerInfoMapper;
import com.junyi.java_web.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    ManagerInfoMapper managerInfoMapper;
    @Override
    public boolean login(String id, String password) {
        return managerInfoMapper.selectById(id) != null
                && Objects.equals(managerInfoMapper.selectById(id).getPassword(), password);
    }
}
