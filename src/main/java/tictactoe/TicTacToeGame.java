package tictactoe;
import java.util.*;
public class TicTacToeGame {

	static char[] board = new char[10];
    private static char cross = 'X';
    private static char zero = 'O';
    private static char player;
    private static char computer;


    public static char[] creatingBoard() {

        for (int i = 1; i < board.length; i++) {
            board[i] = ' ';
        }
        return board;

    }

    private static void allowPlayerToChoose() {
        System.out.println("Enter X or O you want to choose");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        player = input.charAt(0);

        if (player == cross) {
            player = cross;
            computer = zero;
            System.out.println("player symbol : " + player);

        } else if (player == zero) {
            player = zero;
            computer = cross;
            System.out.println("player symbol : " + player);

        } else {
            System.out.println("Invalid Character");
        }

    }

    public static void showBoard() {
        System.out.println("Unassigned board  :");
        System.out.println("");
        System.out.println("   "+board[1]+"   " + "|" +"   "+board[2]+ "   " + "|" +"   "+board[3]+ "   ");
        System.out.println("  -------------------");
        System.out.println("   "+board[4]+"   " + "|" +"   "+board[5]+ "   " + "|" +"   "+board[6]+ "   ");
        System.out.println("  -------------------");
        System.out.println("   "+board[7]+"   " + "|" +"   "+board[8]+ "   " + "|" +"   "+board[9]+ "   ");

    }
    
    public static void userMove()
    {
        System.out.println("Enter between(1-9) where you want to make a move ");
        Scanner sc = new Scanner(System.in);
        int position = sc.nextInt();
        if(position>=1 && position <=9)
        {
            if(board[position]==' ')
            {
                board[position] = player;
                showBoard();
            }
            else
            {
                System.out.println("Invalid move, Position is not Empty");
            }
        }
        else
        {
            System.out.println("Invalid Position");

        }
    }
    
    public static void computerMove() {
		Random random = new Random();
		int compPlay = random.nextInt(10);   
		if (compPlay >= 1 && compPlay <= 9 && board[compPlay] == ' '  )
		{
			if (board[compPlay] == ' ') {
				
				board[compPlay] = zero;
				showBoard();
			} else {
				System.out.println("Invalid move, position is not empty");
			}
		} else {
			computerMove();
		}
		System.out.println("Player's turn");

	}
    

    public static void main(String args[]) {

        System.out.println("Welcome to TicTacToe Board Game");
        board = creatingBoard();
        allowPlayerToChoose();
        showBoard();
        userMove();
        computerMove();
    }
}