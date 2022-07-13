package service;

import DAO.imp.ManagerDaoImp;
import DAO.intf.ManagerDao;
import main.domain.manager;

public class ManagerLoginImp implements ManagerLogin{
    @Override
    public manager login(manager manager) {
        ManagerDao dao= new ManagerDaoImp();
        return dao.finManagerById(manager);
    }
}
