package cn.g7neko.CarInsuranceClaims.mapper;

import cn.g7neko.CarInsuranceClaims.pojo.SysDept;
import cn.g7neko.CarInsuranceClaims.pojo.SysJobLeval;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

public interface SysJobLevalMapper extends BaseMapper<SysJobLeval> {
    int deleteByPrimaryKey(Long joblevalid);

    int insert(SysJobLeval record);

    int insertSelective(SysJobLeval record);

    SysJobLeval selectByPrimaryKey(Long joblevalid);

    int updateByPrimaryKeySelective(SysJobLeval record);

    int updateByPrimaryKey(SysJobLeval record);
}