package main.domain;

import java.util.Date;

public class Student {
    private String  id;
    private String username;
    private String password;
    private String gender;
    private String classname;
    private Integer latetimes;
    private Integer absenttimes;
    private Date bantime;
    private String email;
    private String phone;
    private String ban;
    private String bantype;
    public String getBantype() {
        return bantype;
    }

    public void setBantype(String bantype) {
        this.bantype = bantype;
    }

    public String getBan() {
        return ban;
    }

    public void setBan(String ban) {
        this.ban = ban;
    }

    public void setLatetimes(Integer latetimes) {
        this.latetimes = latetimes;
    }

    public void setAbsenttimes(Integer absenttimes) {
        this.absenttimes = absenttimes;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getBantime() {
        return bantime;
    }
    public void setBantime(Date bantime) {
        this.bantime = bantime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public Integer getLatetimes() {
        return latetimes;
    }

    public void setLatetimes(int latetimes) {
        this.latetimes = latetimes;
    }

    public Integer getAbsenttimes() {
        return absenttimes;
    }

    public void setAbsenttimes(int absenttimes) {
        this.absenttimes = absenttimes;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
                ", classname='" + classname + '\'' +
                ", latetimes=" + latetimes +
                ", absenttimes=" + absenttimes +
                '}';
    }
}
