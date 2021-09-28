package com.noriteo.delinori.security.dto;

import com.noriteo.delinori.security.domain.Member;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.stream.Collectors;

@Getter
@Setter
@ToString
public class MemberDTO extends User {

    private String mid;
    private String mpw;
    private String mname;
    private String maddress;
    private String memail;
    private String mphone;
    private boolean enable;
    private boolean delifile;
    private int replyCnt;

    public MemberDTO(Member member) {
        super(member.getMid(),
                member.getMpw(),
                member.getRoleList().stream().map(memberRole ->
                        new SimpleGrantedAuthority(memberRole.getRole())).collect(Collectors.toList()) );

        this.mid = member.getMid();
        this.mpw = member.getMpw();
        this.mname = member.getMname();
        this.maddress = member.getMaddress();
        this.memail = member.getMemail();
        this.mphone = member.getMphone();
        this.enable = member.isEnable();
        this.delifile = member.isDelifile();
        this.replyCnt = member.getReplyCnt();

    }

    public MemberDTO(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

}
