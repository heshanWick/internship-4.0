import java.util.HashMap;

/**
 * Class handling SAVE Commands taken as an input.
 * */
public class SaveCommand extends Command{

    private final HashMap<Character, Integer> saveTokens = new HashMap<>();

    //Function for checking whether a command is a SAVE command
    //////////////////////////////////////////////////////////////////
    public boolean isSaveCommand(String[] currentSet){
        final String SAVE_TOKEN = "SAVE";
        final String VALUE_PATTERN = "^[0-9]+$";

        return currentSet.length == 3 && isValidVariable(currentSet[getVariableNameIndex()]) && currentSet[getTokenIndex()].equals(SAVE_TOKEN) && currentSet[getValueIndex()].matches(VALUE_PATTERN);
    }

    //Function for adding SAVE Commands to a Hashmap
    //////////////////////////////////////////////////////
    @Override
    public void addToken(String[] currentSet) {
        Character variableName = currentSet[getVariableNameIndex()].charAt(0);
        int value = Integer.parseInt(currentSet[getValueIndex()]);
        this.saveTokens.put(variableName, value);
    }

    public HashMap<Character, Integer> getSaveTokens() {
        return saveTokens;
    }
}
