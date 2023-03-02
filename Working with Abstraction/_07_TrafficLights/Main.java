package com.company._07_TrafficLights;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split("\\s+");

        TrafficLight[] trafficLights = new TrafficLight[input.length];
        for (int i = 0; i < input.length; i++) {
            String s = input[i];

            TrafficLight.Signal signal = TrafficLight.Signal.valueOf(s);
            trafficLights[i] = new TrafficLight(signal);
        }
        
        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            updateTrafficLight(trafficLights);
            printTrafficLights(trafficLights);
        }
    }

    private static void updateTrafficLight(TrafficLight[] trafficLights) {
        for (TrafficLight trafficLight : trafficLights) {
            trafficLight.update();
        }
    }

    private static void printTrafficLights(TrafficLight[] trafficLights) {
        for (TrafficLight trafficLight : trafficLights) {
            System.out.print(trafficLight.getSignal() + " ");
        }
        System.out.println();
    }
}
