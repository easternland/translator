package com.project.translator.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "Translator_User")
public class User {

    private User() {}

    public User(String password, String login, String name, Integer height) {
        this.password = password;
        this.login = login;
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    int id;

    @NotNull
    String name;

    @NotNull
    String login;

    @NotNull
    String password;

    @Nullable
    Integer height;

    public static class Builder {
        String name;
        String login;
        String password;
        Integer height;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder login(String login) {
            this.login = login;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder height(Integer height) {
            this.height = height;
            return this;
        }

        public User build() {
            return new User(this.password, this.login, this.name, this.height);
        }
    }

    /*

    User u = new User.Builder()
    .name("")
    .login("")
    .password("")
    .build();

     */

}