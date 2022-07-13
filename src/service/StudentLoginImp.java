package service;

import DAO.imp.StudentDaoImp;
import DAO.intf.StudentDao;
import main.domain.Student;

public class StudentLoginImp implements StudentLogin{

    @Override
    public Student login(Student student) {
        StudentDao dao=new StudentDaoImp();
        return dao.findStudentById(student);
    }
}
