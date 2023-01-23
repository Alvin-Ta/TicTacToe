package eecs1022.lab8.tictactoe.model;

public class Game {
    String x;
    String p1 = "";
    String p2 = "";
    boolean winner = false;
    private int turns = 1;
    int val = 1;
    int rows;
    int cols;
    char[][] newArray2D = {
            {'_', '_', '_'},
            {'_', '_', '_'},
            {'_', '_', '_'}
    };
    int c = 1;
    boolean something = false;
    String currentPlayer;

    public Game(String player1, String player2) {
        p1 = player1;
        p2 = player2;
        x = ""+getCurrentPlayer()+"'s turn to play...";
    }

    public String getStatus() {
        return x;
    }
    public char[][] getBoard() {
        return newArray2D;
    }

    public String getCurrentPlayer()
    {
        if (c == 1) {
            currentPlayer = p1;
        }
        else if (c == 2) {
            currentPlayer = p2;
        }
        return currentPlayer;
    }

    public void setWhoPlaysFirst(char v) {
        if (v == 'o') {
            c = 2;
        }
        x = ""+getCurrentPlayer()+"'s turn to play...";

    }

    public void move(int i, int j) {
        rows = i;
        cols = j;
        if (didTheyWin() == true) {
            x = "Error: game is already over with a winner.";
        }

        else if (didTheyWin() == false && turns >= 10) {
            x = "Error: game is already over with a tie.";
        }

        else if (i < 1 || i > 3 && turns <= 9 && didTheyWin() == false) {
            x = "Error: row "+i+" is invalid.";
        }
        else if (j > 3 || j < 1 && turns <= 9 && didTheyWin() == false) {
            x = "Error: col "+j+" is invalid.";
        }
        else if (i >= 1 && i <= 3 && j >= 1 && j <= 3 && turns <= 9 && didTheyWin() == false && isPosTaken() == false) {
            x = "Error: slot @ ("+i+", "+j+") is already occupied.";
        }
        else if (turns <= 9 && didTheyWin() == false) {
            x = ""+getCurrentPlayer()+"'s turn to play...";


            if (val > 0) {
                int row = i - 1;
                int col = j - 1;
                if (getCurrentPlayer() == p1) {
                    newArray2D[row][col] = 'x';
                    turns++;
                    c = 2;

                }
                else if (getCurrentPlayer() == p2) {
                    newArray2D[row][col] = 'o';
                    c = 1;
                    turns++;
                }
            }

            if (turns <= 9 && didTheyWin() == false)
                x = ""+getCurrentPlayer()+"'s turn to play...";

            else if (turns >= 9 && didTheyWin() == false) {
                x = "Game is over with a tie between "+p1+" and "+p2+".";
                p2 = null;
                p1 = null;
            }
            else {
                String theWinner;
                if (c == 1) {
                    theWinner = p2;
                }
                else {
                    theWinner = p1;
                }
                p1 = null;
                p2 = null;
                x = "Game is over with "+theWinner+" being the winner.";
            }
        }

    }

    public boolean didTheyWin() {
        if (winwithX() == true || winwithO() == true) {
            winner = true;
        }
        else {
            winner = false;
        }
        return winner;
    }




    public boolean winwithX() {
        if (newArray2D[0][0] == 'x' && newArray2D[1][0] == 'x' && newArray2D[2][0] == 'x')
        {
            return true;
        }
        else if (newArray2D[2][0] == 'x' && newArray2D[2][1] == 'x' && newArray2D[2][2] == 'x')
        {
            return true;
        }
        else if (newArray2D[0][2] == 'x' && newArray2D[1][2] == 'x' && newArray2D[2][2] == 'x')
        {
            return true;
        }
        else if (newArray2D[0][0] == 'x' && newArray2D[0][1] == 'x' && newArray2D[0][2] == 'x')
        {
            return true;
        }
        else if (newArray2D[0][1] == 'x' && newArray2D[1][1] == 'x' && newArray2D[2][1] == 'x')
        {
            return true;
        }
        else if (newArray2D [1][0] == 'x' && newArray2D[1][1] == 'x' && newArray2D[1][2] == 'x')
        {
            return true;
        }
        else if (newArray2D[0][0] == 'x' && newArray2D[1][1] == 'x' && newArray2D[2][2] == 'x')
        {
            return true;
        }
        else if (newArray2D[0][2] == 'x' && newArray2D[1][1] == 'x' && newArray2D[2][0] == 'x')
        {
            return true;
        }
        else
        {
            return false;
        }

    }
    public boolean winwithO() {

        if (newArray2D[0][0] == 'o' && newArray2D[1][0] == 'o' && newArray2D[2][0] == 'o')
        {
            return true;
        }
        else if (newArray2D[2][0] == 'o' && newArray2D[2][1] == 'o' && newArray2D[2][2] == 'o')
        {
            return true;
        }
        else if (newArray2D[0][2] == 'o' && newArray2D[1][2] == 'o' && newArray2D[2][2] == 'o')
        {
            return true;
        }
        else if (newArray2D[0][0] == 'o' && newArray2D[0][1] == 'o' && newArray2D[0][2] == 'o')
        {
            return true;
        }
        else if (newArray2D[0][1] == 'o' && newArray2D[1][1] == 'o' && newArray2D[2][1] == 'o')
        {
            return true;
        }
        else if (newArray2D [1][0] == 'o' && newArray2D[1][1] == 'o' && newArray2D[1][2] == 'o')
        {
            return true;
        }
        else if (newArray2D[0][0] == 'o' && newArray2D[1][1] == 'o' && newArray2D[2][2] == 'o')
        {
            return true;
        }
        else if (newArray2D[0][2] == 'o' && newArray2D[1][1] == 'o' && newArray2D[2][0] == 'o')
        {
            return true;
        }
        else
        {
            return false;
        }

    }
    public boolean isPosTaken() {

        if (rows >= 1 && rows <= 3 && cols >= 1 && cols <= 3) {
            int row = rows - 1;
            int col = cols - 1;
            if (newArray2D[row][col] == '_')
            {
                something = true;

            }
            else
            {
                something = false;
            }
        }
        return something;
    }


    public String printBoard(char[][] board) {
        String s = "";
        for (int i=0; i < board.length; i++) {
            s += "            ";
            for (int j=0; j < board[i].length; j++) {
                s += board[i][j];
                s += "  ";
            }
            s += "\n";
        }
        return s.toString();
    }


}

