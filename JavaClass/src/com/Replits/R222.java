package com.Replits;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class R222 {
        public static void main(String[] args) {
            List<Integer> list=new ArrayList<>();
            list.add(10);
            list.add(20);
            list.add(30);
            list.add(195);
            list.add(90);
            list.add(10);
            list.add(100);
            list.add(9);
            System.out.println(findMaxSum(list));
        }

        public static int findMaxSum(List<Integer> lists) {
            int result=0;
            int max=0;
            int secontMax=0;
            for (int i = 0; i < lists.size(); i++) {
                if(lists.get(i)>max){
                    secontMax=max;
                    max=lists.get(i);
                }
                else if(lists.get(i)>secontMax)
                    secontMax=lists.get(i);
            }
            result=max+secontMax;
            return result;
        }
    }
