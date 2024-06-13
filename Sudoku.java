import java.util.Scanner;

public class Sudoku {
    public static boolean isSafe(int sudoku[][],int row,int col,int digit){
        // row
        for(int i=0;i<=8;i++){
            if(sudoku[i][col]==digit){return false;}

        }

        //column
        for(int j=0;j<=8;j++){
            if(sudoku[row][j]==digit){return false;}
        }

        //grid
        int sr=(row/3)*3;
        int sc=(col/3)*3;
        for(int i=sr;i<sr+3;i++){
            for(int j=sc;j<sc+3;j++){
                if(sudoku[i][j]==digit){
                    return false;
                }
            }
        }

        return true;
    }

    public static void printsudoku(int sudoku[][]){
        for(int i=0;i<=8;i++){
            for(int j=0;j<=8;j++){
                System.out.print(sudoku[i][j]+ " ");
            }
            System.out.println();
        }
    }


    public static boolean sudokusolver(int sudoku[][],int row,int col){
        if(row==9){
            return true;
        }
        int newrow=row; int newcol=col+1;
        if(col+1==9){
            newrow=row+1;
            newcol=0;
        }

       
        if(sudoku[row][col]!=0){
            return sudokusolver(sudoku,newrow,newcol);
        }

       for(int digit=1;digit<=9;digit++){
          if(isSafe(sudoku,row,col,digit)){
            sudoku[row][col]=digit;
            if(sudokusolver(sudoku,newrow,newcol)){
                return true;
            }
            sudoku[row][col]=0;

          }
       } 

       return false;
    }

    public static void main(String args[]){
        int sudoku[][]=new int[9][9];
        Scanner sc=new Scanner(System.in);
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                sudoku[i][j]=sc.nextInt();
                sc.nextLine();
            }
        }
                        if(sudokusolver(sudoku,0,0)){
                            System.out.println("solution exist");
                            printsudoku(sudoku);
                        }
                        else{System.out.print("solution does not exist");}


    }


    
}
