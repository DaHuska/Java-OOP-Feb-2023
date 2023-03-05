package com.company.Encapsulation._04_AnimalFarm;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        try {
            String name = scan.nextLine();
            int age = Integer.parseInt(scan.nextLine());

            Chicken chicken = new Chicken(name, age);

            System.out.println(chicken.toString());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
