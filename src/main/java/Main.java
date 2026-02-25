import java.util.Scanner;

public class Main {

    static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter first number:");
        double a = scanner.nextDouble();

        System.out.println("Enter second number:");
        double b = scanner.nextDouble();

        Calc calc = new Calc();
        double sum = calc.add(a, b);

        System.out.println("Sum = " + sum);
    }

}
