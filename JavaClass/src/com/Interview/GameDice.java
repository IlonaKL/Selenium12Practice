package com.Interview;

import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

public class GameDice {
    public static void main(String[] args) {
        int start = 0;
        int roll = 0;
        int end = 0;
        for (int i = 0; i < 30; i++) {
            Random random = new Random();
            roll = random.nextInt(6) + 1;
            end += roll;
            if (end > 40)
                end = end - 40;
            System.out.println("start=" + start + ", roll=" + roll + ", end=" + end);
            start = end;
        }
    }
}
