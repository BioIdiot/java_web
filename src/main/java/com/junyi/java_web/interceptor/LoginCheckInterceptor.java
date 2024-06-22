package com.junyi.java_web.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.junyi.java_web.controller.Result;
import com.junyi.java_web.utils.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
@Component
public class LoginCheckInterceptor implements HandlerInterceptor {
    @Override //目标资源运行前运行
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        try {
            String token = request.getParameter("token");
            JwtUtils.parseJWT(token);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
        //1、获取token
        String jwt = request.getHeader("token");
        //2、解析token，解析失败则返回未登录
            JwtUtils.parseJWT(jwt);
        } catch (Exception e) {
            e.printStackTrace();
            Result erro = new Result(-1,"not login");
            String not_login = mapper.writeValueAsString(erro);
            response.getWriter().write(not_login);
            response.sendRedirect("/");
            return false;
        }
        return true;
    }

    @Override //目标资源运行后运行
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("目标资源运行后运行");
    }

    @Override //视图渲染完后运行
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("视图渲染完后运行");
    }
}
