package com.br.uni.edu.jogoDaVelha.requests;

import java.io.Serializable;
import java.util.Date;

public class CreatePlayerRequest implements Serializable {
    private String nickname;
    private String email;
    private String password;

    public CreatePlayerRequest() {
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
