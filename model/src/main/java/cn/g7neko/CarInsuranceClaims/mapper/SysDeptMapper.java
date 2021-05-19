package cn.g7neko.CarInsuranceClaims.mapper;


import cn.g7neko.CarInsuranceClaims.pojo.SysDept;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;


public interface SysDeptMapper extends BaseMapper<SysDept> {
    int deleteByPrimaryKey(Integer departmentid);

    int insert(SysDept record);

    int insertSelective(SysDept record);

    SysDept selectByPrimaryKey(Integer departmentid);

    int updateByPrimaryKeySelective(SysDept record);

    int updateByPrimaryKey(SysDept record);
}