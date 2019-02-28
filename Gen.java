import java.util.*;
import java.io.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Gen{
    public static void main(String[]args){
      String filename = "maze.txt";
      try{
        Maze f;
        f = new Maze(filename);//true animates the maze.

        f.setAnimate(true);
        f.solve();
        System.out.println(f);
      }catch(FileNotFoundException e){
        System.out.println("Invalid filename: "+filename);
      }
    }
}
