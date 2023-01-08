package com.snva.studentmanagementsystem.uiservice;

import java.util.*;

import com.snva.studentmanagementsystem.bean.Student;
import com.snva.studentmanagementsystem.util.*;
import com.snva.studentmanagementsystem.service.StudentServiceImpl;
import com.snva.studentmanagementsystem.service.IStudentService;
import com.snva.studentmanagementsystem.service.exception.StudentServiceException;
public class StudentUiSerivceImpl implements IStudentUiService {

    private ReadUtil m_readUtil;

    private IStudentService m_studentService;

    public StudentUiSerivceImpl()
    {
        m_readUtil= new ReadUtil();
        m_studentService=new StudentServiceImpl();
    }
    public void AddNewStudent(){
        Student student=new Student();
        student.setFirstName(m_readUtil.readString("Input Your First name","String cannot be empty"));
        student.setLastName(m_readUtil.readString("Input your Last name","Sring cannot be empty"));
        student.setContactNumber(m_readUtil.readDouble("Input Contact number","Input correct values"));
        student.setDateOfBirth(m_readUtil.readDate("Input Date of Birth (DD-MM-YYYY)","enter valid date format(DD-MM-YYYY)"));
        student.setDateOfJoining(m_readUtil.readDate("Input Date Of Joining (DD-MM-YYYY)","enter valid date format(DD-MM-YYYY)"));
        m_studentService.addNewStudent(student);
    }
    public void showAllStudents(){
        try
        {
            List<Student> studentlist=m_studentService.showAllStudentInformation();
            System.out.println("All Employees Information : \n ");
            printList(studentlist);

        }catch(StudentServiceException e){
            System.out.println(e.getMessage());
        }
    }
    public List<Student> searchStudentByName(String name)throws NullPointerException {
        List<Student> studentlist1 = null;
        try {
            name = name.toLowerCase();
            List<Student> employeelist=m_studentService.showAllStudentInformation();
            studentlist1 = new ArrayList<Student>();
            Iterator<Student> studentlistiterator= employeelist.iterator();
            while(studentlistiterator.hasNext()) {
                Student student=studentlistiterator.next();
                String fullName = (student.getFirstName()+" "+student.getLastName()).toLowerCase();
                if(fullName.contains(name))	{
                    studentlist1.add(student);
                }
            }
            printList(studentlist1);
        }catch(StudentServiceException e){
            System.out.println(e.getMessage());
        }
        if((studentlist1==null) || (studentlist1.size()==0))
            throw new NullPointerException();

        return studentlist1;
    }
    public List<Student> searchStudentById(int id){
        List<Student> studentlist1 = null;
        try {
            List<Student> studentlist=m_studentService.showAllStudentInformation();
            studentlist1 = new ArrayList<Student>();
            Iterator<Student> studentlistiterator= studentlist.iterator();
            while(studentlistiterator.hasNext()) {
                Student student=studentlistiterator.next();
                int studentid = student.getStudentId();
                if(String.format("%d",studentid).indexOf(String.format("%d",id))==0)	{
                    studentlist1.add(student);
                }
            }
            printList(studentlist1);
        }catch(StudentServiceException e){
            System.out.println(e.getMessage());
        }

        return studentlist1;
    }
    private void printList(List<Student> studentlist)
    {
        Iterator<Student> studentlistiterator=studentlist.iterator();
        while(studentlistiterator.hasNext())
        {
            Student student=studentlistiterator.next();
            System.out.println("---------------------------------------");
            System.out.println("Student ID : "+student.getStudentId());
            System.out.println("First Name : "+student.getFirstName());
            System.out.println("Last Name : "+student.getLastName());
            System.out.println("Contact Number : "+student.getContactNumber());
            System.out.println("Date Of Birth : "+student.getDateOfBirth());
            System.out.println("Date Of Joining : "+student.getDateOfJoining());
            System.out.println("-----------------------------------------");
            System.out.println();
        }
    }
}
