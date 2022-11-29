// Filename: last01.java
// Name: Eduardo Olivares
import java.util.Scanner;

public class last01 {
    public static void printContent(int arr[], int inputCount, boolean arrIsFull, int offset) {
        if (inputCount == -1) {
            System.out.print("No values were inputted.");
        } else if (arrIsFull) {

            for (int i = 0 + offset; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }

            for (int i = 0; i < offset; i++) {
                System.out.print(arr[i] + " ");
            }

        } else {

            for (int i = 0; i < inputCount + 1; i++) {

                System.out.print(arr[i] + " ");

            }
        }

        System.out.print("\n");

    }

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        // Java naming conventions, uppercase for constants
        // (https://www.oracle.com/java/technologies/javase/codeconventions-namingconventions.html)
        final int MAX_ARR_SIZE = 10;
        int arr[] = new int[MAX_ARR_SIZE];

        int input = 0;
        int inputCount = -1;
        boolean arrIsFull = false;
        int offset = 0;

        while (input != -1) {
            try {
                input = scnr.nextInt();
            } catch (java.util.InputMismatchException e) {
                System.out.println(e);
                break;
            }

            if (input == -1) {
                break;
            }

            if(input == 0){
                printContent(arr, inputCount, arrIsFull, offset);
            }

            inputCount++;

            if (inputCount > MAX_ARR_SIZE - 1) {
                arrIsFull = true;
            }

            if (arrIsFull) {
                offset = (inputCount % MAX_ARR_SIZE) + 1;

                if (offset == MAX_ARR_SIZE) {
                    offset = 0;
                }
            }

            arr[inputCount % MAX_ARR_SIZE] = input;
        }

        printContent(arr, inputCount, arrIsFull, offset);

        scnr.close();
    }
}
