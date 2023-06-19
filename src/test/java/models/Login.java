package models;

import lombok.Data;

@Data
public class Login {

    String email, password;

@Data
public class LoginResponse {

    String id, token;
}
}

