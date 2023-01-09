import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void pinPoint100 (AxisSystem axisSystem){
        axisSystem.addSinglePoint(100, 150, "blue");
    }
    public static void pinPoint200 (AxisSystem axisSystem){
        axisSystem.addSinglePoint(-200, 200, "blue");
    }
    public static void pinMultiplePoints506070 (AxisSystem axisSystem){
        int[] multiplePoints = {50, 50, 60, 60, 70, 70};
        axisSystem.addMultiplePoints(multiplePoints, "blue");
    }
    public static void pinPointsUserInput (AxisSystem axisSystem){
        Scanner scanner = new Scanner(System.in);
        int xParameter = 0;
        int yParameter = 0;
        boolean inRangeX = false;
        boolean inRangeY = false;
        do{
            if (!inRangeX){
                System.out.println("Please enter your X coordinate: ");
                xParameter = scanner.nextInt();
                if (xParameter <= 250 && xParameter >= -250){
                    inRangeX = true;
                }
            }
            if (!inRangeY){
                System.out.println("Please enter your Y coordinate: ");
                yParameter = scanner.nextInt();
                if (yParameter <= 250 && yParameter >= -250){
                    inRangeY = true;
                }
            }
        }while (!inRangeY && inRangeX);
        axisSystem.addSinglePoint(xParameter, yParameter, "red");
    }
    public static void pinRandomPointsUserRequest (AxisSystem axisSystem){
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        System.out.println("Please enter the desired amount of points to print: ");
        int requestedAmount = scanner.nextInt();
        System.out.println("Please enter your desired color: ");
        String color = scanner.next();
        requestedAmount *= 2;
        int[] randomPoints = new int[requestedAmount];
        for (int i = 0; i < requestedAmount - 1; i += 2){
            randomPoints[i] = random.nextInt(-250, 250);
            randomPoints[i + 1] = random.nextInt(-250, 250);
        }
        axisSystem.addMultiplePoints(randomPoints, color);
    }
    public static void printGraph (AxisSystem axisSystem){
        int yHolder = 0;
        int xHolder = 0;
        for (int i = 0; i < 500; i++){
            xHolder = (i - 250);
            yHolder = ((2 * xHolder) + 100);
            axisSystem.addSinglePoint(xHolder, yHolder, "red");
        }
    }
    public static boolean digitsOnly (String check) {
        boolean digitsOnly = true;
        String digitsValidation = "0123456789";
        char currentChar;
        if (check.length() > 0){
            for (int i = 0; i < check.length(); i++) {
                currentChar = check.charAt(i);
                if (!digitsValidation.contains(currentChar + "")) {
                    digitsOnly = false;
                    break;
                }
            }
        }else{
            digitsOnly = false;
        }
        return digitsOnly;
    }
    public static void linearGraph (AxisSystem axisSystem){
        Scanner scanner = new Scanner(System.in);
        final int AXIS_MAX = 250;
        final int AXIS_MIN = -250;
        String linearEquation = "";
        String formatValidating = "y=";
        char formatVariable = 'x';
        String arithmeticAction = "+-";
        String tempCheck = "";
        char temp;
        int slope = 1;
        int modify = 0;
        boolean valid = false;
        do{
            System.out.println("Please enter a linear equation of the form 'y=mx+n': ");
            linearEquation = scanner.nextLine();
            tempCheck = linearEquation.substring(0,Math.min(2, linearEquation.length()));
            if (tempCheck.equals(formatValidating)){
                tempCheck = linearEquation.substring(2, linearEquation.indexOf(formatVariable));
                if (digitsOnly(tempCheck) || tempCheck == ""){
                    if (tempCheck == ""){
                        slope = 1;
                    }else{
                        slope = Integer.valueOf(tempCheck);
                    }
                    temp = linearEquation.charAt(linearEquation.indexOf(formatVariable)+1);
                    if (arithmeticAction.contains(temp + "")){
                        tempCheck = linearEquation.substring(linearEquation.indexOf(temp)+1, linearEquation.length());
                        if (digitsOnly(tempCheck)){
                            modify = Integer.valueOf(tempCheck);
                            valid = true;
                        }
                    }
                }
            }
        }while (!valid);
        int yHolder = 0;
        int xHolder = 0;
        for (int i = 0; i < AXIS_MAX + ((-1) * AXIS_MIN); i++){
            xHolder = (i - AXIS_MAX);
            yHolder = ((slope * xHolder) + modify);
            axisSystem.addSinglePoint(xHolder, yHolder, "red");
        }
    }
    public static void printGraphSecondDegree (AxisSystem axisSystem){
        final int MAX_AXIS = 500;
        int yHolder = 0;
        int xHolder = 0;
        for (int i = 0; i < MAX_AXIS; i++){
            xHolder = (i - (MAX_AXIS)/2);
            yHolder = ((2 * (xHolder * xHolder))-(3 * xHolder) + 50);
            axisSystem.addSinglePoint(xHolder, yHolder, "red");
        }
    }



    public static void main(String[] args) {
        AxisSystem axisSystem = new AxisSystem();
        //pinPoint200(axisSystem);
       // pinPoint100(axisSystem);
       // pinMultiplePoints506070(axisSystem);
       // pinPointsUserInput(axisSystem);
        //pinRandomPointsUserRequest(axisSystem);
       // printGraph(axisSystem);
        linearGraph(axisSystem);
       // printGraphSecondDegree(axisSystem);
    }

}
