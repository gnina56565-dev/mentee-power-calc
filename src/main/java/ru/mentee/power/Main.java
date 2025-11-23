package ru.mentee.power;

/**
 * Демонстрация работы калькулятора
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(" Welcome ");
        Calculator calculator = new Calculator();

        System.out.println("Add: 5 + 3 = " + calculator.add(5, 3));
        System.out.println("Sub: 10 - 4 = " + calculator.subtract(10, 4));
        System.out.println("Multilpy: 6 * 7 = " + calculator.multiply(6, 7));

        try {
            System.out.println("Divide: 20 / 4 = " + calculator.divide(20, 4));
            System.out.println("Divide: 10 / 3 = " + calculator.divide(10, 3));
            // Раскомментируйте следующую строку для проверки обработки исключения
            // System.out.println("Деление на ноль: " + calculator.divide(5, 0));
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\n Попробуйте мини-игру с калькулятором!");
        playGame();
    }

    /**
     * Мини-игра для демонстрации работы калькулятора
     */
    private static void playGame() {
        Calculator calculator = new Calculator();
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        System.out.println("Я загадал два числа и выполнил операцию. Угадай результат!");

        int a = (int) (Math.random() * 10) + 1;
        int b = (int) (Math.random() * 10) + 1;
        int operation = (int) (Math.random() * 4);

        int result;
        String operationName;

        switch (operation) {
            case 0:
                result = calculator.add(a, b);
                operationName = "сложения";
                break;
            case 1:
                result = calculator.subtract(a, b);
                operationName = "вычитания";
                break;
            case 2:
                result = calculator.multiply(a, b);
                operationName = "умножения";
                break;
            default:
                if (b == 0) b = 1; // Избегаем деления на ноль
                result = (int) calculator.divide(a, b);
                operationName = "деления (целая часть)";
                break;
        }

        System.out.println("Введите результат " + operationName + " чисел " + a + " и " + b + ":");

        int userAnswer = scanner.nextInt();

        if (userAnswer == result) {
            System.out.println("Правильно! Вы великолепны! ");
        } else {
            System.out.println("Не совсем! Правильный ответ: " + result);
        }
    }
}