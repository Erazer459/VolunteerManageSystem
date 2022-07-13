package main.domain;

import org.springframework.beans.BeanUtils;

public class StuWorkCheck {
    private String id;
    private String username;
    private String WorkCheck;
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String name) {
        this.username = name;
    }

    public String getWorkCheck() {
        return WorkCheck;
    }

    public void setWorkCheck(String workCheck) {
        WorkCheck = workCheck;
    }
}
