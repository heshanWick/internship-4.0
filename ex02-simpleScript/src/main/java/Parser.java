import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Parser
{
    private final ArrayList<String[]> tokens = new ArrayList<>();
    private boolean readSimcFile;
    private String simcFileName;

    //Setting up token sets for the interpreter.
    ////////////////////////////////////////////////
    public void setTokens(String text){
        this.tokens.clear();
        readSimcFile = false;
        String[] tokenSets = text.split("\\|");

        if(tokenSets.length > 0)
        {
            for (String tokenSet : tokenSets) {
                this.tokens.add(tokenize(tokenSet));
            }
        }

        //Checking whether the command is to interpret a .simc file
        if(this.tokens.size() == 1 && this.tokens.get(0)[0].equals("simc") && this.tokens.get(0).length == 2){
            readSimcFile = true;
            simcFileName = this.tokens.get(0)[1];
        }
    }

    private String[] tokenize(String text)
    {
        return text.split("\\s");
    }

    public boolean isReadSimcFile() {
        return readSimcFile;
    }

    public String getSimcFileName() {
        return simcFileName;
    }

    public ArrayList<String[]> getTokens() {
        return tokens;
    }
}
