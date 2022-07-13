package service;

import main.domain.Activiti;
import main.domain.PageBean;
import main.domain.StuWorkCheck;
import main.domain.Student;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface Manager {
    public void insertStuMsg(Student student);
    //分页条件 查询
    public PageBean<Student> findStuByPage(String currentPage, String rows, Map<String, String[]> condition);
    void deleteStu(String id);
    Student findStuById(String id);
    void updateStu(Student student);
    void BanStudent(Date bantime, String type, String id);
    void notBanStudent(String id);
    void insertAncm(String title, String content,Date publish_time);
    void UpDateAncmById(String id,String title,String content,Date publish_time);
    void delAncmById(String id);

    List<Activiti> findAllUknownAct();

    Activiti finActiById(String id);

    void confirmActi(String pass, String id);

    List<Activiti> FindAllActi();

    PageBean<Activiti> findActiByPage(String currentPage, String rows, Map<String, String[]> condition);

    void delActiById(String id);

    PageBean<Activiti> StufindActiByPage(String currentPage, String rows, Map<String, String[]> condition, String id);

    PageBean<Activiti> findActiHavedJoinByPage(String currentPage, String rows, String id);

    PageBean<Activiti> findActiHavedPublishByPage(String currentPage, String rows, String id);

    PageBean<StuWorkCheck> ActiWorkCheck(String currentPage, String rows, String id);
}
