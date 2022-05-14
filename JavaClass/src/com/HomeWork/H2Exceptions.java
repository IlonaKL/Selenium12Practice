package com.HomeWork;

public class H2Exceptions {
    public static void checkAge(int age){
        if(age<16)
            throw new RuntimeException("Age is less then 16");
    }

    public static void main(String[] args) {
        try {
            int age=5;
            checkAge(age);
        }
        catch (RuntimeException runtimeException){
            System.out.println(runtimeException.getMessage());;
        }
    }
}
