package cn.g7neko.CarInsuranceClaims.service.impl;

import cn.g7neko.CarInsuranceClaims.mapper.SysUserMapper;
import cn.g7neko.CarInsuranceClaims.pojo.SysUser;
import cn.g7neko.CarInsuranceClaims.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;

@Service
public class UserServiceimpl extends ServiceImpl<SysUserMapper, SysUser> implements UserService, UserDetailsService {

    @Autowired
    private  SysUserMapper sysUserMapper;


    @Override
    public Integer userLogin(SysUser user) {
        return sysUserMapper.userLogin(user);
    }


    //SpringSecurity主要的用户认证方法
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        QueryWrapper<SysUser> wrapper = new QueryWrapper<>();
        wrapper.eq("username",s);
        SysUser user = sysUserMapper.selectOne(wrapper); //将查询条件放入查询
        if(null == user){
            throw  new UsernameNotFoundException("用户名错误...");
        }
        //获取用户权限，并把其添加到GrantedAuthority中
        List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();

        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(String.valueOf(user.getJobid()));
        grantedAuthorityList.add(grantedAuthority);

        //方法的返回值要求返回UserDetails这个数据类型 UserDetails是借口,找它的实现类
        return new User(s,user.getPassword(),grantedAuthorityList);
    }




}
