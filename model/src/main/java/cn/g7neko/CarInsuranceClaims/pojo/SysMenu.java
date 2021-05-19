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
public class SysMenu  implements Serializable {
    private Integer menuId;

    private Integer parentId;

    private String name;

    private String url;

    private String icon;

}