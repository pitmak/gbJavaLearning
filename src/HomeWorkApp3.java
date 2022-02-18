import java.util.Arrays;
import java.util.Random;

/**
 * Третья домашка
 *
 * @author pitmak
 * @version 15.02.2022
 */
public class HomeWorkApp3 {
    public static void main(String[] args) {
        String s = 2+2+"sdf";
        System.out.println(s);
        System.out.println("\nЗадача 1: Инверсия массива");
        doArrayInverse();

        System.out.println("\nЗадача 2: Заполнение массива");
        doArrayFilling();

        System.out.println("\nЗадача 3: Модификация массива");
        doArrayModify();

        System.out.println("\nЗадача 4: Квадратный массив");
        doSquareArray();

        System.out.println("\nЗадача 5: Инициализация массива");
        System.out.println(Arrays.toString(createArray(7, 8)));

        System.out.println("\nЗадача 6: Поиск минимума/максимума в массиве");
        findMinMaxInArray();

        System.out.println("\nЗадача 7: Определение сбалансированности массива");
        int[] arr1 = {2, 2, 2, 1, 2, 2, 10, 1};
        System.out.println(Arrays.toString(arr1));
        System.out.println(checkArrayBalance(arr1) ? "Сбалансирован" : "Несбалансирован");
        int[] arr2 = {2, 2, 2, 1, 2, 2, 10, 2};
        System.out.println(Arrays.toString(arr2));
        System.out.println(checkArrayBalance(arr2) ? "Сбалансирован" : "Несбалансирован");

        System.out.println("\nЗадача 8: Сдвиг массива");
        int[] arr3 = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(Arrays.toString(arr3));
        shiftArray(arr3, 2);
        System.out.println("<<< 2");
        System.out.println(Arrays.toString(arr3));
        shiftArray(arr3, -3);
        System.out.println(">>> 3");
        System.out.println(Arrays.toString(arr3));
    }

    static void doArrayInverse() {
        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};

        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (arr[i] == 0) ? 1 : 0;
        }
        System.out.println(Arrays.toString(arr));
    }

    static void doArrayFilling() {
        int[] arr = new int[100];

        for (int i = 0; i < arr.length; ) {
            arr[i] = ++i;
        }
        System.out.println(Arrays.toString(arr));
    }

    static void doArrayModify() {
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] *= 2;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    static void doSquareArray() {
        int[][] arr = new int[6][6];

        for (int i = 0; i < arr.length; i++) {
            arr[i][i] = 1;
            arr[i][arr.length - i - 1] = 1;
            System.out.println(Arrays.toString(arr[i]));
        }
    }

    static int[] createArray(int len, int initialValue) {
        int[] arr = new int[len];

        for (int i = 0; i < len; i++) {
            arr[i] = initialValue;
        }
        return arr;
    }

    static void findMinMaxInArray() {
        final int ARR_SIZE = 10;
        final int MAX_VALUE = 100;
        int[] arr = new int[ARR_SIZE];
        Random rnd = new Random();
        int max = 0;
        int min = MAX_VALUE;

        for (int i = 0; i < ARR_SIZE; i++) {
            arr[i] = rnd.nextInt(MAX_VALUE);
        }

        for (int i = 0; i < ARR_SIZE; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        System.out.println(Arrays.toString(arr));
        System.out.printf("Максимум в массиве: %s\n", max);
        System.out.printf("Минимум в массиве: %s\n", min);
    }

    static boolean checkArrayBalance(int[] arr) {
        int arrSum = 0;
        for (int elem : arr) {
            arrSum += elem;
        }

        if (arrSum % 2 != 0) {
            return false;
        }

        int arrHalfSum = arrSum / 2;
        arrSum = 0;
        for (int elem : arr) {
            arrSum += elem;
            if (arrSum == arrHalfSum) {
                return true;
            }
            if (arrSum > arrHalfSum) {
                return false;
            }
        }
        return false;
    }

    static int gcd(int a, int b) {
        if (b == 0)
            return (a > 0) ? a : -a;
        return gcd(b, a % b);
    }

    static void shiftArray(int[] arr, int n) {
        int repeat = gcd(arr.length, n);
        int stepCount = arr.length / repeat - 1;
        for (int i = 0; i < repeat; i++) {
            int currPos = i;
            int backup = arr[currPos];
            for (int j = 0; j < stepCount; j++) {
                int nextPos = (currPos + n + arr.length) % arr.length;
                arr[currPos] = arr[nextPos];
                currPos = nextPos;
            }
            arr[currPos] = backup;
        }
    }
}
