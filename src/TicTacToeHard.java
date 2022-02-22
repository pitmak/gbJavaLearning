import java.util.Random;
import java.util.Scanner;

/**
 * Hard-версия крестиков-ноликов.
 * параметры игры задаются в конструкторе:
 * size - размер поля;
 * cond - размер необходимой для победы комбинации
 *
 * @author pitmak
 * @version 18.02.2022
 */
public class TicTacToeHard {
    int mapSize;
    int winCond;
    char[][] map; // map[i][j]: i - строка, j - столбец
    Scanner scan;
    Random rand;

    public static void main(String[] args) {
 //        new TicTacToeHard(3, 3).doGame();
        new TicTacToeHard(5, 4).doGame();
    }

    TicTacToeHard(int size, int cond) {
        mapSize = size;
        winCond = cond;
        map = new char[mapSize][mapSize];
        scan = new Scanner(System.in);
        rand = new Random();

        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
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
        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                System.out.print(map[i][j] + "  ");
            }
            System.out.println();
        }
    }

    boolean checkHorizontalLines(char ch) {
        for (int i = 0; i < mapSize; i++) {
            int chainLength = 0;
            for (int j = 0; j < mapSize; j++) {
                if (map[i][j] == ch) {
                    chainLength++;
                    if (chainLength == winCond) {
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
        for (int j = 0; j < mapSize; j++) {
            int chainLength = 0;
            for (int i = 0; i < mapSize; i++) {
                if (map[i][j] == ch) {
                    chainLength++;
                    if (chainLength == winCond) {
                        return true;
                    }
                } else {
                    chainLength = 0;
                }
            }
        }
        return false;
    }

    boolean checkDiagonal24Lines(char ch) {
        for (int k = winCond - mapSize; k <= mapSize - winCond; k++) {
            int iStart = Math.max(k, 0);
            int jStart = -Math.min(k, 0);
            int chainLength = 0;
            for (int i = iStart, j = jStart; i < mapSize && j < mapSize; i++, j++) {
                if (map[i][j] == ch) {
                    chainLength++;
                    if (chainLength == winCond) {
                        return true;
                    }
                } else {
                    chainLength = 0;
                }
            }
        }
        return false;
    }

    boolean checkDiagonal13Lines(char ch) {
        for (int k = winCond - mapSize; k <= mapSize - winCond; k++) {
            int iStart = Math.max(k, 0);
            int jStart = mapSize - 1 + Math.min(k, 0);
            int chainLength = 0;
            for (int i = iStart, j = jStart; i < mapSize && j >= 0; i++, j--) {
                if (map[i][j] == ch) {
                    chainLength++;
                    if (chainLength == winCond) {
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
                checkDiagonal24Lines(ch) ||
                checkDiagonal13Lines(ch);
    }

    boolean checkFull() {
        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                if (map[i][j] == '.') {
                    return false;
                }
            }
        }
        return true;
    }

    boolean isValidCell(int x, int y) {
        if (x < 0 || y < 0 || x >= mapSize || y >= mapSize) {
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

    boolean isWinTurnForCh(int i, int j, char ch) {
        map[i][j] = ch;
        boolean answer = checkWin(ch);
        map[i][j] = '.';
        return answer;
    }

    void compTurn() {
        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                if (isValidCell(i, j) && isWinTurnForCh(i, j, 'O')) {
                    map[i][j] = 'O';
                    return;
                }
            }
        }

        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                if (isValidCell(i, j) && isWinTurnForCh(i, j, 'X')) {
                    map[i][j] = 'O';
                    return;
                }
            }
        }

        int x, y;
        do {
            x = rand.nextInt(mapSize);
            y = rand.nextInt(mapSize);
        } while (!isValidCell(x, y));
        map[x][y] = 'O';
    }
}
