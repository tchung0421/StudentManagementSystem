package com.snva.studentmanagementsystem.service;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.List;

import com.snva.studentmanagementsystem.service.exception.StudentServiceException;
import com.snva.studentmanagementsystem.util.*;
import com.snva.studentmanagementsystem.bean.Student;
public class StudentServiceImpl implements IStudentService {

    ReadUtil m_readUtil;
    
    public StudentServiceImpl()
    {
        m_readUtil=new ReadUtil();
    }

    public void addNewStudent(Student student)
    {
        try
        {
            //studentlist.add(student);
            File file = new File("C:\\Users\\Se-Lim Oh\\Code\\StudentManagementSystem\\Students");
            String[] allFiles =  file.list();
            Arrays.sort(allFiles);
            if (allFiles.length > 0) {
                String lastFile = allFiles[allFiles.length - 1];
                int currentId = Integer.parseInt(lastFile.split("\\.")[0])+1;
                student.setStudentId(currentId);
            } else {
                student.setStudentId(1);
            }
            String filename = "" + student.getStudentId();
            if(file.exists()) {
                FileOutputStream fileOutputStream = new FileOutputStream(file.getAbsolutePath()+"\\"+filename);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                objectOutputStream.writeObject(student);
                objectOutputStream.flush();
                objectOutputStream.close();
                System.out.println("File was returned and saved");
            }

        }catch(UnsupportedOperationException e){
            System.out.println(e.getMessage());
        }catch(ClassCastException e){
            System.out.println(e.getMessage());
        }catch(NullPointerException e){
            System.out.println(e.getMessage());
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Student> loadStudentList() {
        List<Student> students = new ArrayList<Student>();
        try{
            File file = new File("C:\\Users\\Se-Lim Oh\\Code\\StudentManagementSystem\\Students");
            String[] allFiles =  file.list();
            
            for (String filename: allFiles){
                FileInputStream fileInputStream = new FileInputStream(file.getAbsolutePath()+'\\'+filename);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                students.add((Student) objectInputStream.readObject());

            }
        } catch (Exception e){
            throw new RuntimeException(e);
        }
        return students;
    }
    public List<Student> showAllStudentInformation() throws StudentServiceException
    {
        List<Student> students = loadStudentList();
        if(students.size()==0)
        {
            throw new StudentServiceException(StudentServiceException.NO_STUDENT_FOUND);
        }
        return students;
    }

}
