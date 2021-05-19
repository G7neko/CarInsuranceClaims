package cn.g7neko.CarInsuranceClaims.test;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class Password {

    public static void main(String[] args) {
        PasswordEncoder pw= new BCryptPasswordEncoder();
        //加密
        String encode=pw.encode("123");
        System.out.println(encode);
        //$2a$10$rlmMOx88kp.QxgZNrh0v5euXM.BSdX8HaEb5L9xkFffezqOGzcnOO
    }


}
