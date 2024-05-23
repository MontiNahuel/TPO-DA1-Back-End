package org.uade.da1.model.dto;

public class UserDTO {
    private String userName;
    private String password;

    public UserDTO(String userName, String password, String rol) {
        super();
        this.userName = userName;
        this.password = password;
    }

    public UserDTO() {
        super();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserDTO [userName=" + userName + ", password=" + password + "]";
    }

}

