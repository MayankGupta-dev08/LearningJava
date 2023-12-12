package dev.mayankg.bit_manipulation;

import java.util.Scanner;

public class ManipulatingBits {
    public static void main(String[] args) {
        System.out.println("-------------Bit Manipulation----------");
        Scanner sc = new Scanner(System.in);
        System.out.printf("Enter the number: ");    //57
        int num = sc.nextInt();
        System.out.printf("Enter i: ");    //3
        int i = sc.nextInt();
        System.out.printf("Enter j: ");    //3
        int j = sc.nextInt();
        System.out.printf("Enter k: ");    //3
        int k = sc.nextInt();
        System.out.printf("Enter l: ");    //3
        int l = sc.nextInt();

        int onmask = (1 << i);
        int offmask = ~(1 << j);
        int tmask = (1 << k);
        int cmask = (1 << l);

        // to make a bit ON at ith position from the right for num --> use onmask and |
        System.out.println(num | onmask);
        // to make a bit OFF at jth position from the right for num --> use offmask and &
        System.out.println(num & offmask);
        // to toggle or do XOR kth bit from the right for num --> use tmask and ^
        System.out.println(num ^ tmask);
        // to check if a lth bit of a num is 0 or 1 --> use cmask and & ==> if (ans==0)? 0:1;
        System.out.println((num & cmask) == 0 ? 0 : 1);
    }
}