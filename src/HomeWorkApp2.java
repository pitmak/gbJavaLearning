public class HomeWorkApp2 {
    public static void main(String[] args) {
        System.out.println(checkSum1020(1, 3));
        System.out.println(checkSum1020(7, 8));

        printNumSign(-1);
        printNumSign(1);

        System.out.println(checkNumNegative(-1));
        System.out.println(checkNumNegative(1));

        printStrMultiple("Test", 3);
        printStrMultiple("Hidden", 0);

        System.out.println(isLeapYear(2000));
        System.out.println(isLeapYear(1900));
        System.out.println(isLeapYear(2020));
        System.out.println(isLeapYear(2022));
    }

    static boolean checkSum1020(int a, int b) {
        return a + b >= 10 && a + b <= 20;
    }

    static void printNumSign(int num) {
        System.out.println(num >= 0 ? "Положительное" : "Отрицательное");
    }

    static boolean checkNumNegative(int num) {
        return num < 0;
    }

    static void printStrMultiple(String str, int n) {
        for (int i = 0; i < n; i++)
            System.out.println(str);
    }

    static boolean isLeapYear(int year) {
        if (year % 400 == 0)
            return true;
        if (year % 100 == 0)
            return false;
        return year % 4 == 0;
    }
}
