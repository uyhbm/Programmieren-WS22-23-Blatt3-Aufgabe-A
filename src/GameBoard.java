public class GameBoard {

    //static char[][] gameBoard;
    static char[] gameBoard;
    static char winner;

    public GameBoard(){
        //gameBoard = new char[][]{{'-', '-', '-'}, {'-', '-', '-'}, {'-', '-', '-'}};
        gameBoard = new char[]{'-', '-', '-','-', '-', '-','-', '-', '-'};
        this.winner = ' ';
    }

    /*
    public static void printGameBoard(char[][] gameBoard) {
        String gameBoardOutput = "";
        for(char[] column : GameBoard.gameBoard){
            for(char row : column){
                gameBoardOutput += row;
            }
            gameBoardOutput += "\n";
        }
        System.out.print(gameBoardOutput);
    }

     */

    public static void printGameBoard(char[] gameBoard) {
        String gameBoardOutput = "";
        for(int i = 0; i < gameBoard.length; i++){
            gameBoardOutput += gameBoard[i];
            if(i == 2 || i == 5 || i == 8) {
                gameBoardOutput += "\n";
            }
        }
        System.out.print(gameBoardOutput);
    }

    public static boolean isSpotTaken(int move){
        if (gameBoard[move] == 'x' || gameBoard[move] == 'o') {
            return true;
        }
        return false;
    }

    public static void placeMove(int move){
            gameBoard[move] = TicTacToe.player;
            if(TicTacToe.player == 'x'){
                TicTacToe.player = 'o';
            }else {
                TicTacToe.player = 'x';
            }
            TicTacToe.currentMove++;
    }

    public static boolean checkWin(){
        //check rows
        for (int i = 0; i < gameBoard.length; i+=3){
            if (gameBoard[i] == gameBoard[i+1] && gameBoard[i] == gameBoard[i+2] && gameBoard[i] != '-') {
                winner = gameBoard[i];
                return true;
            }
        }
        //check columns
        for (int i = 0; i < 3; i++){
            if (gameBoard[i] == gameBoard[i+3] && gameBoard[i] == gameBoard[i+6] && gameBoard[i] != '-') {
                winner = gameBoard[i];
                return true;
            }
        }
        //check diagonal
        if (gameBoard[0] == gameBoard[4] && gameBoard[0] == gameBoard[8] && gameBoard[0] != '-') {
            winner = gameBoard[0];
            return true;
        }else if(gameBoard[2] == gameBoard[4] && gameBoard[2] == gameBoard[6] && gameBoard[2] != '-'){
            winner = gameBoard[2];
            return true;
        }
        return false;
    }

    public static char getWinner(char winner){
        return winner;
    }

    /*public static boolean checkGameBoardFilled(){
        if(gameBoard[0] != '-' && gameBoard[1] != '-' && gameBoard[2] != '-' && gameBoard[3] != '-' &&
                gameBoard[4] != '-' && gameBoard[5] != '-' && gameBoard[6] != '-' && gameBoard[7] != '-'
                &&gameBoard[8] != '-'){
            return true;
        }
        return false;
    }
    */
    public static boolean checkGameBoardFilled(){
        for (int i = 0; i < gameBoard.length; i++){
            if(gameBoard[i] == '-'){
                return false;
            }
        }
        return true;
    }
}
