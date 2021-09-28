package com.noriteo.delinori.security.domain;

import lombok.*;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Member {

        private String mid;
        private String mpw;
        private String mname;
        private String maddress;
        private String memail;
        private String mphone;
        private boolean enable;
        private boolean delifile;
        private int replyCnt;

        private List<MemberRole> roleList;

}
