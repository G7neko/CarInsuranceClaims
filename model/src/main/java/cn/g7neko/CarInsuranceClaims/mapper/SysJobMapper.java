package cn.g7neko.CarInsuranceClaims.mapper;


import cn.g7neko.CarInsuranceClaims.pojo.SysDept;
import cn.g7neko.CarInsuranceClaims.pojo.SysJob;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

public interface SysJobMapper extends BaseMapper<SysJob> {
    int deleteByPrimaryKey(Long jobid);

    int insert(SysJob record);

    int insertSelective(SysJob record);

    SysJob selectByPrimaryKey(Long jobid);

    int updateByPrimaryKeySelective(SysJob record);

    int updateByPrimaryKey(SysJob record);
}