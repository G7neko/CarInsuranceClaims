package cn.g7neko.CarInsuranceClaims.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SysUser implements Serializable {
    private Integer userId;

    private String name;

    private String username;

    private String password;

    private String jobnumber;

    private Integer departmentid;

    private Integer joblevalid;

    private Integer jobid;

    private String sex;

    private String salt;

    private String edu;

    private String email;

    private String address;

    private Integer jobstate;

    private String telephone;

    private Date mountguardtime;

    private Date bedemobilizedtime;

    private Date birthday;

    private String remarks;

}