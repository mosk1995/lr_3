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
        Pattern pattern = Pattern.compile("\\+[7][\\s(]{0,6}[0-9]{3}[\\s)]{0,6}[0-9]{3}[\\s\\-]{0,3}[0-9]{2}[\\s\\-]{0,3}[0-9]{2}"); //Регулярное выражение для поиска нормальных телефонов
        Matcher m = pattern.matcher(text);

        String rez="";
        List<String> allMatches = new ArrayList<String>();
        while (m.find()) {
            String oldPhone=m.group();
            String clearOldPhone="";
            clearOldPhone=oldPhone.replaceAll("[\\s\\-()]", "");
            //System.out.println(clearOldPhone+"\n");
            String newPhone="+2"+"("+clearOldPhone.substring(2,5)+")"+clearOldPhone.substring(5,8)+"-"+clearOldPhone.substring(8,10)+"-"+clearOldPhone.substring(10,12);
            text=text.replace(oldPhone,newPhone);

        }

        System.out.println(text);
    }
}
