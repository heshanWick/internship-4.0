import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args){
        Parser parser = new Parser();
        Interpreter interpreter = new Interpreter();

        System.out.println("//////////////////////////////////////////");
        System.out.println("SIMC");
        System.out.println("-----");

//        String data =  readFile("ex02-simpleScript/src/firstScript.simc");
//        parser.setTokens(data);
//        interpreter.setPassedTokenSets(parser.getTokens());
//        interpreter.interpret();

        boolean isReplActive = true;
        boolean isFile = false;
        Scanner scanner = new Scanner(System.in);
        String userInput;

        //REPL
        while(isReplActive){
            isFile = false;
            userInput = scanner.nextLine();
            //Typing exit to exit repl
            if(userInput.equals("exit")) isReplActive = false;
            else{
                parser.setTokens(userInput);

                if(parser.getTokens().get(0)[0].equals("simc")) {
                    isFile = true;
                    parser.setTokens(readFile(parser.getTokens().get(0)[1]));
                };

                interpreter.setPassedTokenSets(parser.getTokens());
                interpreter.interpret(isFile);
            }
        }
    }

    //Read from a file
    private static String readFile(String fileName)
    {
        String formattedFilePath = "ex02-simpleScript/src/" + fileName;
        StringBuilder data = new StringBuilder();

        try {
            File file = new File(formattedFilePath);
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
