import java.util.Arrays;
import java.util.Scanner;
public class ConnectFour {

    public static void main(String[] args) {
        boolean win=false;
        Scanner s = new Scanner(System.in);
        System.out.println("What would you like the height of the board to be?");
        char y = (char) s.nextInt();
        System.out.println("What would you like the length of the board to be?");
        char x = (char) s.nextInt();
        char[][] board = new char[y][x];
        initializeBoard(board);
        System.out.println("\n" + "Player 1: x");
        System.out.println("Player 2: o");
        while (win == false) {
            System.out.print("\n"+"Player 1: Which column would you like to choose?");
            int column = s.nextInt();
            int place = insertChip(board, column, 'x');
            board[place][column] = 'x';
            printBoard(board);
            win = checkIfWinner(board, column, place, 'x');
            if(win==true){
                System.exit(0);
            }
            System.out.print("\n"+"Player 2: Which column would you like to choose?");
            int column2 = s.nextInt();
            int place2 = insertChip(board, column2, 'o');
            board[place2][column2] = 'o';
            printBoard(board);
            win = checkIfWinner(board, column2, place2, 'o');
            if(win==true){
                System.exit(0);
            }
        }


    }

    public static void printBoard(char[][] array) {
        for (int i = 0; i < array.length; i++) {

            for (int j = 0; j < array[0].length; j++) {
                System.out.print(array[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void initializeBoard(char[][] array) {
        for (int i = 0; i < array.length; i++) {

            for (int j = 0; j < array[0].length; j++) {
                array[i][j] = '-';
                System.out.print(array[i][j]+" ");

            }
            System.out.println();
        }
    }

    public static int insertChip(char[][] array, int col, char chipType) {
        int place = 0;
        if (chipType == 'x') {
            for (int i = 0; i < array.length; i++) {
                if (array[i][col] == '-') {
                    place = i;
                }
            }
        }
        if (chipType == 'o') {
            for (int i = 0; i < array.length; i++) {
                if (array[i][col] == '-') {
                    place = i;
                }
            }
        }
        return place;
    }


    public static boolean checkIfWinner(char[][] array, int col, int row, char chipType) {
        if (chipType == 'x') {
            int p1=0;
            for (int i = 0; i < array.length; i++) {
                if (array[i][col] == 'x') {
                    p1++;
                }
            }
            if (p1 == 4) {
                System.out.println("\n"+"Player 1 won the game!");
                return true;
            }
        }
        if (chipType == 'x') {
            int p1=0;
            for (int i = 0; i < array[0].length; i++) {
                if (array[row][i] == 'x') {
                    p1++;
                }
            }
            if (p1 == 4) {
                System.out.println("\n"+"Player 1 won the game!");
                return true;
            }
        }

        if (chipType == 'o') {
            int p2=0;
            for (int i = 0; i < array.length; i++) {
                if (array[i][col] == 'o') {
                    p2++;
                }
            }
            if (p2 == 4) {
                System.out.println("\n"+"Player 2 won the game!");
                return true;
            }
        }
        if (chipType == 'o') {
            int p2=0;
            for (int i = 0; i < array[0].length; i++) {
                if (array[row][i] == 'o') {
                    p2++;
                }
            }
            if (p2 == 4) {
                System.out.println("\n"+"Player 2 won the game!");
                return true;
            }
        }
if((chipType=='o')||(chipType=='x')) {
    int colCheck=0;
    for (int i = 0; i < array.length; i++) {

        for (int j = 0; j < array[0].length; j++) {
            if(array[i][j] == '-'){
                colCheck++;
            }
        }
    }
    if(colCheck==0){
System.out.println("\n"+"Draw. Nobody wins.");
return true;
    }
}
        return false;
    }
}
