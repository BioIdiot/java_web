package com.junyi.java_web.controller;


import com.junyi.java_web.domain.EmployeeInfo;
import com.junyi.java_web.service.impl.ManagerInfoServiceImpl;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author junyi
 * @since 2024-05-26
 */
@Controller
@RequestMapping("/manager-info")
public class ManagerInfoController {
    @Autowired
    ManagerInfoServiceImpl managerInfoService;


    @GetMapping
    public String getAll(ModelMap map) {
        List<EmployeeInfo> employees = managerInfoService.getAllemployee();
        map.addAttribute("employees", employees);
        System.out.println("11111");
        return "system";
    }

    @PostMapping
    public String sava(@RequestBody EmployeeInfo employeeInfo) {
        System.out.println(employeeInfo);
        managerInfoService.saveEmployee(employeeInfo);
        return "system";
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Integer id) {
        System.out.println(id);
        boolean isDeleted = managerInfoService.deleteEmployee(id);
        return "system";
    }

    @PutMapping
    public String update(@RequestBody EmployeeInfo employeeInfo) {
        System.out.println(employeeInfo);
    managerInfoService.update(employeeInfo);
        return "system";
    }
}
