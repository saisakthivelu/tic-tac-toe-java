import java.util.Scanner;


public class tictactoe {
    private static char[][] board;
    private static int n;
    private static char currentplayer;

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of the board(n*m): ");
        n=sc.nextInt();
        board=new char[n][n];
        intializeboard();
        currentplayer='O';
        int count=0;
        boolean gamewon=false;
        while(count<(n*n)&&!gamewon){
            currentplayer=(currentplayer=='X')? 'O':'X';
            printboard();
            System.out.println("enter the row and column("+currentplayer+" player): ");
            int row= sc.nextInt();
            int col= sc.nextInt();
            if(valid(row,col)){
                board[row][col]=currentplayer;
                count++;
            }
            else{
                System.out.println("invalid row and column");
                currentplayer=(currentplayer=='X')? 'O':'X';
                continue;
            }
            if(check(row,col)){
                gamewon=true;
            }
        }
        printboard();
        if(gamewon){
            System.out.println(currentplayer+" Player won!!!");
        }
        else{
            System.out.println("Draw!!!");
        }
    }

    private static boolean check(int row,int col) {
        return rowcheck(row)||colcheck(col)||diagonalcheck(row,col);
    }

    private static boolean diagonalcheck(int row,int col) {
        boolean diag1=true;
        boolean diag2=true;
        for(int i=0;i<n;i++){
            if(board[i][i]!=currentplayer){
             diag1=false;
            }
        }
        for(int i=0;i<n;i++){
            if(board[i][n-1-i]!=currentplayer){
                diag2=false;
            }
        }
        return diag1||diag2;
    }

    private static boolean colcheck(int col) {
        for(int i=0;i<n;i++){
            if(board[i][col]!=currentplayer){
                return false;
            }
        }
        return true;
    }
    private static boolean rowcheck(int row) {
        for(int i=0;i<n;i++){
            if(board[row][i]!=currentplayer){
                return false;
            }
        }
        return true;
    }

    private static boolean valid(int row, int col) {
        return  row>=0 && row<n && col>=0 && col<n && board[row][col]=='-';
    }

    public static void intializeboard(){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='-';
            }
        }
    }
    public static void printboard(){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
}
