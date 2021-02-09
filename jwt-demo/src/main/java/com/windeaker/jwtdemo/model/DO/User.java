package com.windeaker.jwtdemo.model.DO;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Long id;
    private String pubId;
    private String name;
    private String headImg;
    private String phone;
    private String sign;
    private Integer sex;
    private String city;
    private Date cteateTime;
}
