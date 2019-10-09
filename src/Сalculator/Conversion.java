package Сalculator;
import java.lang.Character. *;
import java.lang.StringBuffer;
import java.lang.StringBuilder;
public class Conversion {
    String[] RomanNumerals = {"I", "IV", "V","IX","X","XL","L","XC","C" };
    public int RomanToArabic(String s){             // метод перевода римских в арабские
        int  value = 0;
        char[] RomanNum = {'I', 'V','X','L', 'C'};
        int[] ArabNum = {1, 5, 10,50,100};
        StringBuffer stringBuffer = new StringBuffer(s);
       int i = 0;
           do {
               if ((stringBuffer.charAt(i) == RomanNum[0]) && (stringBuffer.length() != 1) && (stringBuffer.charAt(i + 1) == RomanNum[1])) {
                   value = value + ArabNum[1] - ArabNum[0];
                   stringBuffer.delete(i, i + 2);

               } else if ((stringBuffer.charAt(i) == RomanNum[2]) && (stringBuffer.length() != 1) && (stringBuffer.charAt(i + 1) == RomanNum[3])) {
                   value = value + ArabNum[3] - ArabNum[2];
                   stringBuffer.delete(i, i + 2);

               } else if ((stringBuffer.charAt(i) == RomanNum[2]) && (stringBuffer.length() != 1) && (stringBuffer.charAt(i + 1) == RomanNum[4])) {
                   value = value + ArabNum[4] - ArabNum[2];
                   stringBuffer.delete(i, i + 2);
               } else if ((stringBuffer.charAt(i) == RomanNum[0]) && (stringBuffer.length() != 1) && (stringBuffer.charAt(i + 1) == RomanNum[2])) {
                   value = value + ArabNum[2] - ArabNum[0];
                   stringBuffer.delete(i, i + 2);
               } else {
                   value = value + identify(stringBuffer.charAt(i));
                   stringBuffer.deleteCharAt(i);
               }
           }
           while (stringBuffer.length() != 0);
        return value;
        }
    private int identify(char S){
    String s = Character.toString(S);
        int value = 0;
     if (s.equals("I"))
         value = 1;
     else if (s.equals("V"))
         value = 5;
     else if(s.equals("X"))
         value = 10;
     else if(s.equals("L"))
         value = 50;
     else if(s.equals("C"))
         value =100;
     return value;
    }
    public String ArabicToRoman(int Number)         // метод перевода из арабских в римские
    {
        String result = "";
        int[] ArabNumerals = {1, 4, 5, 9, 10, 40, 50, 90, 100};
        int FirstNum = (Number/10)*10, SecondNum = Number%10;
            int count1 = 8, count2 = 3;
            boolean flag2 = true, flag1 = true;
        while (flag1 != false)
        {
            if (FirstNum != 0 )
            {
                if (FirstNum/ArabNumerals[count1] != 0)
                {
                    FirstNum = FirstNum - ArabNumerals[count1];
                    result = result + RomanNumerals[count1];
                }
                else
                {
                    count1--;
                }
            }
            else
            {
                flag1 = false;
            }
        }
           while (flag2 != false)
            {
                if (SecondNum != 0 )
                {
                if (SecondNum/ArabNumerals[count2] != 0)
                {
                    SecondNum = SecondNum - ArabNumerals[count2];
                    result = result + RomanNumerals[count2];
                }
                else
                    {
                    count2--;
                    }
                }
                else
                {
                    flag2 = false;
                }

            }
       return result;
    }
}
