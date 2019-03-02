import java.util.*;
import java.io.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Maze{

    private char[][]maze;
    private boolean animate;//false by default
    public static void main(String[] args) {
    try{
      Maze m = new Maze(args[0]);
      System.out.println(m.toString());
    }catch(FileNotFoundException e){
      System.out.println("File Not Found");
    }


  }

    /*Constructor loads a maze text file, and sets animate to false by default.

      1. The file contains a rectangular ascii maze, made with the following 4 characters:
      '#' - Walls - locations that cannot be moved onto
      ' ' - Empty Space - locations that can be moved onto
      'E' - the location of the goal (exactly 1 per file)
      'S' - the location of the start(exactly 1 per file)

      2. The maze has a border of '#' around the edges. So you don't have to check for out of bounds!

      3. When the file is not found OR the file is invalid (not exactly 1 E and 1 S) then:
         throw a FileNotFoundException or IllegalStateException
    */
    public Maze(String filename) throws FileNotFoundException{
        // System.out.println("po");
        int i = 0;
        int z = 0;
                //instead of a try/catch, you can throw the FileNotFoundException.
                //This is generally bad behavior

                File text = new File(filename);
                // can be a path like: "/full/path/to/file.txt" or "../data/file.txt"

                //inf stands for the input file
                Scanner x = new Scanner(text);
                Scanner y = new Scanner(text);
                Scanner tex = new Scanner(text);

                while(x.hasNext()){
                    i ++;
                }
                while(y.hasNextLine()){
                    z ++;
                }
                while(tex.hasNextLine()){
                for (int a = 0; a < i; a ++){
                    for (int b = 0; b < z; b ++){
                        maze [a][b] = tex.nextLine().charAt(b);
                    }

                }}
                // System.out.println(hey);
        }
        //COMPLETE CONSTRUCTOR

    private void wait(int millis){
         try {
             Thread.sleep(millis);
         }
         catch (InterruptedException e) {
         }
     }
//          /
//         /
//        /
//  \    /
//   \  /
//    v
    public void setAnimate(boolean b){
        animate = b;
    }
    //          /
    //         /
    //        /
    //  \    /
    //   \  /
    //    v
    public void clearTerminal(){
        //erase terminal, go to top left of screen.
        System.out.println("\033[2J\033[1;1H");
    }


    /*Wrapper Solve Function returns the helper function
      Note the helper function has the same name, but different parameters.
      Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.
    */
    //find the location of the S.

    //erase the S

    //and start solving at the location of the s.
    //return solve(???,???);

public String toString(){
    String display = "";
    for (int x = 0; x < maze.length;x ++){
        for (int y = 0; y < maze[0].length;y  ++){
            display = display + maze [x][y];
    }
    display = display + "\n";
}
return display;
}
    public int solve(){
        System.out.println("ho");
        int locx = 0;
        int locy = 0;
        boolean stop = false;
        while(!stop){
        for (int x = 0; x < maze.length; x ++){
            for (int y = 0; y < maze[0].length; y ++){
                if (maze [x] [y] == 'S'){
                locx = x;
                locy = y;
                stop = true;
            }
        }
    }
    }
    return solve (locx, locy, 0);
}

    /*
      Recursive Solve function:

      A solved maze has a path marked with '@' from S to E.

      Returns the number of @ symbols from S to E when the maze is solved,
      Returns -1 when the maze has no solution.

      Postcondition:
        The S is replaced with '@' but the 'E' is not.
        All visited spots that were not part of the solution are changed to '.'
        All visited spots that are part of the solution are changed to '@'
    */
    public boolean addKing (int r, int c){
        if (maze [r] [c] == '.' || maze [r] [c] == '#' || maze [r] [c] == '@'){
            return false;
        }
        return true;
    }

    private int solve(int row, int col, int num){ //you can add more parameters since this is private
        //automatic animation! You are welcome. Thank you.
        if(animate){
            clearTerminal();
            System.out.println(this);
            wait(20);
        }
        
        if (addKing(row, col)){
            if (maze [row][col] == 'E'){
                return num;
            }

        else {
            maze [row] [col] = '@';
            int left =  solve(row, col - 1, num + 1);
            if (left != -1){
                return left;
            }
            int right = solve(row, col + 1, num + 1);
            if (right != -1){
                return right;
            }
            int up =    solve(row - 1, col, num + 1);
            if (up != -1){
                return up;
            }
            int down =  solve(row + 1, col, num + 1);
            if (down != -1){
                return down;
            }
        }
    }

        maze [row] [col] = '.';
        return -1;
        //COMPLETE SOLVE

}
}
