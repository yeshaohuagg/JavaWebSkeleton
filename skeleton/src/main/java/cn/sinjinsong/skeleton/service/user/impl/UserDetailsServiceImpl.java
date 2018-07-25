package cn.sinjinsong.skeleton.service.user.impl;

import cn.sinjinsong.skeleton.domain.entity.user.UserDO;
import cn.sinjinsong.skeleton.enumeration.user.UserStatus;
import cn.sinjinsong.skeleton.security.domain.JWTUser;
import cn.sinjinsong.skeleton.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

/**
 * Created by SinjinSong on 2017/5/8.
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDO user = userService.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        //用户没有任何身份
        } else if (user.getRoles().isEmpty()) {
            throw new UsernameNotFoundException(username);
        }
        return new JWTUser(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getUserStatus() != UserStatus.UNACTIVATED,
                user.getUserStatus() != UserStatus.FORBIDDEN,
                true,
                true,
                user.getRoles().stream().map((r) -> new SimpleGrantedAuthority(r.getRoleName().toUpperCase())).collect(Collectors.toList())
        );
    }
}
