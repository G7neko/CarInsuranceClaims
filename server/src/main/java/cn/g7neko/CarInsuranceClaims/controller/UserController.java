package cn.g7neko.CarInsuranceClaims.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户控制器层
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return "Hello!这是我的第一个车险理赔系统";
    }


}
