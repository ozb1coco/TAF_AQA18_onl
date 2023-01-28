package models;


public class User {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String zipCode;

    public static class Builder {
        private User newUser;


        public Builder() {
            newUser = new User();
        }


        public Builder withUsername(String value) {
            newUser.username = value;
            return this;
        }

        public Builder withPassword(String value) {
            newUser.password = value;
            return this;
        }

        public Builder withFirsName(String value) {
            newUser.firstName = value;
            return this;
        }

        public Builder withLastname(String value) {
            newUser.lastName = value;
            return this;
        }

        public Builder withZipCode(String value) {
            newUser.zipCode = value;
            return this;
        }

        public User build() {
            return newUser;
        }
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getZipCode() {
        return zipCode;
    }
}