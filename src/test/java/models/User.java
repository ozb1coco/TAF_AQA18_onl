package models;


import lombok.*;
@Builder
@Getter
@ToString
@EqualsAndHashCode
public class User {

    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String zipCode;

}