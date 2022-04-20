import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args){
        System.out.println("//////////////////////////////////////////");
        System.out.println("SIMC");
        System.out.println("-----");

        String data =  readFile("ex02-simpleScript/src/firstScript.simc");
        Parser parser = new Parser();
        Interpreter interpreter = new Interpreter();

        parser.setTokens(data);
        interpreter.setPassedTokenSets(parser.getTokens());
        interpreter.interpret();

//        boolean replActive = true;
//        Scanner scanner = new Scanner(System.in);
//        String userInput;
//
//        //REPL
//        while(replActive){
//            userInput = scanner.nextLine();
//            if(userInput.equals("exit")) replActive = false;
//            else{
//                System.out.println(userInput);
//            }
//        }
    }

    //Read from a file
    public static String readFile(String filePath)
    {
        StringBuilder data = new StringBuilder();

        try {
            File file = new File(filePath);
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
