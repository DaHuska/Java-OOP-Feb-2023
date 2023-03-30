package com.company.Polymorphism._05_Vehicles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] carTokens = scan.nextLine().split("\\s+");
        String[] truckTokens = scan.nextLine().split("\\s+");

        Vehicle car = new Car(Double.parseDouble(carTokens[1]), Double.parseDouble(carTokens[2]));
        Vehicle truck = new Truck(Double.parseDouble(truckTokens[1]), Double.parseDouble(truckTokens[2]));

        int commandsNumber = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < commandsNumber; i++) {
            String[] commandTokens = scan.nextLine().split("\\s+");

            switch (commandTokens[0]) {
                case "Drive":
                    double distance = Double.parseDouble(commandTokens[2]);
                    double traveledDistance = 0;

                    if (commandTokens[1].equals("Car")) {
                        try {
                            traveledDistance = car.drive(distance);
                            System.out.printf("Car travelled %.2f km%n", traveledDistance);
                        } catch (IllegalStateException e) {
                            System.out.println(e.getMessage());
                        }
                    } else if (commandTokens[1].equals("Truck")) {
                        try {
                            traveledDistance = truck.drive(distance);
                            System.out.printf("Truck travelled %.2f km%n", traveledDistance);
                        } catch (IllegalStateException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;
                case "Refuel":
                    double refuelQuantity = Double.parseDouble(commandTokens[2]);

                    if (commandTokens[1].equals("Car")) {
                        car.refuel(refuelQuantity);
                    } else if (commandTokens[1].equals("Truck")) {
                        truck.refuel(refuelQuantity);
                    }
                    break;
            }
        }

        System.out.printf("Car: %.2f%n", car.getFuelQuantity());
        System.out.printf("Truck: %.2f%n", truck.getFuelQuantity());

        // optimize drive()
    }
}
