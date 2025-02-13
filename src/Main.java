import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        char[][] board = new char[3][3];

        Scanner scanner = new Scanner(System.in);

        initializeBoard(board);
        printBoard(board);



    }


    // Print Board
    public static void printBoard(char[][] board) {
        System.out.printf(" %c | %c | %c\n", board[0][0], board[0][1], board[0][2]);
        System.out.println("--- --- ---");
        System.out.printf(" %c | %c | %c\n", board[1][0], board[1][1], board[1][2]);
        System.out.println("--- --- ---");
        System.out.printf(" %c | %c | %c\n", board[2][0], board[2][1], board[2][2]);
    }


    // Board inicializa
    public static void initializeBoard (char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public static boolean emptySpace(char[][] board) {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ')
                    return true;
            }
        }
        return false;
    }

    public static boolean winner(char p, char c, char[][] board) {

        for (int i = 0; i < 3; i++) {

            // Check Horizontally
            if (board[i][0] == p && board[i][1] == p && board[i][2] == p) {
                System.out.println("Parabens, o voce venceu!!");
                return true;
            }
            if (board[i][0] == c && board[i][1] == c && board[i][2] == c) {
                System.out.println("Vitoria do computador, mais sorte da proxima vez!!");
                return true;
            }

            // Check verticaly
            if (board[0][i] == p && board[1][i] == p && board[2][i] == p) {
                System.out.println("Parabens, o voce venceu!!");
                return true;
            }
            if (board[0][i] == c && board[1][i] == c && board[2][i] == c) {
                System.out.println("Vitoria do computador, mais sorte da proxima vez!!");
                return true;
            }
        }

        // Check diagonals
        if (board[0][0] == p && board[1][1] == p && board[2[2] == p) {
            System.out.println("Parabens, o voce venceu!!");
            return true;
        }
        if (board[0][0] == c && board[1][1] == c && board[2][2] == c) {
            System.out.println("Vitoria do computador, mais sorte da proxima vez!!");
            return true;
        }

        if (board[0][2] == p && board[1][1] == p && board[2][0] == p) {
            System.out.println("Parabens, o voce venceu!!");
            return true;
        }
        if (board[0][2] == c && board[1][1] == c && board[2][0] == c) {
            System.out.println("Vitoria do computador, mais sorte da proxima vez!!");
            return true;
        }
        return false;
    }

    public static void playerTurn(char[][] board, Scanner scanner, char j) {
        if (emptySpace(board)) {
            System.out.println("Em qual linha deseja jogar? ");
            int line =  scanner.nextInt();
            System.out.println("Em qual coluna deseja jogar? ");
            int column = scanner.nextInt();

            if (board[line][column] == ' ')
                board[line][column] = j;
            else {
                System.out.println("Espaço ja ocupado");
                playerTurn(board, scanner, j);
            }
        }

    }
}

// Define a ordem a ser jogada e as opçoes

// prmeira pessoa joga, e cao haja espaço vazio, e nenhum vencedor, o outro joga

// caso os criterio sejam atendidos o vencedor é anunciado e encerra o porograma, ou cao nao haja mais espaçoes no board