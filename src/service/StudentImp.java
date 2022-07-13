package service;

import DAO.imp.StudentDaoImp;
import DAO.intf.StudentDao;
import main.domain.Activiti;
import main.domain.ancm;

import java.util.List;

public class StudentImp implements Student{
    StudentDao dao=new StudentDaoImp();
    @Override
    public List<ancm> findAllAncm() {
         return dao.findAllAncm();
    }

    @Override
    public ancm finAcnmById(String id) {
        return dao.finAcnmById(id);
    }

    @Override
    public void upDate(String gender, String phone, String email) {
        dao.upDate(gender,phone,email);
    }

    @Override
    public void upDatePassword(String id, String password) {
        dao.upDatePassword(id,password);
    }

    @Override
    public void insertActi(Activiti activiti) {
        dao.inserActi(activiti);
    }

    @Override
    public void Application(String actiId, String userId, String check, int num) {
        dao.Application(actiId,userId,check,num);
    }

    @Override
    public void startworkCheck(String id) {
        dao.startworkCheck(id);
    }

    @Override
    public void stuWorkCheck(String actiId, String userId) {
        dao.stuWorkCheck(actiId,userId);
    }

    @Override
    public void stopWorkCheck(String id) {
        dao.stopWorkCheck(id);
    }

    @Override
    public void dealUnchekStu(String userid, String type,String actiId) {
        dao.dealUnchekStu(userid,type,actiId);
    }
}
