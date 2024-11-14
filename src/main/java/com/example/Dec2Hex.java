package com.example;

public class Dec2Hex {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please provide a decimal number as an argument.");
            return;
        }

        try {
            int decimal = Integer.parseInt(args[0]);
            String hex = Integer.toHexString(decimal).toUpperCase();
            System.out.println("Hexadecimal: " + hex);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid integer.");
        }
    }
}

