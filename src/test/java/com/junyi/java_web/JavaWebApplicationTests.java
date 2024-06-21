package com.junyi.java_web;

import com.junyi.java_web.domain.EmployeeInfo;
import com.junyi.java_web.service.impl.ManagerInfoServiceImpl;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@SpringBootTest
class JavaWebApplicationTests {
    @Autowired
    ManagerInfoServiceImpl managerInfoService;

    @Test
    void contextLoads() {
        List<EmployeeInfo> employees = managerInfoService.getAllemployee();
        System.out.println(employees);
    }

    @Test
    void testSearch() {
        List<EmployeeInfo> employees = managerInfoService.searchByDepartment("技术部");
        System.out.println(employees);
    }

    @Test
    void testJWT() {
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", 1);
        claims.put("name", "Tom");

        String jwt = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256,"junyi")//签名算法
                .setClaims(claims)//自定义内容（载荷）
                .setExpiration(new Date(System.currentTimeMillis() + 120 * 1000))//设置有效期
                .compact();
        System.out.println(jwt);
    }

    /**
     * 解析令牌
     */
    @Test
    void testParesJWT() {
        Claims claims = Jwts.parser()
                .setSigningKey("junyi")
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoiVG9tIiwiaWQiOjEsImV4cCI6MTcxODk0MjgxN30.GrNYV9jEz72kNx3KlmE_DqG9ilpZJNL6PAg21crbPK0")
                .getBody();
        System.out.println(claims);
    }

}
