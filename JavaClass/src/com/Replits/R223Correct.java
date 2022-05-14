package com.Replits;

import java.util.Scanner;

public class R223Correct {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        for (int i = 0; i < number; i++) {
            int k=2*i+1;
            for (int j = 2*number-1-k; j >= 1; j--) {
                System.out.print(" ");
            }

            for (int j = 0; j <= 2*i; j++) {
                System.out.print(number + " ");
            }
            System.out.println("");
        }
    }
}


/*
  2
2 2 2

    3
  3 3 3
3 3 3 3 3

      4
    4 4 4
  4 4 4 4 4
4 4 4 4 4 4 4
 */