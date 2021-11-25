package com.example.quotesrestapi.authentication;

import com.example.quotesrestapi.model.User;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AuthServiceHandler implements HandlerInterceptor {
    @Override
    public boolean preHandle
            (HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String token = request.getHeader("x-api-key");
        try{
            User user = new User(token);
            if(user.isCallValid()){
                user.updateCalls();
                System.out.println(user.toString());
                response.setStatus(200);
                return true;
            }
            response.setStatus(402);
            return false;
        } catch (Exception e) {
            e.printStackTrace();

        }
        response.setStatus(404);
        return false;
    }
}
