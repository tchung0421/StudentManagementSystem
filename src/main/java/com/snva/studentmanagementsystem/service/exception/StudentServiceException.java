package com.snva.studentmanagementsystem.service.exception;

public class StudentServiceException extends Exception {
    public static final String NO_STUDENT_FOUND="no student found in list";

    public StudentServiceException(String msg)
    {
        super(msg);
    }
}
