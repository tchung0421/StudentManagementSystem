package com.snva.studentmanagementsystem.service;

import java.util.List;

import com.snva.studentmanagementsystem.service.exception.StudentServiceException;
import com.snva.studentmanagementsystem.bean.Student;

public interface IStudentService {
    public void addNewStudent(Student student);
    public List<Student> showAllStudentInformation() throws StudentServiceException;

}
