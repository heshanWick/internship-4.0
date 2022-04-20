/**
 * Abstract Class for Different commands to Inherit from.
 * */
public abstract class Command {

    //Abstract function for adding SAVE or SHOW tokens
    ////////////////////////////////////////////////////
    public abstract void addToken(String[] currentSet);

    //Function for checking whether a variable is a valid one.
    /////////////////////////////////////////////////////////////
    public boolean isValidVariable(String variable){
        String VARIABLE_PATTERN = "^[A-Z]$";
        return variable.matches(VARIABLE_PATTERN);
    }

    //Getting indexes of string sets in SHOW and SAVE commands
    ////////////////////////////////////////////////////////////////
    public int getTokenIndex() { return 0; }

    public int getVariableNameIndex() {
        return 1;
    }

    public int getValueIndex() {
        return 2;
    }
}
