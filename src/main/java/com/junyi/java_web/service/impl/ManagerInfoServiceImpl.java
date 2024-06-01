package com.junyi.java_web.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.junyi.java_web.domain.EmployeeInfo;
import com.junyi.java_web.domain.ManagerInfo;
import com.junyi.java_web.mapper.EmployeeInfoMapper;
import com.junyi.java_web.mapper.ManagerInfoMapper;
import com.junyi.java_web.service.IManagerInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author junyi
 * @since 2024-05-26
 */
@Service
public class ManagerInfoServiceImpl extends ServiceImpl<ManagerInfoMapper, ManagerInfo> implements IManagerInfoService {
@Autowired
    EmployeeInfoMapper employeeInfoMapper;
    @Override
    public List<EmployeeInfo> getAllemployee() {
        return employeeInfoMapper.selectList(null);
    }

    @Override
    public void saveEmployee(EmployeeInfo employeeInfo) {

         employeeInfoMapper.insert(employeeInfo);
    }

    @Override
    public boolean deleteEmployee(int id) {

        return employeeInfoMapper.deleteById(id)==1;
    }

    @Override
    public void update(EmployeeInfo employeeInfo) {
        employeeInfoMapper.updateById(employeeInfo);
    }

    @Override
    public List<EmployeeInfo> searchByDepartment(String department) {
        LambdaQueryWrapper<EmployeeInfo> lqw = new LambdaQueryWrapper<>();
        lqw.eq(EmployeeInfo::getDepartment,department);
        return  employeeInfoMapper.selectList(lqw);
    }
}
