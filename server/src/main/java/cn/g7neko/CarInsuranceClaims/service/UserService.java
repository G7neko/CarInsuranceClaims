package cn.g7neko.CarInsuranceClaims.service;

import cn.g7neko.CarInsuranceClaims.mapper.SysUserMapper;
import cn.g7neko.CarInsuranceClaims.pojo.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserService extends IService<SysUser> {

    Integer userLogin(SysUser user);

    UserDetails loadUserByUsername(String s);
}
