import java.util.Scanner;

public class Main {
    public static Scanner scn = new Scanner(System.in);

    public static char board[] = {
        '_','_','_',
        '_','_','_',
        '_','_','_'
    };

    public static int winningMoves[][] =
    {
        //verti
        {0,3,6},
        {1,4,7},
        {2,5,8},
        //Horiz
        {0,1,2},
        {3,4,5},
        {6,7,8},
        //diagon
        {0,4,8},
        {2,4,6}

    };

    public static int turn = 0; // 0 = player 1 (O). || kalau 1 = player 2 (X).
    public static void main(String[] args) {
        startGame();
    }

    public static void printBoard(){
        for(int i = 0 ; i < 3 ; i++){
            for(int j = 0 ; j <  3 ; j++){
                System.out.print(board[i*3 + j]);
                System.out.print(" ");
            }
            System.out.println("");
        }
    }

     public static char getPlayerSign(){
    return (turn == 0 ? 'O' : 'X');
    }

    public static boolean checkWin(char playerSign){
        boolean win = false;
        for(int i = 0 ; i < 8 ; i++){
            boolean valid = true;
            for(int j = 0 ; j < 8 ; j++){
                if(winningMoves[i][j] = playerSign){
                    valid = false;
                }
                if(valid){
                    win = true;
                    break;
                }
            }
        }    
        return win;
    }
    public static boolean placeMove(int x, int y){
        if(x < 0 || x > 2 || y < 0 || y > 2){
            return false;
        }
        
        else{
            board[y*3 + x] = turn ==0 ? 'O' : 'X';
            return true;
        }
        
        // board[y*3+x] = 
    }
    public static void play(){
        int x;
        int y;
        boolean validMove;

        if(checkWin(getPlayerSign())){
            System.out.println("");
        }
        printBoard();
        do{
            
            System.out.print((turn == 0 ? "Player 1" : "Player 2")  + " move : ");
    
            x = scn.nextInt();
            y = scn.nextInt();
            placeMove(x, y);
            validMove = placeMove(x, y);
            if(!validMove){
                System.err.println("You cannot place in this tile!");
            }
        }while(validMove == false);

        if(turn == 0){
            turn  = 1;
        }
            turn  = 0;
        }

        // System.out.println(x);
        // System.err.println(y);
    
    public static void startGame() {
        System.out.println("Welcome to TICTACTOE");


        while(true){
            play();
        }
    }
}
