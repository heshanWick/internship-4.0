public abstract class Command {

    public abstract void addToken(String[] currentSet);

    public boolean isValidVariable(String variable){
        String VARIABLE_PATTERN = "^[A-Z]$";
        return variable.matches(VARIABLE_PATTERN);
    }

    public int getTokenIndex() { return 0; }

    public int getVariableNameIndex() {
        return 1;
    }

    public int getValueIndex() {
        return 2;
    }
}
