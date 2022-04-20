import java.util.ArrayList;

/**
 * Class handling SHOW Commands taken as an input.
 * */
public class ShowCommand extends Command{

    private final ArrayList<Character> showTokens = new ArrayList<>();

    //Function for checking whether a command is a SHOW command
    public boolean isShowCommand(String[] currentSet){
        final String SHOW_TOKEN = "SHOW";
        return currentSet.length == 2 && isValidVariable(currentSet[getVariableNameIndex()]) && currentSet[getTokenIndex()].equals(SHOW_TOKEN);
    }

    //Function for adding SHOW Commands to an Array List
    //////////////////////////////////////////////////////
    @Override
    public void addToken(String[] currentSet) {
        Character variableName = currentSet[getVariableNameIndex()].charAt(0);
        this.showTokens.add(variableName);
    }

    public ArrayList<Character> getShowTokens() {
        return showTokens;
    }
}
