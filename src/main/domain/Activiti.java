package main.domain;

import java.util.Date;

public class Activiti {
    private String title;//活动标题
    private String content;//活动描述
    private Date time;//活动时间
    private String place;//活动地点
    private String peopleLimit;//人数限制
    private String host;//活动发起人
    private String point;//参加获得分数
    private Integer id;//活动id
    private String classname;//若以班级名义发起的志愿活动，则发起者为班级
    private String Pass;//审核是否通过
    private Integer numofPeople;//已参加人数
    private String WorkCheck;//是否已经开始考勤
    private String type;//活动类型，由班级发起还是由个人发起
    private String hostid;//活动发起人id
    private String state;//活动状态

    public String getWorkCheck() {
        return WorkCheck;
    }

    public void setWorkCheck(String workCheck) {
        WorkCheck = workCheck;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getPeopleLimit() {
        return peopleLimit;
    }

    public void setPeopleLimit(String peopleLimit) {
        this.peopleLimit = peopleLimit;
    }

    public String  getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String pass) {
        Pass = pass;
    }

    public Integer getNumofPeople() {
        return numofPeople;
    }

    public void setNumofPeople(Integer numofPeople) {
        this.numofPeople = numofPeople;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHostid() {
        return hostid;
    }

    public void setHostid(String hostid) {
        this.hostid = hostid;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
