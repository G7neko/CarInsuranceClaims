package cn.g7neko.CarInsuranceClaims.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SysDept implements Serializable {
    private Integer departmentid;

    private String departmentname;

}