package main;

import java.util.Scanner;

public class gameLogic {
    public void game(String[] questionsDM, boolean[] answersDM, String[] questionsCSci, boolean[] answersCSci, String[] questionsCOrg, boolean[] answersCOrg) {

        int correct = 0, score = 0;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the quiz. There are 3 different difficutly questions and each of them are worth a different amount of points, \nBeginner gives 1, Intermediate gives 3 and Expert gives 5. \nPress Enter to start.");
        scanner.nextLine(); // once they press enter the timer starts

        long startTime = System.currentTimeMillis(); // gets the time so when quiz over it can take it away from the time it is when they finish to get elapsed time

        System.out.println("Answer the following 6 questions on Discrete Maths:");
        for (int i = 0; i < 6; i++) {
            System.out.println(questionsDM[i]);
            boolean answer = scanner.nextBoolean();
            if (answer == answersDM[i]) {
                correct++;
                System.out.println("Correct, you have answered "+correct+" questions correctly");
                for (int j = 0; j < questionsDM.length; j++) { // check every index in questionsDM and if that element is in
                    String question = questionsDM[i];			// either expertDM, intermediateDM or beginnerDM then you get score
                    if (isInArray(question, expertDM)) {
                        score += 5; // expert gives 5 score
                    } else if (isInArray(question, intermediateDM)) {
                        score += 3; // intermediate gives 3 score
                    } else {
                        score += 1; // beginner gives 1 score
                    }
                    // System.out.println(score); testing if the score counter works as intended
                    break;
                }
            } else {
                System.out.println("Incorrect, the answer was: "+answersDM[i]);
            }
        }

        System.out.println("Answer the following 6 questions on Computer Science:");
        for (int i = 0; i < 6; i++) {
            System.out.println(questionsCSci[i]);
            boolean answer = scanner.nextBoolean();
            if (answer == answersCSci[i]) {
                correct++;
                System.out.println("Correct, you have answered "+correct+" questions correctly");
                for (int j = 0; j < questionsCSci.length; j++) {
                    String question = questionsCSci[i];
                    if (isInArray(question, expertCSci)) {
                        score += 5;
                    } else if (isInArray(question, intermediateCSci)) {
                        score += 3;
                    } else {
                        score += 1;
                    }
                    break;
                }
            } else {
                System.out.println("Incorrect, the answer was: "+answersCSci[i]);
            }
        }

        System.out.println("Answer the following 6 questions on Computer Organisation:");
        for (int i = 0; i < 6; i++) {
            System.out.println(questionsCOrg[i]);
            boolean answer = scanner.nextBoolean();
            if (answer == answersCOrg[i]) {
                correct++;
                System.out.println("Correct, you have answered "+correct+" questions correctly");
                for (int j = 0; j < questionsCOrg.length; j++) {
                    String question = questionsCOrg[i];
                    if (isInArray(question, expertCOrg)) {
                        score += 5;
                    } else if (isInArray(question, intermediateCOrg)) {
                        score += 3;
                    } else {
                        score += 1;
                    }
                    break;
                }
            } else {
                System.out.println("Incorrect, the answer was: "+answersCOrg[i]);
            }
        }

        long endTime = System.currentTimeMillis(); // get time they finish the quiz
        long elapsedTime = endTime - startTime; // end - start = elapsed
        long seconds = elapsedTime / 1000; // converts from miliseconds to seconds
        // System.out.println(seconds);
        long minutes = seconds / 60; // converts from seconds to minutes
        seconds %= 60; // get the modulus to get the amount of left over seconds

        System.out.println("The quiz is over, you answered "+correct+" questions correctly out of 18");
        double percent = (correct/18.0)*100;
        System.out.println("You got "+percent+"%");
        System.out.println("Quiz completed in " + minutes + " minutes and " + seconds + " seconds.");
        System.out.println("You got a total score of "+score);


    }

    // method to check if a question is in an array
    private static boolean isInArray(String question, String[] array) {
        for (String item : array) {
            if (item.equals(question)) {
                return true;
            }
        }
        return false;
    }

}