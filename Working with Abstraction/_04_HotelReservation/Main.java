package com.company._04_HotelReservation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split("\\s+");

        double pricePerDay = Double.parseDouble(input[0]);
        int days = Integer.parseInt(input[1]);
        Season season = Season.valueOf(input[2]);
        Discount discount = Discount.valueOf(input[3]);

        double totalPrice = calculatePrice(pricePerDay, days, season, discount);

        System.out.printf("%.2f", totalPrice);
    }

    public static double calculatePrice(double pricePerDay, int days, Season season, Discount discount) {
        double totalPrice = pricePerDay * days * season.getMultiplier();
        return totalPrice - totalPrice * discount.getDiscount();
    }
}
