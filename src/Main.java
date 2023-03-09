import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print(calc(in.nextLine()));
        in.close();
    }

    private static String ArabicRomanParser(int input) {
        if (input < 1) {
            throw new IllegalArgumentException("Can't out result in roman system");
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        RomanDigit[] romanDigits = RomanDigit.values();
        while (input > 0) {
            RomanDigit digit = romanDigits[i];
            if (digit.getValue()  <= input) {
                sb.append(digit.name());
                input -= digit.getValue();
            } else {
                i++;
            }
        }
        return sb.toString();
    }

    private static int RomanArabicParser(String input) {
        return RomanDigit.valueOf(input).getValue();
    }

    private static int intParser(String input) {
        int result = Integer.parseInt(input);
        if (result < 1 || result > 10) {
            throw new IllegalArgumentException("Incorrect data");
        }
        return result;
    }

    private static int execute(int a, String operator, int b) {
        switch (operator) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;
            default:
                throw new IllegalArgumentException("Illegal operator");
        }
    }

    public static String calc(String input) {
        String[] expression = input.split(" ");
        if (expression.length > 3) {
            throw new IllegalArgumentException("Illegal expression");
        }
        try {
            return String.valueOf(execute(intParser(expression[0]),expression[1],intParser(expression[2])));
        } catch (NumberFormatException e) {
            return ArabicRomanParser(execute(RomanArabicParser(expression[0]),expression[1],RomanArabicParser(expression[2])));
        }
    }

}
