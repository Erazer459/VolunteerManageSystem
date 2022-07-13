package service;

import main.domain.Activiti;
import main.domain.ancm;

import java.util.List;

public interface Student {
    public List<ancm> findAllAncm();
    ancm finAcnmById(String id);
    void upDate(String gender,String phone,String email);

    void upDatePassword(String id, String password);
    void insertActi(Activiti activiti);

    void Application(String actiId, String userId, String check, int num);

    void startworkCheck(String id);

    void stuWorkCheck(String actiId, String userId);

    void stopWorkCheck(String id);

    void dealUnchekStu(String userid, String type,String actiId);
}
