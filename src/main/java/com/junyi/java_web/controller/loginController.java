package com.junyi.java_web.controller;

import com.junyi.java_web.domain.ManagerInfo;
import com.junyi.java_web.service.impl.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author junyi
 * @since 2024-05-26
 */
@RestController
@RequestMapping("/login")
public class loginController {

    @Autowired
    LoginServiceImpl loginService;

    @PostMapping
   public Result login(@RequestBody ManagerInfo managerInfo){
       System.out.println(managerInfo.getId());
       boolean flag = loginService.login(managerInfo.getId().toString(),
                                         managerInfo.getPassword());
        return new Result(flag ? Code.LOGIN_OK:Code.LOGIN_ERR , flag);
   }

}
