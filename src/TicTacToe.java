import java.util.Scanner;
public class TicTacToe {
    static char player;
    static int currentMove;

    public TicTacToe() {
        player = 'x';
        currentMove = 1;
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        TicTacToe match = new TicTacToe();
        GameBoard gameBoard = new GameBoard();
        GameBoard.printGameBoard(GameBoard.gameBoard);
        while(!GameBoard.checkWin() && !GameBoard.checkGameBoardFilled()){
            System.out.println(match.currentMove + ". Zug: " + match.player);
            int move = input.nextInt();
            if(GameBoard.isSpotTaken(move) || move < 0 || move > 8){
                continue;
            }
            GameBoard.placeMove(move);
            GameBoard.printGameBoard(GameBoard.gameBoard);
        }
        if(GameBoard.checkWin()){
            System.out.println("Sieger: " + GameBoard.winner);
        } else{
            System.out.println("Kein Sieger");
        }

        input.close();
    }
}

