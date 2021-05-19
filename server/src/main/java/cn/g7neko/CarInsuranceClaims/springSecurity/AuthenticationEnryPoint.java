package cn.g7neko.CarInsuranceClaims.springSecurity;

import cn.g7neko.CarInsuranceClaims.util.Msg;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthenticationEnryPoint implements AuthenticationEntryPoint {

    @Autowired
    Gson gson;

    //未登录将响应信息给前端
    @Override
    public void commence(HttpServletRequest req, HttpServletResponse reps, AuthenticationException e) throws IOException, ServletException {
            Msg res= Msg.fail("请先登陆在访问..");
            reps.setContentType("application/json;charset=utf-8");
            reps.getWriter().write(gson.toJson(res));
    }

}
