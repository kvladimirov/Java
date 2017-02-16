//import java.util.Scanner;
//
//public class FormattingNumbers {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        int firstNum = scanner.nextInt();
//        float secondNum = scanner.nextFloat();
//        float thirdNum = scanner.nextFloat();
//
//        String hex = Integer.toHexString(firstNum).toUpperCase();
//        String bin = Integer.toBinaryString(firstNum);
//        String num1 = String.format("%.2f", secondNum);
//        String num2 = String.format("%.3f", thirdNum);
//
//        String hexStr = hex;
//        if (hex.length() < 10){
//
//            for (int i = 0; i < 10 - hex.length(); i++) {
//                hexStr += " ";
//            }
//        }
//        String binStr = "";
//        if (bin.length() < 10){
//
//            for (int i = 0; i < 10 - bin.length(); i++) {
//                binStr += "0";
//            }
//            binStr = binStr + bin;
//        }
//
//
//
//        String numStr1 = "";
//        if (numStr1.length() < 10){
//
//            for (int i = 0; i < 10 - numStr1.length(); i++) {
//                numStr1 += " ";
//            }
//            numStr1 = numStr1 + num1;
//        }
//
//        String numStr2 = num2;
//        if (num2.length() < 10){
//
//            for (int i = 0; i < 10 - num2.length(); i++) {
//                numStr2 += " ";
//            }
//        }
//
//        System.out.printf("|%s|%s|%s|%s|", hexStr, binStr, numStr1, numStr2);
//
//    }
//}

import java.util.Scanner;

public class FormattingNumbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int firstNum = input.nextInt();
        double secondNum =input.nextDouble();
        double thirdNum =input.nextDouble();
        String bin = Integer.toString(firstNum, 2);
        StringBuilder sb = new StringBuilder(bin);
        sb.reverse();
        while(sb.length() <= 10){
            sb.append("0");
        }
        sb.reverse();
        if(sb.length() > 10){
            while(sb.charAt(0) == '0'){
                sb.deleteCharAt(0);
                if(sb.length() == 10){
                    break;
                }
            }
        }
        System.out.printf("|%-10X|%s|%10.2f|%-10.3f|",firstNum, sb.toString(),secondNum,thirdNum);
    }
}