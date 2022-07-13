package DAO.imp;

import DAO.intf.StudentDao;
import main.Utils.JDBCUtils;
import main.domain.Activiti;
import main.domain.Student;
import main.domain.ancm;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class StudentDaoImp implements StudentDao {
private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public Student findStudentById(Student student) {
        try {
            String sql="select * from student where id = ? and password = ?";
            Student stu=template.queryForObject(sql,new BeanPropertyRowMapper<Student>(Student.class),student.getId(),student.getPassword());
            return stu;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<ancm> findAllAncm() {
        String sql="select id,publish_time,title from ancm";
        return template.query(sql,new BeanPropertyRowMapper<ancm>(ancm.class));
    }

    @Override
    public ancm finAcnmById(String id) {
        String sql="select * from ancm where id=?";
        return template.queryForObject(sql,new BeanPropertyRowMapper<ancm>(ancm.class),id);
    }

    @Override
    public void upDate(String gender, String phone, String email) {
        String sql="update student set gender=?,phone=?,email=?";
        template.update(sql,gender,phone,email);
    }

    @Override
    public void upDatePassword(String id, String password) {
        String sql="update student set password=? where id=?";
        template.update(sql,password,id);
    }

    @Override
    public void inserActi(Activiti activiti) {
        String sql="insert into activiti(title,content,place,peopleLimit,host,point,classname,type,WorkCheck,numofPeople,time,pass,hostid,state) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        template.update(sql,activiti.getTitle(),activiti.getContent(),activiti.getPlace(),activiti.getPeopleLimit(),activiti.getHost(),activiti.getPoint(),activiti.getClassname(),activiti.getType(),activiti.getWorkCheck(),activiti.getNumofPeople(),activiti.getTime(),activiti.getPass(),activiti.getHostid(),activiti.getState());
    }

    @Override
    public void Application(String actiId, String userId, String check, int num) {
        String sql="insert into midtable(ActiId,userId,WorkCheck) values (?,?,?)";
        String sql1="update activiti set numofPeople=? where id=?";
        template.update(sql,actiId,userId,check);
        template.update(sql1,num+1,actiId);
    }

    @Override
    public void startworkCheck(String id) {
        String sql="update activiti set WorkCheck=?,State=? where id=?";
        template.update(sql,"check","已开始",id);
    }

    @Override
    public void stuWorkCheck(String actiId, String userId) {
        String sql="update midtable set WorkCheck=? where ActiId=? and userId=?";
       template.update(sql,"已考勤",actiId,userId);
    }

    @Override
    public void stopWorkCheck(String id) {
        String sql="update activiti set WorkCheck=? where id=?";
        template.update(sql,"unCheck",id);
    }

    @Override
    public void dealUnchekStu(String userid, String type,String actiId) {
        System.out.println(userid+"0000"+type+"0000"+actiId);
        if(type.equals("迟到")){
            String sql="update student set latetimes=latetimes+1  where id=?";
            int a=template.update(sql,userid);
            System.out.println(a);
            String sql1="update midtable set WorkCheck=? where userId=? and ActiId=?";
            template.update(sql1,type,userid,actiId);
        }
        if(type.equals("缺勤")){
            String sql="update student set absenttimes=absenttimes+1 where id=?";
            template.update(sql,userid);
            String sql1="update midtable set WorkCheck=? where userId=? and ActiId=?";
            template.update(sql1,type,userid,actiId);
        }else{
            return;
        }
    }
}
