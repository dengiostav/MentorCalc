package Сalculator;

import java.util.ArrayList;
import java.util.Scanner;

public class Processing extends Conversion {

    public ArrayList<String> ArrayOperands = new ArrayList<String>();

    public void input(){                // считывает входные данные, проверяет на правильность ввода(чтобы не было арабских вместе с римскими, были только указанные операнды)
        ArrayOperands.add("+");
        ArrayOperands.add("-");
        ArrayOperands.add("*");
        ArrayOperands.add("/");
    Scanner sc = new Scanner(System.in);
    String s = sc.nextLine();
    try {
        String[] parts = s.split(" ");
    String a = parts[0], b = parts[2], operand = parts[1];
    if(parts.length != 3 || !ArrayOperands.contains(operand))
    {System.out.println("Ошибка, неверные входные данные!");
    System.exit(1);
    }
    if((RimOrArab(a).equals("RIM") && RimOrArab(b).equals("RIM")))
    {
        System.out.println(ArabicToRoman(check(a, b,operand)));
    }
    else if((RimOrArab(a).equals("ARAB") && RimOrArab(b).equals("ARAB")))
    {
        System.out.println(check(a,b,operand));
    }
    else
    {
        System.out.println("Ошибка, неверные входные данные!");
        System.exit(1);
    }}catch (ArrayIndexOutOfBoundsException e){
        System.out.println("Ошибка, неверные входные данные!");
        System.exit(1);
    }
}
private int isDigit(String s)          // вспомогательный метод - превращает римские или арабское из строки в целочисленное, если не удается извлечь число выдает ноль

{
    int i;
        try {
            i = Integer.parseInt(s);

     }catch (Exception e){
            i = RomanToArabic(s);
        }
        if(i >=1 && i <= 10)            // проверка числа, находится ли оно в диапозоне от 1 до 10
        return i;
        else return 0;
}
private String RimOrArab(String a)          //вспомогательный метод - возвращает "RIM" при входном римском числе и "ARAB" при арабском числе
    {
        String Rim = "RIM", Arab = "ARAB";
        int i;
        try {
            i = Integer.parseInt(a);
            return Arab;
        } catch (Exception e)
        {
            return Rim;
        }
    }

    private int check(String s, String s1, String operand) {        // принимает 2 числа и операнд, выполняет математичекие действия
        int x = 0;
        try {
            int k;
            int m;
            k = 7 / isDigit(s);
            m = 7 / isDigit(s1);
            int a = isDigit(s), b = isDigit(s1);
            switch (operand) {
                case "+":
                    x = a + b;
                    break;
                case "-":
                    x = a - b;
                    break;
                case "*":
                    x = a * b;
                    break;
                case "/":
                    x = a / b;
                    break;
            }
        } catch (ArithmeticException e) {

            System.out.println("Ошибка, неверные входные данные!");
            System.exit(x);
        }
        return x;
    }
}
