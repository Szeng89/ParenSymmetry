package src.main.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ParenSymmetry {


    private Boolean isBalanced(String s) {
        int leftParent =0;
        int rightParent =0;


        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                leftParent++;
            }
            if(s.charAt(i) == ')'){
                rightParent++;
            }
        }
        // implement this method
        if(leftParent == rightParent){
            return true;
        }
        else{
            return false;
        }
    }

    private void checkFile(String filename) {

        File file = new File("TestStrings0.txt");
        Scanner scan = new Scanner("/Users/shijin/Labs/ParenSymmetry/TestStrings0.txt");

        try{
            scan = new Scanner(file);
            while (scan.hasNextLine()){
                String str = scan.nextLine();
                boolean b = isBalanced(str);
                System.out.println(b);
            }
            scan.close();

        }catch (FileNotFoundException e){
            System.out.println(e.getMessage());
            System.exit(1);
        }

    }

    public static void main(String[] args) {
        ParenSymmetry ps = new ParenSymmetry();

        Boolean b0 = ps.isBalanced("()");
        printResult(b0, true);

        String[] falseStrings = {"(", "((", ")", "", "(()())((())))"};
        Boolean falses = true;
        for (String strToTest : falseStrings) {
            falses = ps.isBalanced(strToTest);
        }
        printResult(falses, false);

        String[] trueStrings = {"()", "(())", "(((())))", "", "(()())((()))", "(   )", "( () ( ) )"};
        Boolean trues = false;
        for (String strToTest : trueStrings) {
            trues = ps.isBalanced(strToTest);
        }
        printResult(trues, true);

    }

    private static void printResult(Boolean b0, boolean b) {
        if (b0 == null) {
            System.out.println("Null Failure");
            return;
        }
        if (b0 == b) {
            System.out.println("Success");
        } else {
            System.out.println("Failure");
        }
    }
}
