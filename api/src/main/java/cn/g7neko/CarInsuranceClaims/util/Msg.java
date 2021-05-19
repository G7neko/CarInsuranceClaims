package cn.g7neko.CarInsuranceClaims.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Msg {

    Integer code; //错误状态码
    String Message; //消息提示
    Map<String,Object> data=new HashMap<>(); //数据

    //没有权限访问资源
    public static Msg denyAccess(String message){
        Msg result=new Msg();
        result.setCode(300);
        result.setMessage(message);
        return result;
    }

    //登陆成功
    public  static  Msg success(String message){
        Msg result = new Msg();
        result.setCode(200);
        result.setMessage(message);
        return  result;
    }

    //客户端操作失败
    public static Msg fail(String message){
        Msg result=new Msg();
        result.setCode(400);
        result.setMessage(message);
        return result;
    }

    public Msg add(String key,Object value){
        this.data.put(key,value);
        return this;
    }


}
