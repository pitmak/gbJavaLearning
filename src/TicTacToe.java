import java.util.Random;
import java.util.Scanner;

/**
 * Крестики-нолики 3х3.
 *
 * @author pitmak
 * @version 18.02.2022
 */
public class TicTacToe {
    final int MAP_SIZE = 3;
    char[][] map; // map[i][j]: i - строка, j - столбец
    Scanner scan;
    Random rand;

    public static void main(String[] args) {
        new TicTacToe().doGame();
    }

    TicTacToe() {
        map = new char[MAP_SIZE][MAP_SIZE];
        scan = new Scanner(System.in);
        rand = new Random();

        for (int i = 0; i < MAP_SIZE; i++) {
            for (int j = 0; j < MAP_SIZE; j++) {
                map[i][j] = '.';
            }
        }
    }

    public void doGame() {
        printMap();
        while (true) {
            humanTurn();
            if (checkWin('X')) {
                System.out.println("Вы победили!");
                break;
            }
            if (checkFull()) {
                System.out.println("Ничья");
                break;
            }
            compTurn();
            if (checkWin('O')) {
                System.out.println("Победил компьютер!");
                break;
            }
            if (checkFull()) {
                System.out.println("Ничья");
                break;
            }
            printMap();
        }
        printMap();
        System.out.println("GAME OVER");
    }

    void printMap() {
        for (int i = 0; i < MAP_SIZE; i++) {
            for (int j = 0; j < MAP_SIZE; j++) {
                System.out.print(map[i][j] + "  ");
            }
            System.out.println();
        }
    }

    boolean checkHorizontalLines(char ch) {
        for (int i = 0; i < MAP_SIZE; i++) {
            int chainLength = 0;
            for (int j = 0; j < MAP_SIZE; j++) {
                if (map[i][j] == ch) {
                    chainLength++;
                    if (chainLength == 3) {
                        return true;
                    }
                } else {
                    chainLength = 0;
                }
            }
        }
        return false;
    }

    boolean checkVerticalLines(char ch) {
        for (int j = 0; j < MAP_SIZE; j++) {
            int chainLength = 0;
            for (int i = 0; i < MAP_SIZE; i++) {
                if (map[i][j] == ch) {
                    chainLength++;
                    if (chainLength == 3) {
                        return true;
                    }
                } else {
                    chainLength = 0;
                }
            }
        }
        return false;
    }

    boolean checkWin(char ch) {
        return checkHorizontalLines(ch) ||
                checkVerticalLines(ch) ||
                map[0][0] == ch && map[1][1] == ch && map[2][2] == ch ||
                map[2][0] == ch && map[1][1] == ch && map[0][2] == ch;
    }

    boolean checkFull() {
        for (int i = 0; i < MAP_SIZE; i++) {
            for (int j = 0; j < MAP_SIZE; j++) {
                if (map[i][j] == '.') {
                    return false;
                }
            }
        }
        return true;
    }

    boolean isValidCell(int x, int y) {
        if (x < 0 || y < 0 || x >= MAP_SIZE || y >= MAP_SIZE) {
            return false;
        }
        return map[x][y] == '.';
    }

    void humanTurn() {
        int x, y;
        do {
            System.out.println("Введите № строки и № столбца:");
            x = scan.nextInt() - 1;
            y = scan.nextInt() - 1;
        } while (!isValidCell(x, y));
        map[x][y] = 'X';
    }


    void compTurn() {
        int x, y;
        do {
            x = rand.nextInt(MAP_SIZE);
            y = rand.nextInt(MAP_SIZE);
        } while (!isValidCell(x, y));
        map[x][y] = 'O';
    }
}
