public class HomeWorkApp {
    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
    }

    public static void printThreeWords() {
        System.out.println("Orange\nBanana\nApple");
    }

    public static void checkSumSign() {
        int a = 1;
        int b = 2;

        if (a+b >= 0)
            System.out.println("Сумма положительная");
        else
            System.out.println("Сумма отрицательная");
    }

    public static void printColor() {
        int value = 3;

        if (value <= 0)
            System.out.println("Красный");
        else if (value <= 100)
            System.out.println("Желтый");
        else
            System.out.println("Зеленый");
    }

    public static void compareNumbers() {
        int a = 4;
        int b = 5;

        System.out.println(a >= b ? "a >= b" : "a < b");
    }
}
