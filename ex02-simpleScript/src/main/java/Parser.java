import java.util.*;

public class Parser
{
    private final ArrayList<String[]> tokens = new ArrayList<>();

    public void setTokens(String text){
        String[] tokenSets = text.split("\\|");

        if(tokenSets.length > 0)
        {
            for (String tokenSet : tokenSets) {
                this.tokens.add(tokenize(tokenSet));
            }
        }
    }

    private String[] tokenize(String text)
    {
        return text.split("\\s");
    }

    public ArrayList<String[]> getTokens() {
        return tokens;
    }
}
