package com.Replits;

public class R226Solved {
        public static void main(String[] args) {
            System.out.println("Hello world!");
        }
        public static String reverse(String strToRev) {
            String[] input = strToRev.split(" ");
            String[] output = new String[input.length];
            int outCounter = input.length - 1;
            for (String string : input
            ) {
                output[outCounter--] = string;
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (String string : output
            ) {
                stringBuilder.append(string).append(" ");

            }

            return stringBuilder.toString().trim();
        }
}
