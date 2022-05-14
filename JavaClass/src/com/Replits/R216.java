package com.Replits;

import java.util.Arrays;

public class R216 {
    public static int[] arraySumToZero(int N) {
        int [] arr = new int[N];
        if(N==0)
            arr=null;
        else if(N==1)
            arr[0]=0;
        else{
            for(int i=0; i<N; i++){
                if(N%2!=0){
                    arr[N]=0;
                    N=N-1;
                }
                arr[i]=i+1;
                arr[i+1]=-i-1;
                i++;
            }
        }
        return arr;
    }

    public static void main(String[] args){
        System.out.print(Arrays.toString(arraySumToZero(4)));
    }
}
