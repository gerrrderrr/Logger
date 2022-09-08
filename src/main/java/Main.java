import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean isNum = false;
        logger.log("Launching the program");
        logger.log("Asking to enter list size");
        System.out.println("Hello, friend!");
        int listSize = 0;
        int randomNum = 0;

        while (!isNum) {
            System.out.println("Enter list size:");
            String inputListSize = scanner.nextLine();
            System.out.println("Enter max random:");
            String inputRandom = scanner.nextLine();
            try {
                listSize = Integer.parseInt(inputListSize);
                randomNum = Integer.parseInt(inputRandom);
            } catch (NumberFormatException e) {
                System.out.println("You entered: \"" + inputListSize + "\" and \"" + inputRandom + "\"! Please enter a number!");
                logger.log("Entered \"" + inputListSize + "\" and \"" + inputRandom + "\" instead of NUM");
            }
            if (listSize > 0 && randomNum > 0) {
                isNum = true;
                logger.log("Entered \"" + listSize + "\" and \"" + randomNum + "\"");
            }
        }

        isNum = false;
        List<Integer> randomList = new ArrayList<>();
        logger.log("List created");
        for (int i = 0; i < listSize; i++) {
            int num = random.nextInt(randomNum);
            randomList.add(num);
            logger.log("Number: " + num + " added to the list");
        }
        System.out.println("Here is your list with random numbers: " + randomList + "\n");
        logger.log("Displaying list with random numbers on the screen");

        int threshold = 0;

        while (!isNum) {
            System.out.println("Enter the threshold for the filter:");
            String inputThreshold = scanner.nextLine();
            try {
                threshold = Integer.parseInt(inputThreshold);
            } catch (NumberFormatException e) {
                System.out.println("You entered: \"" + inputThreshold + "\"! Please enter a number!");
                logger.log("Entered \"" + inputThreshold + "\" instead of NUM");
            }
            if (threshold > 0) {
                isNum = true;
                logger.log("Entered \"" + threshold + "\"");
            }
        }

        Filter filter = new Filter(threshold);
        System.out.println("Here is your filtered list: " + filter.filterOut(randomList) + "\n");
        logger.log("Displaying filtered list on the screen");
        scanner.close();
        logger.log("Closing program");
        logger.print();
    }
}
