package cn.g7neko.CarInsuranceClaims.mapper;


import cn.g7neko.CarInsuranceClaims.pojo.SysDept;
import cn.g7neko.CarInsuranceClaims.pojo.SysMenuJob;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

public interface SysMenuJobMapper extends BaseMapper<SysMenuJob> {
    int deleteByPrimaryKey(Integer id);

    int insert(SysMenuJob record);

    int insertSelective(SysMenuJob record);

    SysMenuJob selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysMenuJob record);

    int updateByPrimaryKey(SysMenuJob record);
}