import java.util.*;
import java.io.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Maze{

    private char[][]maze;
    private boolean animate;//false by default
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

        File text = new File(filename);
        // can be a path like: "/full/path/to/file.txt" or "../data/file.txt"

        //inf stands for the input file
        Scanner inf = new Scanner(text);
        ArrayList <String> potato = new ArrayList <String> ();
        while(inf.hasNextLine()){
            String line = inf.nextLine();
            potato.add(line);//hopefully you can do other things with the line
        }
        int y = potato.size();
        int x = potato.get(0).length();
        maze = new char [y][x];
        for (int q = 0; q < y ; q ++){
            for (int w= 0; w < x ; w ++){
                maze [q][w] = potato.get(q).charAt(w);
        }
    }
if (!valid ()){
    throw new IllegalStateException("");
}
}
//when there is not exactly 1 E and 1 S it is not valid
private boolean valid (){
    boolean founds = false;
    boolean founde = false;
    for (int x = 0; x < maze.length;x ++){
        for (int y = 0; y < maze[0].length;y  ++){
            if (maze [x][y] == 'S'){
                if (founds){
                    return false;
                }
                founds = true;
            }
            if (maze [x][y] == 'E'){
                if (founde){
                    return false;
                }
                founde = true;
            }
        }
    }
    return founds && founde;
}
        //COMPLETE CONSTRUCTOR

    private void wait(int millis){
         try {
             Thread.sleep(millis);
         }
         catch (InterruptedException e) {
         }
     }

    public void setAnimate(boolean b){
        animate = b;
    }

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
    //finds the x cor and y cor of the S
                locx = x;
                locy = y;
                // stops the process of finding the S
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
    // moves like a king besides diagol movements
    public boolean addKing (int r, int c){
        // checks to see if you the space one is at is a valid  space
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
            // if the spot is a valid spot and you have reached the end, you are done
            if (maze [row][col] == 'E'){
                // returns the nnumber of moves it takes to get directly from S to e (shortest possible distance (number of moves)
                return num;
            }

            maze [row] [col] = '@';
            // mark that you have been here then try all directions
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
        // All visited spots that are part of the solution are changed to '@'
        // All visited spots that were not part of the solution are changed to '.'
        maze [row] [col] = '.';
    }

        return -1;
        //COMPLETE SOLVE

}
}
