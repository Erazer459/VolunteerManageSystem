package DAO.intf;

import main.domain.Activiti;
import main.domain.StuWorkCheck;
import main.domain.Student;
import main.domain.manager;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface ManagerDao {
     manager finManagerById(manager manager);
     void insertStuMsg(Student student);
    int findTotalCount(Map<String, String[]> condition);
    /**
     * 查询总记录数
     */
    List<Student> findByPage(int start, int rows, Map<String, String[]> condition);
    /**
     *查询每页数据
     */
    void delete(String id);
    Student findById(String id);
    void update(Student student);
    void setStuBan(Date bantime, String type, String id);
    void notBanStudent(String id);

    void inserAcnm(String title, String content,Date publish_time);
    void UpDateAncmById(String id, String title, String content, Date publish_time);

    void delAncmById(String id);

    List<Activiti> findAllUknownAct();

    Activiti finActiById(String id);

    void confirmActi(String pass, String id);

    List<Activiti> finAllActi();
    List<Activiti> ActifindByPage(int start, int rows, Map<String, String[]> condition);
    public int ActifindTotalCount(Map<String, String[]> condition);
    void delActiById(String id);

    int StuActifindTotalCount(Map<String, String[]> condition,String id);

    List<Activiti> StuActifindByPage(int start, int rows, Map<String, String[]> condition,String id);

    int StuHavedJoinActifindTotalCount(String id);

    List<Activiti> StuHavedJoinActifindByPage(int start, int rows, String id);

    int StuHavedPublishActifindTotalCount(String id);

    List<Activiti> StuHavedPublishActifindByPage(int start, int rows, String id);

    int stuJoinActiTotalCount(String id);

    List<StuWorkCheck> stuJoinActiFindByPage(int start, int rows, String id);
}
