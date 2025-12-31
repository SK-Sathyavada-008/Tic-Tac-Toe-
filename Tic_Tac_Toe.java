package Projects;
import java.util.Scanner;
import java.util.InputMismatchException; 

public class Tic_Tac_Toe {

    static String[] board; 
    
    public static void grid() {
        System.out.println(" " + board[0] + " | " + board[1] + " | " + board[2] + " ");
        System.out.println("-----------");
        System.out.println(" " + board[3] + " | " + board[4] + " | " + board[5] + " ");
        System.out.println("-----------");
        System.out.println(" " + board[6] + " | " + board[7] + " | " + board[8] + " ");
    }
    
    public static boolean winCheck(String xo) {     
        if(board[0].equals(board[1]) && board[0].equals(board[2]) || 
                board[3].equals(board[4]) && board[3].equals(board[5]) ||
                board[6].equals(board[7]) && board[6].equals(board[8]) ||
                board[0].equals(board[3]) && board[0].equals(board[6]) ||
                board[1].equals(board[4]) && board[1].equals(board[7]) ||
                board[2].equals(board[5]) && board[2].equals(board[8]) ||
                board[0].equals(board[4]) && board[0].equals(board[8]) ||
                board[2].equals(board[4]) && board[2].equals(board[6]) 
                )
            return true;
        else 
            return false;
    }
     
    public static void main(String[] args) {
        board = new String[9]; 
        boolean win = false;

        Scanner sc = new Scanner(System.in);
        System.out.println("---------------------");
        System.out.println("⚔️ TIC - TAC - TOE ⚔️");
        System.out.println("---------------------\n\n");
        
        for(int i=0; i<9; i++) {
            int num = i+1;
            String str = String.valueOf(num);
            board[i] = str;
        }
        grid();
        
        for(int i=0; i<9; i++) {
            try {
                // X Logic
                if(i%2 == 0) {
                    System.out.println();
                    System.out.print("Enter number to place X : ");
                    int nx = sc.nextInt();
                    
                    if(nx < 1 || nx > 9) {
                        System.out.println("Invalid slot! Please enter 1-9.");
                        i--; continue;
                    }

                    if(!board[nx - 1].equals("X") && !board[nx - 1].equals("O")) {
                        board[nx - 1] = "X";
                    } else {
                        System.out.println("Place already occupied");
                        i--;
                        continue;
                    }
                    grid();
                    win = winCheck("X");
                    if(win) {
                        System.out.println("\nX Wins");
                        break;
                    }
                }
                // O Logic
                else {
                    System.out.println();
                    System.out.print("Enter number to place O : ");
                    int no = sc.nextInt();
                    
                    if(no < 1 || no > 9) {
                        System.out.println("Invalid slot! Please enter 1-9.");
                        i--; continue;
                    }

                    if(!board[no - 1].equals("X") && !board[no - 1].equals("O")) {
                        board[no - 1] = "O";
                    } else {
                        System.out.println("Place already occupied");
                        i--;
                        continue;
                    }
                    grid();
                    win = winCheck("O");
                    if(win) {
                        System.out.println("\nO Wins");
                        break;
                    }
                }
            }
            catch(InputMismatchException e) {
                System.out.println("Error: Please enter numbers only (1-9)!");
                sc.next();
                i--;      
            }
            catch(ArrayIndexOutOfBoundsException e) {
                System.out.println("Error: That position doesn't exist!");
                i--; 
            }
        }

        if(!win) {
            System.out.println("\nIt's a Draw!");
        }
        
        sc.close();
    }
}