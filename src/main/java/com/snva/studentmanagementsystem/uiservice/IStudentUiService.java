package com.snva.studentmanagementsystem.uiservice;

import com.snva.studentmanagementsystem.bean.Student;

import java.util.List;

public interface IStudentUiService {
    public void AddNewStudent();
    public void showAllStudents();
    public List<Student> searchStudentByName(String name);
    public List<Student> searchStudentById(int id);

}
