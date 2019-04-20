package com.group4.Objects;
import java.util.Scanner;
public class InputReceiver {

    public static String getInput(){
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        return input;
    }

}
