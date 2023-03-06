package com.company.Encapsulation._05_ShoppingSpree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Person> persons = parsePersons(scan.nextLine());
        List<Product> products = parseProducts(scan.nextLine());

        String command = scan.nextLine();
        while (!command.equals("END")) {
            String personName = command.split("\\s+")[0];
            String productName = command.split("\\s+")[1];

            for (Person person : persons) {
                if (person.getName().equals(personName)) {
                    for (Product product : products) {
                        if (product.getName().equals(productName)) {
                            try {
                                person.buyProduct(product);
                            } catch (IllegalStateException e) {
                                System.out.println(e.getMessage());
                            }
                            break;
                        }
                    }
                }
            }

            command = scan.nextLine();
        }

        for (Person person : persons) {
            if (person.getProducts().isEmpty()) {
                System.out.printf("%s - Nothing bought%n", person.getName());
            } else {
                List<String> productNames = person.getProducts()
                        .stream()
                        .map(product -> product.getName())
                        .collect(Collectors.toList());

                System.out.printf("%s - %s%n", person.getName(), String.join(", ", productNames));
            }
        }
    }

    private static List<Product> parseProducts(String nextLine) {
        List<Product> productList = new ArrayList<>();

        String[] input = nextLine.split(";");
        for (int i = 0; i < input.length; i++) {
            try {
                Product product = new Product(input[i].split("=")[0], Double.parseDouble(input[i].split("=")[1]));
                productList.add(product);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return productList;
    }

    private static List<Person> parsePersons(String nextLine) {
        List<Person> personList = new ArrayList<>();

        String[] input = nextLine.split(";");
        for (int i = 0; i < input.length; i++) {
            try {
                Person person = new Person(input[i].split("=")[0], Double.parseDouble(input[i].split("=")[1]));
                personList.add(person);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

        }

        return personList;
    }
}
