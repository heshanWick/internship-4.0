import java.util.ArrayList;
import java.util.HashMap;

public class Interpreter
{
    private final ArrayList<String[]> passedTokenSets;
    private final HashMap<Character, Integer> saveTokens = new HashMap<>();
    private final ArrayList<Character> showTokens = new ArrayList<>();

    public Interpreter(ArrayList<String[]> passedTokenSets)
    {
        this.passedTokenSets = passedTokenSets;
    }

    public void interpret(){
        final String SAVE_TOKEN = "SAVE", SHOW_TOKEN = "SHOW";
        final String VARIABLE_PATTERN = "^[A-Z]$";
        final String VALUE_PATTERN = "^[0-9]+$";
        char variableName;
        int value, currentSetLength, tokenIndex = 0, variableNameIndex = 1, valueIndex = 2;
        boolean isValidSet, isValidVariableName, isSyntaxError = false;
        String[] currentSet;

        for (String[] passedToken : passedTokenSets) {
            currentSet = passedToken;
            currentSetLength = currentSet.length;
            isValidSet = currentSetLength == 2 || currentSetLength == 3;
            isValidVariableName = currentSet[variableNameIndex].matches(VARIABLE_PATTERN);

            //Is a Valid set with a valid variable name
            if(isValidSet && isValidVariableName){
                variableName = currentSet[variableNameIndex].charAt(0);
                //Getting Save Token Values
                if(currentSetLength == 3 && currentSet[tokenIndex].equals(SAVE_TOKEN) && currentSet[valueIndex].matches(VALUE_PATTERN)){
                    value = Integer.parseInt(currentSet[valueIndex]);
                    this.saveTokens.put(variableName, value);
                }
                //Getting SHOW token Values
                else if(currentSetLength == 2 && currentSet[tokenIndex].equals(SHOW_TOKEN)){
                    this.showTokens.add(variableName);
                }

                else{
                    isSyntaxError = true;
                    break;
                }
            }
        }

        try {
            displayOutput(isSyntaxError);
        } catch (ScriptException e) {
            e.printStackTrace();
        }
    }

    public void displayOutput(boolean isSyntaxError) throws ScriptException {
        if(isSyntaxError){
            throw new ScriptException("syntax error");
        }
        else{
            System.out.println("SHOW Tokens");
            for(Character c : this.showTokens){
                if(!this.saveTokens.containsKey(c)){
                    throw new ScriptException("undeclared variable : " + c);
                }
                else if(this.saveTokens.get(c) == null)
                    throw new ScriptException("invalid value");
                else
                    System.out.println(this.saveTokens.get(c));
            }
        }
    }
}
