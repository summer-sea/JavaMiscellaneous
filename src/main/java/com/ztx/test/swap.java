package com.ztx.test;

import org.junit.Test;

public class swap {
    public void swap(int a,int b){
        int temp;
        temp = a;
        a = b;
        b= temp;

    }
    @Test
    public void testSwap(){
        int a =1,b=2;
        swap(a,b);
        System.out.println(" ."+a+" ."+b);

    }
}
