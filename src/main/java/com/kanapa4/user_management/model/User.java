package com.kanapa4.user_management.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    private long id;
    private String pseudonym;
    private String email;
    private String password;

    public void update(User user) {
        this.id = user.getId();
        this.pseudonym = user.getPseudonym();
        this.email = user.getEmail();
        this.password = user.getPassword();
    }
}
