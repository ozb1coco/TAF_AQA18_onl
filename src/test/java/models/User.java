package models;

import lombok.*;

@Builder
@Getter
@ToString
@EqualsAndHashCode
public class User {
    private String firstname;
    private String lastname;
    private String zipCode;
    private String username;
    private String password;
}