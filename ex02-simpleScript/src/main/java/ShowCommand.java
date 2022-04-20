import java.util.ArrayList;

public class ShowCommand extends Command{

    private final ArrayList<Character> showTokens = new ArrayList<>();

    public boolean isShowCommand(String[] currentSet){
        final String SHOW_TOKEN = "SHOW";
        return currentSet.length == 2 && isValidVariable(currentSet[getVariableNameIndex()]) && currentSet[getTokenIndex()].equals(SHOW_TOKEN);
    }

    public ArrayList<Character> getShowTokens() {
        return showTokens;
    }

    @Override
    public void addToken(String[] currentSet) {
        Character variableName = currentSet[getVariableNameIndex()].charAt(0);
        this.showTokens.add(variableName);
    }
}
