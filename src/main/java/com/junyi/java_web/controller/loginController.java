package com.junyi.java_web.controller;

import com.junyi.java_web.domain.ManagerInfo;
import com.junyi.java_web.service.impl.LoginServiceImpl;
import com.junyi.java_web.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

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

       if(flag){
           Map<String, Object> claims = new HashMap<>();
           claims.put("id",managerInfo.getId());
           String jwt = JwtUtils.generataJWT(claims);
           return new Result(Code.LOGIN_OK, jwt);
       }

        return new Result(Code.LOGIN_ERR, flag);
   }

}
