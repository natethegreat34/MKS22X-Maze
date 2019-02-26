import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class ReadFile {
  public static void main(String args[]) throws FileNotFoundException {
int i = 0;
int z = 0;
        //instead of a try/catch, you can throw the FileNotFoundException.
        //This is generally bad behavior

        File text = new File("Maze.txt");
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
        char [][] hey = new char [i][z];
        while(tex.hasNextLine()){
        for (int a = 0; a < i; a ++){
            for (int b = 0; b < z; b ++){
                hey [a][b] = tex.nextLine().charAt(b);
            }

        }}
        System.out.println(hey);
}

}
