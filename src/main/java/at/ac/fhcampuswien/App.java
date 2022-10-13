package at.ac.fhcampuswien;

import org.w3c.dom.ls.LSOutput;

import java.sql.Array;
import java.util.Random;
import java.util.Scanner;

public class App {

    // Implement all methods as public static
    public static void oneMonthCalendar (int numberOfDays, int firstDay) {
        int dayOfWeek = 1;
    for (int day = 2 - firstDay; day <= numberOfDays; day++) {
        if (dayOfWeek == 8) {
            dayOfWeek = 1;
            System.out.println();
        }

        if (day < 1) {
            System.out.print("   ");
        }
        else if (day < 10) {
            System.out.print(" " + day + " ");
        }
        else {
            System.out.print(day + " ");
        }
        dayOfWeek++;

    }
        System.out.println();
    }

    public static long[] lcg (long seed) {
    final long m = (long)Math.pow(2, 31);
    final long a = 1103515245;
    final int c = 12345;

    long[] numbers = new long[10];
    long Xi = seed;

    for (int i = 0; i < 10; i++) {
        long XiPlus = (a*Xi + c) % m;
        numbers[i] = XiPlus;
        Xi = XiPlus;
    }

    return numbers;

    }

    public static void guessingGame(int numberToGuess) {
        Scanner scanner = new Scanner(System.in);
        int guessedNumber;

        for (int i = 1; i <= 9; i++) {
            System.out.print("Guess number " + i + ": ");
            guessedNumber = scanner.nextInt();
            if (guessedNumber > numberToGuess) {
                System.out.println("The number AI picked is lower than your guess.");
            } else if (guessedNumber < numberToGuess) {
                System.out.println("The number AI picked is higher than your guess.");
            } else {
                System.out.println("You won wisenheimer!");
                return;
                }
        }
        System.out.print("Guess number 10: ");
        guessedNumber = scanner.nextInt();
        if (guessedNumber == numberToGuess) {
            System.out.println("You won wisenheimer!");
        }
        else {
            System.out.println("You lost! Have you ever heard of divide & conquer?");
        }
    }

    public static int randomNumberBetweenOneAndHundred () {
        Random random = new Random();
        return random.nextInt(100)+1; //nextInt(100) = 0-99 - deswegen +1
    }

    public static boolean swapArrays(int[] left, int[] right){
        if(left.length != right.length) {
            return false;
        }
        int swap;

        for (int i = 0; i < left.length; i++) { //arrays beginnen mit 0 - length-1
            swap = left[i];
            left[i] = right[i];
            right[i] = swap;
        }
        return true;
    }

    public static String camelCase(String inputSentence){
        char[] input = inputSentence.toCharArray();

        for(int i = 0; i < input.length; i++) {
            if (input[i] >= 'A' && input[i] <= 'Z') {
                input[i] += 32;
            }
        }

        String output = new String();

        for(int i = 0; i < input.length; i++) {
            if (input[i] >= 'a' && input[i] <= 'z') {
                if (i == 0 || input[i-1] == ' ') {
                    input[i] -= 32;
                }
                output += input[i];
            }
        }
        return output;
    }

    public static int checkDigit(int[] digits){
    int sum = 0;

    for(int i = 0; i < digits.length; i++) {
        int digit = digits[i];
        int weight = i + 2;
        int product = digit * weight;
        sum += product;
    }

    int check = sum % 11;
    check = 11 - check;

    if (check == 10) {
        check = 0;
    } else if (check == 11) {
        check = 5;
    }

    return check;
    }

    public static void main(String[] args) {
        // test your method implementations here
        // make method calls
        // print their results
        // etc.
        int number = randomNumberBetweenOneAndHundred();
        guessingGame(number);

    }
}