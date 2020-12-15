package converter;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
//        stage 1:

//        int decimal = 110;
//        String binary = "";
//        binary = Integer.toBinaryString(decimal);
//        System.out.println(decimal + " = 0b" + binary);

//        stage 2:
//
//        Scanner scanner = new Scanner(System.in);
//        int input = scanner.nextInt();
//        char[] output = Integer.toOctalString(input).trim().toCharArray();
//        System.out.println(output[output.length-1]);

//        Stage 3:
//
//        Scanner scanner = new Scanner(System.in);
//        int data = scanner.nextInt();
//        int rates = scanner.nextInt();
//        String resutl;
//
//        switch (rates){
//            case 16:
//                resutl = Integer.toHexString(data);
//                System.out.println("0x" + resutl);
//                break;
//            case 8:
//                resutl = Integer.toOctalString(data);
//                System.out.println("0" + resutl);
//                break;
//            case 2:
//                resutl = Integer.toBinaryString(data);
//                System.out.println("0b" + resutl);
//                break;
//            default:
//                System.out.println("Incorrect input");
//        }

//        Stage 4:

//        Scanner scanner = new Scanner(System.in);
//
//        int sourceRadix = scanner.nextInt();
//        String sourceNumber = scanner.next();
//        int targetRadix = scanner.nextInt();
//
//        if (sourceRadix == 1) {
//            int decimal = sourceNumber.length();
//            System.out.println(Integer.toString(decimal, targetRadix));
//        } else if (targetRadix == 1) {
//            int decimal = Integer.parseInt(sourceNumber, sourceRadix);
//            System.out.println("1".repeat(decimal));
//        } else {
//            int decimal = Integer.parseInt(sourceNumber, sourceRadix);
//            System.out.println(Integer.toString(decimal, targetRadix));
//        }

//        Stage 5 / 6:
    Scanner scanner = new Scanner(System.in);
    boolean isError = false;
    int sourceRadix = 0;
    String sourceNumber = "";
    int targetRadix = 0;

    if (scanner.hasNextInt()) {
      sourceRadix = scanner.nextInt();
    }else{
      isError = true;
    }
    if (scanner.hasNext()) {
      sourceNumber = scanner.next();
    }else {
      isError = true;
    }
    if (scanner.hasNextInt()) {
      targetRadix = scanner.nextInt();
    }

    if (sourceRadix < 1 || sourceRadix > 36) isError = true;
    if (targetRadix <1 || targetRadix > 36) isError = true;


    if(isError){
      System.out.println("Error: incorrect input");
    }else {

      if (sourceRadix == 1) {
        int decimal = sourceNumber.length();
        System.out.println(Integer.toString(decimal, targetRadix));
      } else if (targetRadix == 1) {
        int decimal = Integer.parseInt(sourceNumber, sourceRadix);
        System.out.println("1".repeat(decimal));
      } else {
        String[] parts = sourceNumber.split("\\.");
        int integerValue = Integer.parseInt(parts[0], sourceRadix);
        double fractionalValue = 0;
        int power = 1;
        if (parts.length > 1) {
          for (int i = 0; i < parts[1].length(); i++) {
            String part = Character.toString(parts[1].charAt(i));
            fractionalValue += Integer.parseInt(part, sourceRadix) / Math.pow(sourceRadix, power++);
          }
          System.out.print(Integer.toString(integerValue, targetRadix) + ".");
          StringBuilder resultFractionalValue = new StringBuilder();

          for (int i = 0; i < 5; i++) {
            fractionalValue *= targetRadix;
            int toAdd = (int) fractionalValue;
            fractionalValue -= toAdd;
            resultFractionalValue.append(Integer.toString(toAdd, targetRadix));
          }

          String fractionalResult = resultFractionalValue.toString();
          System.out.println(fractionalResult);
        } else {
          int decimal = Integer.parseInt(sourceNumber, sourceRadix);
          System.out.println(Integer.toString(decimal, targetRadix));
        }
      }
    }



  }
}
