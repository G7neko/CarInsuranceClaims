package cn.g7neko.CarInsuranceClaims.springSecurity;

import cn.g7neko.CarInsuranceClaims.util.Msg;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//登陆失败返回给前端信息
@Component
public class AuthenticationFailure implements AuthenticationFailureHandler {

    @Autowired
    Gson gson;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        Msg msg= Msg.fail("");
        if(e instanceof UsernameNotFoundException){
            msg=Msg.fail("输入的用户名不存在");
        }else if(e instanceof BadCredentialsException){
            msg=Msg.fail("输入的密码有误");
        }else{
            msg= Msg.fail(e.getMessage());
        }
        //处理回应的字符格式
        response.setContentType("text/json;charset=utf-8");
        //将信息返回给前端
        response.getWriter().write(gson.toJson(msg));
    }
}
