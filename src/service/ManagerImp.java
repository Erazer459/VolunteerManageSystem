package service;

import DAO.imp.ManagerDaoImp;
import DAO.intf.ManagerDao;
import main.domain.Activiti;
import main.domain.PageBean;
import main.domain.StuWorkCheck;
import main.domain.Student;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
public class ManagerImp implements Manager {
    ManagerDao dao=new ManagerDaoImp();
    @Override
    public void insertStuMsg(Student student) {
    dao.insertStuMsg(student);
    }

    @Override
    public PageBean<Student> findStuByPage(String _currentPage, String _rows, Map<String, String[]> condition) {
        int currentPage=Integer.parseInt(_currentPage);
        int rows=Integer.parseInt(_rows);
        PageBean<Student> pb=new PageBean<Student>();
        pb.setCurrentPage(currentPage);
        //调用dao查询
        int totalCount=dao.findTotalCount(condition);
        pb.setTotalCount(totalCount);
        //调用dao查询List集合
        //计算开始的记录索引
        int start=(currentPage-1)*rows;
        List<Student> list=dao.findByPage(start,rows,condition);
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
        Date currenttime=new Date(System.currentTimeMillis());
        //解封操作
        for(Student stu:list){
            if(stu.getBan().equals("ban")){
                if(stu.getBantime()!=null&&stu.getBantype().equals("temp")){
                    if(stu.getBantime().compareTo(currenttime)==-1||stu.getBantime().compareTo(currenttime)==0){
                       dao.notBanStudent(stu.getId());
                    }
                }
            }
        }
      list=dao.findByPage(start,rows,condition);
        pb.setList(list);
        //计算总页码
        int totalPage= totalCount%rows==0?totalCount/rows:totalCount/rows+1;
        pb.setTotalPage(totalPage);
        return pb;
    }

    @Override
    public void deleteStu(String id) {
        dao.delete(id);
    }

    @Override
    public Student findStuById(String id) {
        return dao.findById(id);
    }

    @Override
    public void updateStu(Student student) {
        dao.update(student);
    }

    @Override
    public void BanStudent(Date bantime, String type, String id) {
        dao.setStuBan(bantime,type,id);
    }

    @Override
    public void notBanStudent(String id) {
        dao.notBanStudent(id);
    }

    @Override
    public void insertAncm(String title, String content,Date publish_time) {
        dao.inserAcnm(title,content,publish_time);
    }

    @Override
    public void UpDateAncmById(String id,String title,String content,Date publish_time) {
        dao.UpDateAncmById(id,title,content,publish_time);
    }

    @Override
    public void delAncmById(String id) {
        dao.delAncmById(id);
    }

    @Override
    public List<Activiti> findAllUknownAct() {
         return dao.findAllUknownAct();
    }

    @Override
    public Activiti finActiById(String id) {
        return dao.finActiById(id);
    }

    @Override
    public void confirmActi(String pass, String id) {
        dao.confirmActi(pass,id);
    }

    @Override
    public List<Activiti> FindAllActi() {
       return dao.finAllActi();
    }

    @Override
    public PageBean<Activiti> findActiByPage(String currentPage, String rows, Map<String, String[]> condition) {
        int _currentPage=Integer.parseInt(currentPage);
        int _rows=Integer.parseInt(rows);
        PageBean<Activiti> pb=new PageBean<Activiti>();
        pb.setCurrentPage(_currentPage);
        //调用dao查询
        int totalCount=dao.ActifindTotalCount(condition);
        pb.setTotalCount(totalCount);
        //调用dao查询List集合
        //计算开始的记录索引
        int start=(_currentPage-1)*_rows;
        List<Activiti> list=dao.ActifindByPage(start,_rows,condition);
        list=dao.ActifindByPage(start,_rows,condition);
        pb.setList(list);
        //计算总页码
        int totalPage=totalCount%_rows==0?totalCount/_rows:totalCount/_rows+1;
        pb.setTotalPage(totalPage);
        return pb;
    }

    @Override
    public void delActiById(String id) {
        dao.delActiById(id);
    }

    @Override
    public PageBean<Activiti> StufindActiByPage(String currentPage, String rows, Map<String, String[]> condition, String id) {
        int _currentPage=Integer.parseInt(currentPage);
        int _rows=Integer.parseInt(rows);
        PageBean<Activiti> pb=new PageBean<Activiti>();
        pb.setCurrentPage(_currentPage);
        //调用dao查询
        int totalCount=dao.StuActifindTotalCount(condition,id);
        pb.setTotalCount(totalCount);
        //调用dao查询List集合
        //计算开始的记录索引
        int start=(_currentPage-1)*_rows;
        List<Activiti> list=dao.StuActifindByPage(start,_rows,condition,id);
        list=dao.StuActifindByPage(start,_rows,condition,id);
        pb.setList(list);
        //计算总页码
        int totalPage=totalCount%_rows==0?totalCount/_rows:totalCount/_rows+1;
        pb.setTotalPage(totalPage);
        return pb;
    }

    @Override
    public PageBean<Activiti> findActiHavedJoinByPage(String currentPage, String rows, String id) {
        int _currentPage=Integer.parseInt(currentPage);
        int _rows=Integer.parseInt(rows);
        PageBean<Activiti> pb=new PageBean<Activiti>();
        pb.setCurrentPage(_currentPage);
        //调用dao查询
        int totalCount=dao.StuHavedJoinActifindTotalCount(id);
        pb.setTotalCount(totalCount);
        //调用dao查询List集合
        //计算开始的记录索引
        int start=(_currentPage-1)*_rows;
        List<Activiti> list=dao.StuHavedJoinActifindByPage(start,_rows,id);

        pb.setList(list);
        //计算总页码
        int totalPage=totalCount%_rows==0?totalCount/_rows:totalCount/_rows+1;
        pb.setTotalPage(totalPage);
        return pb;
    }

    @Override
    public PageBean<Activiti> findActiHavedPublishByPage(String currentPage, String rows, String id) {
        int _currentPage=Integer.parseInt(currentPage);
        int _rows=Integer.parseInt(rows);
        PageBean<Activiti> pb=new PageBean<Activiti>();
        pb.setCurrentPage(_currentPage);
        //调用dao查询
        int totalCount=dao.StuHavedPublishActifindTotalCount(id);
        pb.setTotalCount(totalCount);
        //调用dao查询List集合
        //计算开始的记录索引
        int start=(_currentPage-1)*_rows;
        List<Activiti> list=dao.StuHavedPublishActifindByPage(start,_rows,id);

        pb.setList(list);
        //计算总页码
        int totalPage=totalCount%_rows==0?totalCount/_rows:totalCount/_rows+1;
        pb.setTotalPage(totalPage);
        return pb;
    }

    @Override
    public PageBean<StuWorkCheck> ActiWorkCheck(String currentPage, String rows, String id) {
        int _currentPage=Integer.parseInt(currentPage);
        int _rows=Integer.parseInt(rows);
        PageBean<StuWorkCheck> pb=new PageBean<StuWorkCheck>();
        pb.setCurrentPage(_currentPage);
        //调用dao查询
        int totalCount=dao.stuJoinActiTotalCount(id);
        pb.setTotalCount(totalCount);
        //调用dao查询List集合
        //计算开始的记录索引
        int start=(_currentPage-1)*_rows;
        List<StuWorkCheck> list=dao.stuJoinActiFindByPage(start,_rows,id);
        pb.setList(list);
        //计算总页码
        int totalPage=totalCount%_rows==0?totalCount/_rows:totalCount/_rows+1;
        pb.setTotalPage(totalPage);
        return pb;
    }
}
