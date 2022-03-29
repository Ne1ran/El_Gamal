package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input;
        int p, g, e, r, m;
        while (true){
            System.out.println("Введите 1 для кодирования, 0 для декодирования");
            input = in.nextLine();
            if (input.equals("1")){
                System.out.println("Введите число P");
                p = Integer.parseInt(in.nextLine());
                while (!elGamalCoder.isSimple(p)){
                    System.out.println("Вы ввели неверное число. Оно не простое");
                    p = Integer.parseInt(in.nextLine());
                }
                System.out.println("Введите число G");
                g = Integer.parseInt(in.nextLine());
                while (!elGamalCoder.isSimple(g) || g > p){
                    System.out.println("Вы ввели неверное число. Оно не простое или больше P");
                    g = Integer.parseInt(in.nextLine());
                }
                System.out.println("Введите сообщение М");
                m = Integer.parseInt(in.nextLine());
                while (m > p){
                    System.out.println("Вы ввели неверное сообщение. Оно больше P");
                    m = Integer.parseInt(in.nextLine());
                }
                System.out.println("E, R: " + Arrays.toString(elGamalCoder.inCoder(p, g, m)));
            } else {
                if (input.equals("0")){
                    System.out.println("Введите число E");
                    e = Integer.parseInt(in.nextLine());
                    System.out.println("Введите число R");
                    r = Integer.parseInt(in.nextLine());
                    System.out.println("М: " + elGamalCoder.deCoder(e, r));
                }
                else {
                    break;
                }
            }
        }
    }
}

