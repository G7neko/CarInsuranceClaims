package cn.g7neko.CarInsuranceClaims.mapper;


import cn.g7neko.CarInsuranceClaims.pojo.SysDept;
import cn.g7neko.CarInsuranceClaims.pojo.SysMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

public interface SysMenuMapper extends BaseMapper<SysMenu> {
    int deleteByPrimaryKey(Integer menuId);

    int insert(SysMenu record);

    int insertSelective(SysMenu record);

    SysMenu selectByPrimaryKey(Integer menuId);

    int updateByPrimaryKeySelective(SysMenu record);

    int updateByPrimaryKey(SysMenu record);
}