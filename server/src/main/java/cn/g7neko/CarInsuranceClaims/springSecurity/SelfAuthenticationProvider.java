package cn.g7neko.CarInsuranceClaims.springSecurity;

import cn.g7neko.CarInsuranceClaims.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * 自定义认证逻辑处理
 * @DDTO:　ｋｋ
 */
@Component
public class SelfAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    UserService userService;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String account=authentication.getName();
        String password=(String)authentication.getCredentials();
        System.out.println("当前登陆用户的信息"+account+"/n"+password);
        //调用自定义的UserDetails对象
        UserDetails userDetails =userService.loadUserByUsername(account);
        //判断当前userDetails对象
        boolean checkPassword = bCryptPasswordEncoder.matches(password,userDetails.getPassword());

        if(!checkPassword){
            throw new BadCredentialsException("密码不正确,请重新输入...");
        }
        return new UsernamePasswordAuthenticationToken(account,password,userDetails.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
