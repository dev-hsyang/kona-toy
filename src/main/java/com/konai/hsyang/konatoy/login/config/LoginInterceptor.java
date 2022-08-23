package com.konai.hsyang.konatoy.login.config;

import com.konai.hsyang.konatoy.login.config.auth.PrincipalDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
public class LoginInterceptor implements HandlerInterceptor {

    //private final HttpSession httpSession;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        System.out.println("pre handler");
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        System.out.println("post handler");

        if(SecurityContextHolder.getContext().getAuthentication()!=null){
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            modelAndView.addObject("auth", auth.getPrincipal()!="anonymousUser");
            modelAndView.addObject("user", auth.getName() + "님, 반갑습니다.");
        }
        //System.out.println("post handler auth: " + auth.getPrincipal());

//        if(request.getSession().getAttribute("user")!=null){
//            modelAndView.addObject("user", "user");
//        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        System.out.println("interceptor --- afterCompletion");
    }
}
