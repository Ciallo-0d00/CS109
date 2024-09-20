package com.huanan;

import java.util.Scanner;

public class Demo03method {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int data = sc.nextInt();
        method(data);

    }
    public static void method(int data){

        for (int count = 1;count <= data;count++){
            System.out.println("Chinese is so niubi");
        }



    }
}
