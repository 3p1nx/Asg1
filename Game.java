import java.util.Scanner;

public class Game {
    public static int baris, kolom;
    public static boolean flag = false;
    public static void playGame(){
        printMap();
        

        int i = 1;
        while(i <= 9 && flag ==false){
            
            if(i % 2 != 0){
                int flag = 0;
                do{
                    flag = 0;
                    System.out.println("Player 1 ");
                    System.err.print("Insert Baris Kolom : ");
                    baris = scn.nextInt();
                    kolom = scn.nextInt();
                    if( baris <= 0 || baris >3 || kolom <=0 || kolom > 3){
                        flag = 1;
                    }else if(Map[baris-1][kolom-1] != '_') flag = 2;
                    if(flag == 1) System.out.println("This tile is not available!");
                    else System.out.println("This tile has been taken!");
                }while(flag != 0);
            }
            else{
                int flag = 0;
                do{
                    flag = 0;
                    System.out.println("Player 2 ");
                    System.out.print("Insert Baris Kolom : ");
                    baris = scn.nextInt();
                    kolom = scn.nextInt();  
                    if( baris <= 0 || baris >3 || kolom <=0 || kolom > 3){
                        flag = 1;
                    }else if(Map[baris-1][kolom-1] != '_') flag = 2;
                    if(flag == 1) System.out.println("This tile is not available!");
                    else System.out.println("sudah di isi");
                    
                }while(flag != 0);
                
            }
            gantiMap(i);
            printMap();
            i++;
            cekMenang();
        }
    
        if(pemenang == 'O'){
            System.out.println("Player 1 is the Winner!");
        }
        else if(pemenang == 'X'){
            System.out.println("Player 2 is the winner!");
        }
        else{
            System.out.println("There are no winner!");
            
        }
    }

    public static char Map[][] = {
       { '_','_','_'},
       {'_','_','_'},
       {'_','_','_'}
    };

    public static char pemenang;


    public static Scanner scn = new Scanner(System.in);

    // public static void inputan(){
    //     System.err.print("Insert Baris Kolom : ");
    //     baris = scn.nextInt();
    //     kolom = scn.nextInt();
    // }

    public static void gantiMap(int angka){
        if(angka %2 != 0){
            Map[baris-1][kolom-1] = 'O';
        }
        else{
            Map[baris-1][kolom-1] = 'X';
        }
    }

    public static void cekMenang(){
        for(int i = 0 ; i < 3 ; i++){
            if(Map[i][0] != '_' && Map[i][0] == Map[i][1] && Map[i][1] == Map[i][2]){
                pemenang = Map[i][0];
                flag  = true;
            }
            if(Map[0][i] != '_' && Map[0][i] == Map[1][i] && Map[1][i] == Map[2][i]){
                pemenang = Map[0][i];
                flag  = true;
            }
        }
            if(Map[0][0] == Map[1][1] && Map[2][2] == Map[1][1] && Map[0][0] != '_'){
                pemenang = Map[0][0];
                flag = true;
            }
            if(Map[0][2] != '_' && Map[1][1] == Map[0][2] && Map[1][1] == Map[2][0]){
                pemenang = Map[0][0];
                flag = true;
            }
    }

    public static void printMap(){
        for(int i = 0 ; i < 3 ; i++){
            for(int j = 0 ; j < 3 ; j++){
                System.out.print(Map[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        playGame();
    }
}
