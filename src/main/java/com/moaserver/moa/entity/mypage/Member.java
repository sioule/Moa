package com.moaserver.moa.entity.mypage;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.moaserver.moa.entity.cash.Cash;
import com.moaserver.moa.entity.cash.Mileage;
import com.moaserver.moa.entity.goal.Goal;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Member {

    @Id @GeneratedValue(strategy = IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false)
    private String email;       //아이디

    @Column(nullable = false)
    private String password;

    private String userSchool;

    private double latitude;

    private double longitude;

    private String userResidence;

    @OneToOne
    @JoinColumn(name = "cash_id")
    private Cash cash;

    @OneToOne
    @JoinColumn(name = "mileage_id")
    private Mileage mileage;



    @OneToMany(mappedBy = "member")
    private List<Goal> goals = new ArrayList<>();


    @Builder
    public Member(String nickname, String email, String password, String userSchool){

        this.nickname = nickname;
        this.email = email;
        this.password = password;
        this.userSchool = userSchool;

    }




    public void SchoolUpdate(String userSchool, double latitude, double longitude){

        this.userSchool = userSchool;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public void ProfileUpdate(String nickname, String password){
        this.nickname = nickname;
        this.password = password;
    }

}
