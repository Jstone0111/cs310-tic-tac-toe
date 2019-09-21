package edu.jsu.mcis;

public class TicTacToeModel {
    
    private Mark[][] board; /* Game board */
    private boolean xTurn;  /* True if X is current player */
    private int width;      /* Size of game board */
    
    /* ENUM TYPE DEFINITIONS */
    
    /* Mark (represents X, O, or an empty square */
    
    public enum Mark {
        
        X("X"), 
        O("O"), 
        EMPTY("-");

        private String message;
        
        private Mark(String msg) {
            message = msg;
        }
        
        @Override
        public String toString() {
            return message;
        }
        
    };
    
    /* Result (represents the final state of the game: X wins, O wins, a TIE,
       or NONE if the game is not yet over) */
    
    public enum Result {
        
        X("X"), 
        O("O"), 
        TIE("TIE"), 
        NONE("NONE");

        private String message;
        
        private Result(String msg) {
            message = msg;
        }
        
        @Override
        public String toString() {
            return message;
        }
        
    };
    
    /* CONSTRUCTOR */
    
    public TicTacToeModel() {
        
        this(TicTacToe.DEFAULT_WIDTH);
        
    }
    
    /* CONSTRUCTOR */
    
    public TicTacToeModel(int width) {
        
        /* Initialize width; X goes first */
        
        this.width = width;
        xTurn = true;
        
        /* Create board (width x width) as a 2D Mark array */
        
        board = new Mark[width][width];

        for (int i=0; i<width; i++){
            for (int j=0; j<width; j++){
                board[i][j] = Mark.EMPTY;
            }
        }

        /* Initialize board by filling every square with empty marks */
        
        // Code Inserted
        
    }
	
    public boolean makeMark(int row, int col) {
        
        /* Use "isValidSquare()" to check if the specified location is in range,
           and use "isSquareMarked()" to see if the square is empty!  If the
           specified location is valid, make a mark for the current player, then
           toggle "xTurn" from true to false (or vice-versa) to switch to the
           other player before returning TRUE.  Otherwise, return FALSE. */

           if (isValidSquare(row, col)){
               if (!isSquareMarked(row, col)){
                   if (xTurn){
                        board[row][col] = Mark.X;
                   }
                   else {
                       board[row][col] = Mark.O;
                   }
                   xTurn = !xTurn;
                   return true;

               }
               else {
                   return false;
               }
           }
           else{
               return false;
           }
        
        // Code Inserted
        
    }
	
    private boolean isValidSquare(int row, int col) {
        
        /* Return TRUE if the specified location is within the bounds of the board */
        
        if ((row >= width || col >= width) || (row < 0 || col < 0)){
        return false;
        }
        else{
            return true;
        }
        // Code Inserted

        
    }
	
    private boolean isSquareMarked(int row, int col) {
        
        /* Return TRUE if the square at specified location is marked */
        if (board[row][col] != Mark.EMPTY){
            return true;
        }
        else{
            return false;
        }
    }
        // Code Inserted
            
	
    public Mark getMark(int row, int col) {
        
        /* Return the mark from the square at the specified location */
        
        return board[row][col];

        // Code Inserted

            
    }
	
    public Result getResult() {
        
        /* Call "isMarkWin()" to see if X or O is the winner, if the game is a
           TIE, or if the game is not over.  Return the corresponding Result
           value */
        
           if (isMarkWin(Mark.X) == true){
            return Result.X;
            }
 
            else if (isMarkWin(Mark.O) == true){
            return Result.O;
            }
            
            else if (isTie() == true){
            return Result.TIE;
            }
 
            else 
            return Result.NONE;
         
         // Code Inserted
        
    }
	
    private boolean isMarkWin(Mark mark) {
        
        /* Check the squares of the board to see if the specified mark is the
           winner */
        
        // INSERT YOUR CODE HERE

        return false; // remove this line later!

    }
	
    private boolean isTie() {
        
        /* Check the squares of the board to see if the game is a tie */

        boolean boardEmpty = true;
        for (int i = 0; i < width; ++i){
            for (int j = 0; j < width; ++j){
                if (board[i][j] != Mark.EMPTY){
                    boardEmpty = false;
                }
            }
        }
        if (boardEmpty){
        return true;
        }
        else {
            return false;
        }
        // Code Inserted
    }

    public boolean isGameover() {
        
        /* Return TRUE if the game is over */
        
        return (Result.NONE != getResult());
        
    }

    public boolean isXTurn() {
        
        /* Getter for xTurn */
        
        return xTurn;
        
    }

    public int getWidth() {
        
        /* Getter for width */
        
        return width;
        
    }
    
    @Override
    public String toString() {
        
        StringBuilder output = new StringBuilder("  ");
        
        /* Output the board contents as a string (see examples) */
        
        // INSERT YOUR CODE HERE
        
        return output.toString();
        
    }
    
}
