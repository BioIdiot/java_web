package com.junyi.java_web.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Map;

public class JwtUtils {
    private static String signKey = "junyi";
    private static long expire = 600000L;

    /**
     * 生成JWT令牌
     * @param claims 为负载的内容
     */
    public static String generataJWT(Map<String,Object> claims){
        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS256,signKey)//签名算法
                .addClaims(claims)//自定义内容（载荷）
                .setExpiration(new Date(System.currentTimeMillis() + expire))//设置有效期
                .compact();
    }
    public  static Claims parseJWT(String jwt){
        return Jwts.parser()
                .setSigningKey("junyi")
                .parseClaimsJws(jwt)
                .getBody();
    }
}
