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
public class SysMenuJob implements Serializable {
    private Integer id;

    private Integer jobId;

    private Integer menuId;

}