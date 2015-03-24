import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Xenomorf on 24.03.2015.
 */
public class Main {
    public static void main(String[] args){
        //Считывание файла
        File file=new File("text.txt");
        String text=new String();
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        while (scanner.hasNextLine()){
            text+=scanner.nextLine()+" ";
        }
        //Замена номера телефона
        Pattern pattern = Pattern.compile("\\+[0-9]{11}"); //Регулярное выражение для поиска нормальных телефонов
        Matcher m = pattern.matcher(text);

        String rez="";
        List<String> allMatches = new ArrayList<String>();
        while (m.find()) {
            String oldPhone=m.group();
            String newPhone="+2"+"("+oldPhone.substring(2,5)+") "+oldPhone.substring(5,8)+"-"+oldPhone.substring(8,10)+"-"+oldPhone.substring(10,12);
            text=text.replace(oldPhone,newPhone);

        }

        System.out.println(text);
    }
}
