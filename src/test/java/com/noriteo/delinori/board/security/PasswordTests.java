package com.noriteo.delinori.board.security;


import com.noriteo.delinori.board.config.BoardRootConfig;
import com.noriteo.delinori.common.config.RootConfig;
import com.noriteo.delinori.security.config.SecurityConfig;
import com.noriteo.delinori.security.domain.Member;
import com.noriteo.delinori.security.mapper.MemberMapper;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {RootConfig.class, SecurityConfig.class})
public class PasswordTests {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired(required = false)
    MemberMapper memberMapper;

    @Test
    public void testMember() {
        String mid = "deli1";

        Member member = memberMapper.findByMid(mid);

        log.warn("----------------------");
        log.warn(member);
    }

    @Test
    public void insertMemberRole() {

        String sql = "insert into tbl_member_role (mid, role) values('%s','%s');";

        for(int i = 25; i<40; i++) {
            String result=String.format(sql, "user  "+i, "ROLE_MEMBER");

            System.out.println(result);
        }
    }

    @Test
    public void insertAdmin() {
        //insert into tbl_member (mid, mpw, mname) values ('mid','mpw','mname');

        String query = "insert into member (mid, mpw, mname, maddress, memail, mphone) values ('v1','v2','v3','v4','v5','v6');";

        for (int i=0; i<10; i++) {

            String mid = "admin"+i; //user0
            String mpw = passwordEncoder.encode("pw"+i); //pw -> Bcrypted
            String mname = "관리자" +i; //유저0
            String maddress = "우리집"+i;
            String memail = "abc@123" +i;
            String mphone = "123-4567-8910"+i;


            String result = query;

            result = result.replace("v1",mid);
            result = result.replace("v2",mpw);
            result = result.replace("v3",mname);
            result = result.replace("v4",maddress);
            result = result.replace("v5",memail);
            result = result.replace("v6",mphone);

            System.out.println(result);
        }
    }

    @Test
    public void insertNori() {
        //insert into tbl_member (mid, mpw, mname) values ('mid','mpw','mname');

        String query = "insert into member (mid, mpw, mname, maddress, memail, mphone) values ('v1','v2','v3','v4','v5','v6');";

        for (int i=0; i<10; i++) {

            String mid = "deli1"+i; //user0
            String mpw = passwordEncoder.encode("pw"+i); //pw -> Bcrypted
            String mname = "딜리" +i; //유저0
            String maddress = "우리집"+i;
            String memail = "abc@123" +i;
            String mphone = "123-4567-8910"+i;


            String result = query;

            result = result.replace("v1",mid);
            result = result.replace("v2",mpw);
            result = result.replace("v3",mname);
            result = result.replace("v4",maddress);
            result = result.replace("v5",memail);
            result = result.replace("v6",mphone);

            System.out.println(result);
        }
    }


    @Test
    public void testEncode() {
        String str = "deli1";
        String enStr = passwordEncoder.encode(str);//내 패스워드를 암호화 하는것
        log.warn(enStr);
    }

    @Test
    public void testDecode() {
        String str = "$2a$10$ISQki5FQkZuBUgYq6HRQBOUNHI4wQmPvUe0YbsIGItl9k2Ar0r0vy";

        boolean match = passwordEncoder.matches("deli1",str);

        log.warn(match);
    }

}
