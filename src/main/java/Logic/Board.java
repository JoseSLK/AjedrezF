package Logic;

import Logic.Exeptions.CustomWinExeption;

public class Board {


    private Piece[][] board;

    
    public Piece[][] AssingnQueen(Piece[][] board) {
        board[5][1] = new Queen(true, "Q", 5, 1);
        board[5][8] = new Queen(false, "Q", 5, 8);
        return board;
    }

    //Kings
    public Piece[][] AssingnKings(Piece[][] board) {
        board[4][1] = new King(true, "K", 4, 1);
        board[4][8] = new King(false, "K", 4, 8);
        return board;
    }

    //Pawns
    public Piece[][] AssingnsPawns(Piece[][] board) {
        for (int i = 1; i < 9; i++) {
            board[i][2] = new Pawn(true, "P", i, 2);
            board[i][7] = new Pawn(false, "P", i, 7);
        }
        return board;
    }

    //Knight
    public Piece[][] AssingnsKnight(Piece[][] board) {
        board[2][1] = new Knight(true, "C", 2, 1);
        board[7][1] = new Knight(true, "C", 7, 1);
        board[2][8] = new Knight(false, "C", 2, 8);
        board[7][8] = new Knight(false, "C", 7, 8);
        return board;
    }

    //Bishops, Alfil
    public Piece[][] AssingnsBishops(Piece[][] board) {
        board[3][1] = new Bishop(true, "A", 3, 1);
        board[6][1] = new Bishop(true, "A", 6, 1);
        board[3][8] = new Bishop(false, "A", 3, 8);
        board[6][8] = new Bishop(false, "A", 6, 8);
        return board;
    }

    //Rooks
    public Piece[][] AssingnsRooks(Piece[][] board) {
        board[1][1] = new Rook(true, "T", 1, 1);
        board[8][1] = new Rook(true, "T", 8, 1);
        board[1][8] = new Rook(false, "T", 1, 8);
        board[8][8] = new Rook(false, "T", 8, 8);
        return board;
    }

    

    //Metodos setters y getters
    public Piece[][] getBoard() {
        return board;
    }
    public void setBoard(Piece[][] board) {
        this.board = board;
    }
    public Piece[][] getClonBoard(){
        return board.clone();
    }
   
    public Board() {
        board = new Piece[9][9];
        AssingnKings(board);
        AssingnQueen(board);
        AssingnsBishops(board);
        AssingnsKnight(board);
        AssingnsPawns(board);
        AssingnsRooks(board);
    }
    //Metodo mover pieza
    public Piece[][] movePiece (int cordX, int cordY, int newCordX, int newCordY, Piece type, boolean color) throws CustomWinExeption{
        if (type != null) {

            if(board[newCordX][newCordY] != null && (type.getColor() != board[newCordX][newCordY].getColor()) && board[newCordX][newCordY].getName().equals("K")) {
                String turn = "";
                if(color){turn = "Blanco";}else turn="Negro";
                throw new CustomWinExeption("");
            }
            // actualiza el tablero real
            board[cordX][cordY] = null;
            board[newCordX][newCordY] = type;
        }
        return null;
    }

}