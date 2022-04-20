import java.util.HashMap;

public class SaveCommand extends Command{

    private HashMap<Character, Integer> saveTokens = new HashMap<>();

    public boolean isSaveCommand(String[] currentSet){
        final String SAVE_TOKEN = "SAVE";
        final String VALUE_PATTERN = "^[0-9]+$";

        return currentSet.length == 3 && isValidVariable(currentSet[getVariableNameIndex()]) && currentSet[getTokenIndex()].equals(SAVE_TOKEN) && currentSet[getValueIndex()].matches(VALUE_PATTERN);
    }

    public HashMap<Character, Integer> getSaveTokens() {
        return saveTokens;
    }

    @Override
    public void addToken(String[] currentSet) {
        Character variableName = currentSet[getVariableNameIndex()].charAt(0);
        int value = Integer.parseInt(currentSet[getValueIndex()]);
        this.saveTokens.put(variableName, value);
    }
}
