package com.tyza66.greenbelt.entity;

import lombok.Data;

/**
 * Author: tyza66
 * Date: 2023/05/04 12:08
 * Github: https://github.com/tyza66
 **/
@Data
public class User {
    int id;
    String account;
    String password;
    String username;
    String nickname;
    int statu;
}
