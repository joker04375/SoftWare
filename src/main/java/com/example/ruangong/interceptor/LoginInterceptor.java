package com.example.ruangong.interceptor;

import com.example.ruangong.Utils.UserHolder;
import com.example.ruangong.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //1.获取session
        HttpSession session = request.getSession();
        //2.获取session中的用户
        Object user = session.getAttribute("user");
        log.info("user:"+user);
        //3.判断用户是否存在
        if(user==null){
            //不存在，拦截，返回401状态码
            response.setStatus(401);
            return false;
        }
        //存在，保存用户到ThreadLocal
        UserHolder.saveUser((User) user);

        if(UserHolder.getUser()==null){
            response.setStatus(401);
            return false;
        }
        //放行
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        UserHolder.removeUser();
    }
}
