package com.junyi.java_web;

import com.junyi.java_web.domain.EmployeeInfo;
import com.junyi.java_web.service.impl.ManagerInfoServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class JavaWebApplicationTests {
@Autowired
    ManagerInfoServiceImpl managerInfoService;

    @Test
    void contextLoads() {
        List<EmployeeInfo> employees = managerInfoService.getAllemployee();
        System.out.println(employees);
    }

    @Test
    void testSearch(){
        List<EmployeeInfo> employees = managerInfoService.searchByDepartment("技术部");
        System.out.println(employees);
    }

}
