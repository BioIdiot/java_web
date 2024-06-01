package com.junyi.java_web.service;

import com.junyi.java_web.domain.EmployeeInfo;
import com.junyi.java_web.domain.ManagerInfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author junyi
 * @since 2024-05-26
 */
public interface IManagerInfoService extends IService<ManagerInfo> {

    List<EmployeeInfo> getAllemployee();
    void saveEmployee(EmployeeInfo employeeInfo);
    boolean deleteEmployee(int ig);
    void update(EmployeeInfo employeeInfo);
    List<EmployeeInfo> searchByDepartment(String department);

}
