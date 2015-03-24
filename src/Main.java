import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Xenomorf on 24.03.2015.
 */
public class Main {
    public static void main(String[] args){
        File file=new File("text.txt");
        String text=new String();
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (scanner.hasNextLine()){
            text+=scanner.nextLine()+"\n";
        }
        System.out.println(text);
    }
}
