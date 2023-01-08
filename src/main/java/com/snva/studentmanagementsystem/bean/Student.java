package com.snva.studentmanagementsystem.bean;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Student implements Serializable {
    private int m_studentId;
    private String m_firstName;
    private String m_lastName;
    private Double m_contactNumber;
    private Date m_dateOfBirth;
    private Date m_dateOfJoining;
    static int current_id=1;

    public int getStudentId() {
        return m_studentId;
    }

    public void setStudentId(int m_studentId) {
        this.m_studentId = m_studentId;
    }

    public String getFirstName() {
        return m_firstName;
    }

    public void setFirstName(String m_firstName) {
        this.m_firstName = m_firstName;
    }

    public String getLastName() {
        return m_lastName;
    }

    public void setLastName(String m_lastName) {
        this.m_lastName = m_lastName;
    }

    public Double getContactNumber() {
        return m_contactNumber;
    }

    public void setContactNumber(Double m_contactNumber) {
        this.m_contactNumber = m_contactNumber;
    }

    public Date getDateOfBirth() {
        return m_dateOfBirth;
    }

    public void setDateOfBirth(Date m_dateOfBirth) {
        this.m_dateOfBirth = m_dateOfBirth;
    }

    public Date getDateOfJoining() {
        return m_dateOfJoining;
    }

    public void setDateOfJoining(Date m_dateOfJoining) {
        this.m_dateOfJoining = m_dateOfJoining;
    }

    public Student()
    {
        m_studentId=current_id++;
    }
}
