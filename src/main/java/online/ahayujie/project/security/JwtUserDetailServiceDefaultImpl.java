package online.ahayujie.project.security;

import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import online.ahayujie.project.security.jwt.TokenProvider;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 默认实现例子
 * @author aha
 * @date 2020/4/22
 */
@Slf4j
@Service
public class JwtUserDetailServiceDefaultImpl implements JwtUserDetailService {
    private final PasswordEncoder passwordEncoder;

    public JwtUserDetailServiceDefaultImpl(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities(Claims claims) {
        return Arrays.stream(claims.get("auth").toString().split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (!"aha".equals(username)) {
            throw new UsernameNotFoundException("用户不存在");
        }
        List<GrantedAuthority> authorityList = new ArrayList<>();
        authorityList.add(new SimpleGrantedAuthority("admin"));
        authorityList.add(new SimpleGrantedAuthority("guest"));
        return new User(username, passwordEncoder.encode("123456"), authorityList);
    }

}
