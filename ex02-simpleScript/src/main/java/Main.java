import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Main Class.
 * */
public class Main
{
    public static void main(String[] args){
        //Initialising the Scanner, Parser and Interpreter
        Parser parser = new Parser();
        Interpreter interpreter = new Interpreter();
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n//////////////////////////////////////////");
        System.out.println("SIMPLE SCRIPT (SIMC)");
        System.out.println("//////////////////////////////////////////\n");

        //Variables needed for the REPL
        boolean isReplActive = true;
        boolean isFile;
        String userInput;

        //Read Evaluate Print Loop
        while(isReplActive){
            isFile = false;
            System.out.print(">> ");
            userInput = scanner.nextLine();

            //Typing 'exit' to exit repl
            if(userInput.equals("exit")) isReplActive = false;
            else{
                parser.setTokens(userInput);

                //Interpreting .simc file
                if(parser.isReadSimcFile()) {
                    isFile = true;
                    parser.setTokens(readFile(parser.getSimcFileName()));
                };

                interpreter.setPassedTokenSets(parser.getTokens());
                interpreter.interpret(isFile);
            }
        }
    }

    //Helper function for reading from a .simc file
    //////////////////////////////////////////////////
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
            System.out.println("<- File is not found in this path !");
        }
        return data.toString();
    }
}
