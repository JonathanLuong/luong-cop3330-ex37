package org.example;

/*
 *  UCF COP3330 Fall 2021 Assignment 37 Solution
 *  Copyright 2021 Jonathan Luong
 */

import java.util.Objects;
import java.util.Scanner;
import java.util.Random;
import java.util.*;

public class App {


    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in); // Creates reader
        Random rand = new Random(); // Create random class

        int passwordMax = 12;
        boolean flag = true;

        System.out.printf("What's the minimum length? ");
        int passwordMin = reader.nextInt();
        System.out.printf("How many special characters? ");
        int numOfSpec = reader.nextInt();
        System.out.printf("How many numbers? ");
        int numOfNum = reader.nextInt();

        // List of chars
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        char[] specialChars = "!@#$%^&*()_".toCharArray();
        char[] numbers = "123456789".toCharArray();

        // Gets random num in the range
        int randomLen = (rand.nextInt(passwordMax - passwordMin) + 1) + passwordMin;

        int numOfAlpha = randomLen - (numOfSpec + numOfNum);
        char[] password = new char[randomLen];

        // fills password with alphabet chars
        for(int i = 0; i < numOfAlpha; i++) {
            int randomAlphabet = rand.nextInt(alphabet.length) + 1;
            password[i] = alphabet[randomAlphabet];
        }
        // fills password with numbers chars
        for(int i = numOfAlpha; i < numOfAlpha + numOfNum; i++) {
            int randomNumber = rand.nextInt(numbers.length) + 1;
            password[i] = numbers[randomNumber];
        }
        // fills password with special chars
        for(int i = numOfAlpha + numOfNum; i < numOfAlpha + numOfNum + numOfSpec; i++) {
            int randomSpecial = rand.nextInt(specialChars.length) + 1;
            password[i] = specialChars[randomSpecial];
        }

        // print final password
        System.out.printf("Your password is ");
        for(int i = 0; i < randomLen; i++)
            System.out.printf("%c", password[i]);
    }
}