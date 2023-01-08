package com.snva.studentmanagementsystem.Runner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.snva.studentmanagementsystem.util.*;
import com.snva.studentmanagementsystem.bean.Student;
import com.snva.studentmanagementsystem.uiservice.IStudentUiService;
import com.snva.studentmanagementsystem.uiservice.StudentUiSerivceImpl;
public class Runner
{
    private ReadUtil m_readUtil;
    private IStudentUiService m_StudentUIService;

    /**
     *This is a default constructor of the class
     */
    public Runner() throws IOException {
        m_readUtil=new ReadUtil();
        m_StudentUIService=new StudentUiSerivceImpl();
        checkUserOptions();
    }

    /**
     *This function takes the user choice as the menu is displayed and
     *call the functions accordingly.
     *
     */
    private void checkUserOptions() throws IOException {
        int choice=0;
        List<Student> employeelist=new ArrayList<Student>();
        do
        {
            displayMainMenu();
            choice=m_readUtil.readInt("Input Your choice","Input valid Choice");
            switch(choice)
            {
                case 1 : m_StudentUIService.AddNewStudent();
                    break;

                case 2 : m_StudentUIService.showAllStudents();
                    break;

                case 3 :String name=m_readUtil.readString("Input Employee Name(or any part of name)","String cannot be empty");
                    try{
                        employeelist=m_StudentUIService.searchStudentByName(name);
                        System.out.println();
                    }catch(NullPointerException e){
                        System.out.println("Emloyee not found");
                    }
                    break;

                case 4 : int id=m_readUtil.readInt("Input Employee Name(or any part of name)","String must be a number");
                    try{
                        employeelist=m_StudentUIService.searchStudentById(id);
                        System.out.println();
                    }catch(NullPointerException e){
                        System.out.println("Emloyee not found");
                    }
                    break;

                case 5: System.out.println("Goodbye");
                    break;
                default : System.out.println("wrong choice");
                    break;
            }
        }while(choice!=5);
    }
    /**
     *This fuction displays the main menu of the system.
     *
     */

//	private String m_extension;
//	private String m_date;
//	private String m_totalCallTime;
//	private String m_totalCallNumber;
//	private String m_averageCall;
//	private String m_firstCall;
//	private String m_lastCall;

    private void displayMainMenu()
    {
        System.out.println("     Main Menu     ");
        System.out.println("-------------------");
        System.out.println("1. Add New Student ");
        System.out.println("2. Show All Students ");
        System.out.println("3. Search By First Name ");
        System.out.println("4. Search By Id ");
        System.out.println("5. Exit ");
    }

    /**
     * This is the main fuction which runs the default constructor of the class.
     */
    public static void main(String[] args) throws IOException {
        new Runner();
    }

}
