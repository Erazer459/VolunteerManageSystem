package DAO.imp;

import DAO.intf.ManagerDao;
import main.Utils.JDBCUtils;
import main.domain.Activiti;
import main.domain.StuWorkCheck;
import main.domain.Student;
import main.domain.manager;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.*;

public class ManagerDaoImp implements ManagerDao {
    private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public manager finManagerById(manager manager) {
        try {
            String sql="select * from manager where id = ? and password = ?";
            manager manager1=template.queryForObject(sql,new BeanPropertyRowMapper<manager>(manager.class),manager.getId(),manager.getPassword());
            return manager1;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void insertStuMsg(Student student) {
        String sql="insert into student(id,username,password,gender,classname,email,phone,latetimes,absenttimes,ban,bantime,bantype) values(?,?,?,?,?,?,?,?,?,?,?,?)";
        template.update(sql,student.getId(),student.getUsername(),student.getPassword(),student.getGender(),student.getClassname(),student.getEmail(),student.getPhone(),0,0,student.getBan(),student.getBantime(),student.getBantype());
    }

    @Override
    public int findTotalCount(Map<String, String[]> condition) {
        //定义模板sql
        String sql="select count(*) from student where 1 = 1 ";
        StringBuilder sb=new StringBuilder(sql);
        //遍历map
        Set<String> keySet=condition.keySet();
        //定义参数的集合
        List<Object> params=new ArrayList<Object>();
        for(String key: keySet){
            //排除分页
            if("currentPage".equals(key)||"rows".equals(key)){
                continue;
            }
        String value=condition.get(key)[0];
        //判断value是否有值
            if(value!=null&&!"".equals(value)){
                sb.append(" and "+key+" like ? ");
                params.add("%"+value+"%");//?条件的值
            }
        }
        return template.queryForObject(sb.toString(),Integer.class,params.toArray());
    }

    @Override
    public List<Student> findByPage(int start, int rows, Map<String, String[]> condition) {
        String sql="select * from student where 1=1 ";
        StringBuilder sb=new StringBuilder(sql);
        //遍历map
        Set<String> keySet=condition.keySet();
        //定义参数的集合
        List<Object> params=new ArrayList<Object>();
        for(String key: keySet){
            //排除分页
            if("currentPage".equals(key)||"rows".equals(key)){
                continue;
            }
            String value=condition.get(key)[0];
            //判断value是否有值
            if(value!=null&&!"".equals(value)){
                sb.append(" and "+key+" like ? ");
                params.add("%"+value+"%");//?条件的值
            }
        }
        //添加分页
        sb.append(" limit ?,? ");
        //添加分页查询参数
        params.add(start);
        params.add(rows);
        sql=sb.toString();
        System.out.println(sql);
        return template.query(sql,new BeanPropertyRowMapper<Student>(Student.class),params.toArray());
    }

    @Override
    public void delete(String id) {
        String sql="delete from student where id= ?";
        template.update(sql,id);
    }

    @Override
    public Student findById(String id) {
        String sql="select * from student where id= ?";
        return template.queryForObject(sql,new BeanPropertyRowMapper<Student>(Student.class),id);
    }

    @Override
    public void update(Student student) {
        String sql="update student set username=?,gender=?,password=?,classname=?,phone=?,email=? where id=?";
        template.update(sql,student.getUsername(),student.getGender(),student.getPassword(),student.getClassname(),student.getPhone(),student.getEmail(),student.getId());
    }

    @Override
    public void setStuBan(Date bantime, String type, String id) {
        String sql="update student set ban=? ,bantime=? , bantype=? where id=?";
      int i= template.update(sql,"ban",bantime,type,id);
    }

    @Override
    public void notBanStudent(String id) {
        String sql="update student set ban=? , bantime=? , bantype=? where id=?";
        template.update(sql,"notban",null,null,id);
    }

    @Override
    public void inserAcnm(String title, String content,Date publish_time) {
        String sql="insert into ancm(title,content,publish_time) values(?,?,?) ";
        template.update(sql,title,content,publish_time);
    }

    @Override
    public void UpDateAncmById(String id, String title, String content, Date publish_time) {
        String sql="update ancm set title=? , content=? , publish_time=? where id=?";
        template.update(sql,title,content,publish_time,id);
    }

    @Override
    public void delAncmById(String id) {
        String sql="delete from ancm where id=?";
        template.update(sql,id);
    }

    @Override
    public List<Activiti> findAllUknownAct() {
        String sql="select * from activiti where pass=?";
        return template.query(sql,new BeanPropertyRowMapper<Activiti>(Activiti.class),"unknown");
    }

    @Override
    public Activiti finActiById(String id) {
        String sql="select * from activiti where id=?";
        return template.queryForObject(sql,new BeanPropertyRowMapper<Activiti>(Activiti.class),id);
    }

    @Override
    public void confirmActi(String pass, String id) {
        String sql="update activiti set pass=? where id=?";
        template.update(sql,pass,id);
    }

    @Override
    public List<Activiti> finAllActi() {
        String sql="select * from activiti";
       return template.query(sql,new BeanPropertyRowMapper<Activiti>(Activiti.class));
    }

    @Override
    public List<Activiti> ActifindByPage(int start, int rows, Map<String, String[]> condition) {
        String sql="select * from activiti where 1=1 ";
        StringBuilder sb=new StringBuilder(sql);
        //遍历map
        Set<String> keySet=condition.keySet();
        //定义参数的集合
        List<Object> params=new ArrayList<Object>();
        for(String key: keySet){
            //排除分页
            if("currentPage".equals(key)||"rows".equals(key)){
                continue;
            }
            String value=condition.get(key)[0];
            //判断value是否有值
            if(value!=null&&!"".equals(value)){
                sb.append(" and "+key+" like ? ");
                params.add("%"+value+"%");//?条件的值
            }
        }
        //添加分页
        sb.append(" limit ?,? ");
        //添加分页查询参数
        params.add(start);
        params.add(rows);
        sql=sb.toString();
        return template.query(sql,new BeanPropertyRowMapper<Activiti>(Activiti.class),params.toArray());
    }

    @Override
    public int ActifindTotalCount(Map<String, String[]> condition) {
        //定义模板sql
        String sql="select count(*) from activiti where 1 = 1 ";
        StringBuilder sb=new StringBuilder(sql);
        //遍历map
        Set<String> keySet=condition.keySet();
        //定义参数的集合
        List<Object> params=new ArrayList<Object>();
        for(String key: keySet){
            //排除分页
            if("currentPage".equals(key)||"rows".equals(key)){
                continue;
            }
            String value=condition.get(key)[0];
            //判断value是否有值
            if(value!=null&&!"".equals(value)){
                sb.append(" and "+key+" like ? ");
                params.add("%"+value+"%");//?条件的值
            }
        }
        return template.queryForObject(sb.toString(),Integer.class,params.toArray());
    }

    @Override
    public void delActiById(String id) {
        String sql="delete from activiti where id=?";
        template.update(sql,id);
        String sql1="delete from midtable where ActiId=?";
        template.update(sql1,id);
    }

    @Override
    public int StuActifindTotalCount(Map<String, String[]> condition,String id) {
        String sql="select COUNT(*) from activiti act where numofPeople < peopleLimit AND  act.id NOT IN (select ActiId from midtable where userId=?) and act.state='未开始' and act.pass='pass'";
        StringBuilder sb=new StringBuilder(sql);
        //遍历map
        Set<String> keySet=condition.keySet();
        //定义参数的集合
        List<Object> params=new ArrayList<Object>();
        for(String key: keySet){
            //排除分页
            if("currentPage".equals(key)||"rows".equals(key)){
                continue;
            }
            String value=condition.get(key)[0];
            //判断value是否有值
            if(value!=null&&!"".equals(value)){
                sb.append(" and "+key+" like ? ");
                params.add("%"+value+"%");//?条件的值
            }
        }
        return template.queryForObject(sb.toString(),Integer.class,id);
    }

    @Override
    public List<Activiti> StuActifindByPage(int start, int rows, Map<String, String[]> condition,String id) {
        String sql="select * from activiti act where numofPeople < peopleLimit AND  act.id NOT IN (select ActiId from midtable where userId=?) and act.state='未开始' and act.pass='passed' limit ?, ?";
        StringBuilder sb=new StringBuilder(sql);
        //遍历map
        Set<String> keySet=condition.keySet();
        //定义参数的集合
        List<Object> params=new ArrayList<Object>();
        for(String key: keySet){
            //排除分页
            if("currentPage".equals(key)||"rows".equals(key)){
                continue;
            }
            String value=condition.get(key)[0];
            //判断value是否有值
            if(value!=null&&!"".equals(value)){
                sb.append(" and "+key+" like ? ");
                params.add("%"+value+"%");//?条件的值
            }
        }
        //添加分页
        //sb.append(" limit ?,? ");
        //添加分页查询参数
        //params.add(start);
        //params.add(rows);
        //sql=sb.toString();
        return template.query(sql,new BeanPropertyRowMapper<Activiti>(Activiti.class),id,start,rows);
    }

    @Override
    public int StuHavedJoinActifindTotalCount(String id) {
        String sql="select COUNT(*) from midtable where userId = ?";
        return template.queryForObject(sql,Integer.class,id);
    }

    @Override
    public List<Activiti> StuHavedJoinActifindByPage(int start, int rows, String id) {
        String sql="select * from activiti where id IN (select ActiId from midtable where userId= ?) limit ?,? ";
        return template.query(sql,new BeanPropertyRowMapper<Activiti>(Activiti.class),id,start,rows);
    }

    @Override
    public int StuHavedPublishActifindTotalCount(String id) {
        String sql="select COUNT(*) from activiti where hostid=?";
        return template.queryForObject(sql,Integer.class,id);
    }

    @Override
    public List<Activiti> StuHavedPublishActifindByPage(int start, int rows, String id) {
        String sql="select * from activiti where hostid = ? limit ?,?";
        return template.query(sql,new BeanPropertyRowMapper<Activiti>(Activiti.class),id,start,rows);
    }

    @Override
    public int stuJoinActiTotalCount(String id) {
        String sql="select COUNT(*) from student stu JOIN midtable mit on stu.id=mit.userId and mit.ActiId=? ";
        return template.queryForObject(sql,Integer.class,id);
    }

    @Override
    public List<StuWorkCheck> stuJoinActiFindByPage(int start, int rows, String id) {
        String sql="select stu.id,stu.username,mit.WorkCheck from student stu JOIN midtable mit on stu.id=mit.userId and mit.ActiId=? limit ?,?";
        return template.query(sql,new BeanPropertyRowMapper<StuWorkCheck>(StuWorkCheck.class),id,start,rows);
    }
}
