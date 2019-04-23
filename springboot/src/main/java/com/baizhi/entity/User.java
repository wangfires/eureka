package com.baizhi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class User {
    private String id;
    private String username;
    private String realname;
    private String password;
    private String sex;
}
