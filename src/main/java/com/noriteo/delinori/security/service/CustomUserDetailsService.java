package com.noriteo.delinori.security.service;

import com.noriteo.delinori.security.domain.Member;
import com.noriteo.delinori.security.dto.MemberDTO;
import com.noriteo.delinori.security.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Log4j2
@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final MemberMapper memberMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        log.warn("CustomUserDetailsService-----------------------------------------");
        log.warn("CustomUserDetailsService-----------------------------------------");
        log.warn("CustomUserDetailsService-----------------------------------------");
        log.warn(username);//사용자가 있는지 없는지 확인 사용자가 없을수도 패스워드가 틀릴수도 있어서 저기 위에 보면 익셉션 던졌음
        log.warn(memberMapper);//주입이 됬는지 확인하려고
        log.warn("CustomUserDetailsService-----------------------------------------");
        log.warn("CustomUserDetailsService-----------------------------------------");

        Member member = memberMapper.findByMid(username);

        log.warn(member);

        if(member == null) {
            throw new UsernameNotFoundException("NOT EXIST");
        }

        String[] authorities = member.getRoleList().stream().map(memberRole -> memberRole.getRole()).toArray(String[]::new);

        User result = new MemberDTO(member);


        return result;
    }
}
