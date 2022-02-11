public class HomeWorkApp2 {

    public static void main(String[] args) {
        System.out.println(checkSum1020(1,3));
        System.out.println(checkSum1020(7,8));
     }

    static boolean checkSum1020(int a, int b) {
        return a+b>=10 && a+b<=20;
    }

    public static void checkSumSign() {
        int a = 1;
        int b = 2;

        if (a + b >= 0)
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

