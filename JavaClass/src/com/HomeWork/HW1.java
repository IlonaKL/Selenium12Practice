package com.HomeWork;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class HW1 {
    public static List<Exception> printExceptions() {
        List<Exception> exceptions = new LinkedList<>();

            try {
                ArithmeticException obj=new ArithmeticException();
                throw obj;
                 //throw new ArithmeticException("error");
                //System.out.println(a / b);
            } catch (ArithmeticException are) {
                exceptions.add(are);
            }


                try{
                    String str=null;
                    System.out.println(str.charAt(0));
                }
                catch (NullPointerException npe){
                    exceptions.add(npe);
                }

                try{
                    int [] numbers= {3,5,6};
                    System.out.println(numbers[5]);
                }
                catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsE){
                    exceptions.add(arrayIndexOutOfBoundsE);
                }

                try{
                    String s="I am here";
                    System.out.println(s.charAt(-1));
                }
                catch (StringIndexOutOfBoundsException stringIndexOutOfBoundE){
                    exceptions.add(stringIndexOutOfBoundE);
                }
        return exceptions;
    }

    public static void main(String[] args) {
        System.out.println(printExceptions());
    }
}




