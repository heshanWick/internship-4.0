import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args){
        System.out.println("//////////////////////////////////////////");
        String data =  readFile("ex02-simpleScript/src/firstScript.simc");
        Parser parser = new Parser(data);  
        Interpreter interpreter = new Interpreter(parser.getTokens());
        interpreter.interpret();
    }

    //Read from a file
    public static String readFile(String filePath)
    {
        StringBuilder data = new StringBuilder();

        try {
            File file = new File(filePath);
            System.out.println(file.getAbsolutePath());
            Scanner scanner = new Scanner(file);
            String temp;

            while (scanner.hasNextLine())
            {
                temp = scanner.nextLine();
                if(!temp.isEmpty())
                {
                    data.append(temp);
                    data.append("|");
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File is not found in this path !");
        }
        return data.toString();
    }
}
