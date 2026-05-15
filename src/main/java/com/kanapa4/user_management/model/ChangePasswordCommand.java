package com.kanapa4.user_management.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ChangePasswordCommand {
    private String password;
}
