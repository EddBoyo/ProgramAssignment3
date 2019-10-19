
import java.util.Scanner;

public class StudentCAI {
    public static void main(String args[]) {
        int difficultyChoice;
        Scanner scan = new Scanner(System.in);
        int receive;
        int quizChoice;
        boolean sessionContinue = true;
        while (sessionContinue) {
            difficultyChoice = AcquireDifficulty();
            quizChoice = AcquireQuizType();
            receive = WrapperCAI(difficultyChoice, quizChoice);
            System.out.println("Are you ready to continue? (Enter any single letter to continue)");
            char userChoice = scan.next().charAt(0);
            boolean restartCheck = true;
            while (restartCheck) {
                System.out.println("Would you like to start a new session? (Enter y or n)");
                userChoice = scan.next().charAt(0);
                if (userChoice == 'y' || userChoice == 'n') {
                    restartCheck = false;
                } else {
                    System.out.println("Invalid input try again");
                }
            }
            if (userChoice == 'n') {
                sessionContinue = false;
            }
        }
    }

    public static int AcquireQuizType() {
        boolean check = true;
        Scanner scan = new Scanner(System.in);
        int quizChoice = 0;
        while (check) {
            System.out.println("Which quiz would you like to choose(1-5)?");
            System.out.println("1. Addition\n2. Multiplication\n3. Subtraction\n4. Division\n5. Mix of all");
            quizChoice = scan.nextInt();
            if (quizChoice > 5 || quizChoice < 1) {
                System.out.println("Invalid choice try again.");
            } else {
                check = false;
            }
        }
        return quizChoice;
    }

    public static int AcquireDifficulty() {
        boolean check = true;
        Scanner scan = new Scanner(System.in);
        int difficultyChoice = 0;
        while (check) {
            System.out.println("What difficulty would you like to choose(1-4)?");
            System.out.print("1. Single-Digits\n2. Up to Double-Digits\n3. Up to Triple-Digits\n4. Up to Four-Digit\n");
            difficultyChoice = scan.nextInt();
            if (difficultyChoice > 4 || difficultyChoice < 1) {
                System.out.println("Invalid choice try again.");
            } else {
                check = false;
            }
        }
        return difficultyChoice;
    }

    public static int timesQuestions(int bound) {
        SecureRandom rand = new SecureRandom(bound);
        Scanner scan = new Scanner(System.in);
        System.out.println("How much is " + rand.getNum1() + " times " + rand.getNum2() + "?");
        double userAnswer = scan.nextDouble();
        double answer = (double) rand.getNum1() * (double) rand.getNum2();
        if (Math.abs(userAnswer - answer) < 0.0001) {
            GenerateResponses(1);
            return 1;
        } else {
            GenerateResponses(0);
            return 0;
        }
    }

    public static int additionQuestions(int bound) {
        SecureRandom rand = new SecureRandom(bound);
        Scanner scan = new Scanner(System.in);
        System.out.println("How much is " + rand.getNum1() + " plus " + rand.getNum2() + "?");
        double userAnswer = scan.nextDouble();
        double answer = (double) rand.getNum1() + (double) rand.getNum2();
        if (Math.abs(userAnswer - answer) < 0.0001) {
            GenerateResponses(1);
            return 1;
        } else {
            GenerateResponses(0);
            return 0;
        }
    }

    public static int subtractionQuestions(int bound) {
        SecureRandom rand = new SecureRandom(bound);
        Scanner scan = new Scanner(System.in);
        System.out.println("How much is " + rand.getNum1() + " minus " + rand.getNum2() + "?");
        double userAnswer = scan.nextDouble();
        double answer = (double) rand.getNum1() - (double) rand.getNum2();
        if (Math.abs(userAnswer - answer) < 0.0001) {
            GenerateResponses(1);
            return 1;
        } else {
            GenerateResponses(0);
            return 0;
        }
    }

    public static int divisionQuestions(int bound) {
        SecureRandom rand = new SecureRandom(bound);
        Scanner scan = new Scanner(System.in);
        if (rand.getNum2() == 0) {
            rand.addtoNum2();
        }
        System.out.println("How much is " + rand.getNum1() + " divided by " + rand.getNum2() + "? (Round to 4 decimal points)");
        double userAnswer = scan.nextDouble();
        double answer = (double) rand.getNum1() / (double) rand.getNum2();
        if (Math.abs(userAnswer - answer) < 0.0001) {
            GenerateResponses(1);
            return 1;
        } else {
            GenerateResponses(0);
            return 0;
        }
    }

    public static void GenerateResponses(int check) {
        SecureRandom rand = new SecureRandom(4);
        if (check == 1) {
            switch (rand.getNum1()) {
                case 0:
                    System.out.println("Very good!");
                    break;
                case 1:
                    System.out.println("Excellent!");
                    break;
                case 2:
                    System.out.println("Nice work!");
                    break;
                case 3:
                    System.out.println("Keep up the good work!");
                    break;
                default:
                    break;

            }
        } else {
            switch (rand.getNum1()) {
                case 0:
                    System.out.println("No. Please try again.");
                    break;
                case 1:
                    System.out.println("Wrong. Try once more.");
                    break;
                case 2:
                    System.out.println("Don't give up!");
                    break;
                case 3:
                    System.out.println("No. Keep trying.");
                    break;
                default:
                    break;
            }
        }
    }

    public static int WrapperCAI(int difficulty, int quizType) {
        boolean whenRight = true;
        int bound = 0;
        int receive = 0;
        switch (difficulty) {
            case 1:
                bound = 10;
                break;
            case 2:
                bound = 100;
                break;
            case 3:
                bound = 1000;
                break;
            case 4:
                bound = 10000;
                break;
            default:
                break;
        }
        switch (quizType) {
            case 1:
                receive = additionSet(bound);
                break;
            case 2:
                receive = timesSet(bound);
                break;
            case 3:
                receive = subtractionSet(bound);
                break;
            case 4:
                receive = divisionSet(bound);
                break;
            case 5:
                receive = mixMatchSet(bound);
                break;
            default:
                break;

        }
        return receive;
    }

    public static int additionSet(int bound) {
        int temp;
        int numCorrect = 0;
        int numIncorrect = 0;
        double percentage = 0;
        for (int i = 0; i < 10; i++) {
            temp = additionQuestions(bound);
            if (temp == 1) {
                numCorrect++;
            } else {
                numIncorrect++;
            }
        }
        percentage = numCorrect / 10.0;
        if (percentage > 0.75) {
            System.out.println("Congratulations, you are ready to go to the next level!");
            System.out.println("Number of questions correct: " + numCorrect + "\nNumber of questions incorrect: " + numIncorrect);
            return 1;
        } else {
            System.out.println("Please ask your teacher for extra help.");
            System.out.println("Number of questions correct: " + numCorrect + "\nNumber of questions incorrect: " + numIncorrect);
            return 0;
        }
    }

    public static int timesSet(int bound) {
        int temp;
        int numCorrect = 0;
        int numIncorrect = 0;
        double percentage = 0;
        for (int i = 0; i < 10; i++) {
            temp = timesQuestions(bound);
            if (temp == 1) {
                numCorrect++;
            } else {
                numIncorrect++;
            }
        }
        percentage = numCorrect / 10.0;
        if (percentage > 0.75) {
            System.out.println("Congratulations, you are ready to go to the next level!");
            System.out.println("Number of questions correct: " + numCorrect + "\nNumber of questions incorrect: " + numIncorrect);
            return 1;
        } else {
            System.out.println("Please ask your teacher for extra help.");
            System.out.println("Number of questions correct: " + numCorrect + "\nNumber of questions incorrect: " + numIncorrect);
            return 0;
        }
    }

    public static int subtractionSet(int bound) {
        int temp;
        int numCorrect = 0;
        int numIncorrect = 0;
        double percentage = 0;
        for (int i = 0; i < 10; i++) {
            temp = subtractionQuestions(bound);
            if (temp == 1) {
                numCorrect++;
            } else {
                numIncorrect++;
            }
        }
        percentage = numCorrect / 10.0;
        if (percentage > 0.75) {
            System.out.println("Congratulations, you are ready to go to the next level!");
            System.out.println("Number of questions correct: " + numCorrect + "\nNumber of questions incorrect: " + numIncorrect);
            return 1;
        } else {
            System.out.println("Please ask your teacher for extra help.");
            System.out.println("Number of questions correct: " + numCorrect + "\nNumber of questions incorrect: " + numIncorrect);
            return 0;
        }
    }

    public static int divisionSet(int bound) {
        int temp;
        int numCorrect = 0;
        int numIncorrect = 0;
        double percentage = 0;
        for (int i = 0; i < 10; i++) {
            temp = divisionQuestions(bound);
            if (temp == 1) {
                numCorrect++;
            } else {
                numIncorrect++;
            }
        }
        percentage = numCorrect / 10.0;
        if (percentage > 0.75) {
            System.out.println("Congratulations, you are ready to go to the next level!");
            System.out.println("Number of questions correct: " + numCorrect + "\nNumber of questions incorrect: " + numIncorrect);
            return 1;
        } else {
            System.out.println("Please ask your teacher for extra help.");
            System.out.println("Number of questions correct: " + numCorrect + "\nNumber of questions incorrect: " + numIncorrect);
            return 0;
        }
    }

    public static int mixMatchSet(int bound) {
        int temp;
        int numCorrect = 0;
        int numIncorrect = 0;
        double percentage = 0;
        SecureRandom rand = new SecureRandom(4);
        for (int i = 0; i < 10; i++) {
            switch (rand.getNum1()) {
                case 0:
                    temp = additionQuestions(bound);
                    break;
                case 1:
                    temp = subtractionQuestions(bound);
                    break;
                case 2:
                    temp = timesQuestions(bound);
                    break;
                case 3:
                    temp = divisionQuestions(bound);
                    break;
                default:
                    temp = 0;
                    break;
            }
            if (temp == 1) {
                numCorrect++;
            } else {
                numIncorrect++;
            }
            rand.reroll(4);
        }
        percentage = numCorrect / 10.0;
        if (percentage > 0.75) {
            System.out.println("Congratulations, you are ready to go to the next level!");
            System.out.println("Number of questions correct: " + numCorrect + "\nNumber of questions incorrect: " + numIncorrect);
            return 1;
        } else {
            System.out.println("Please ask your teacher for extra help.");
            System.out.println("Number of questions correct: " + numCorrect + "\nNumber of questions incorrect: " + numIncorrect);
            return 0;
        }
    }

}
