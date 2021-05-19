package cn.g7neko.CarInsuranceClaims.mapper;


import cn.g7neko.CarInsuranceClaims.pojo.SysDept;
import cn.g7neko.CarInsuranceClaims.pojo.SysUserJob;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

public interface SysUserJobMapper extends BaseMapper<SysUserJob> {
    int deleteByPrimaryKey(Integer id);

    int insert(SysUserJob record);

    int insertSelective(SysUserJob record);

    SysUserJob selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysUserJob record);

    int updateByPrimaryKey(SysUserJob record);
}