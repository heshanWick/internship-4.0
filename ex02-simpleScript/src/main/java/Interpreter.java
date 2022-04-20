import java.util.ArrayList;

public class Interpreter
{
    private ArrayList<String[]> passedTokenSets;
    private final SaveCommand saveCommand = new SaveCommand();
    private final ShowCommand showCommand = new ShowCommand();

    public void setPassedTokenSets(ArrayList<String[]> passedTokenSets){
        this.passedTokenSets = passedTokenSets;
    }

    public void interpret(){
        boolean isSyntaxError = false;
        String[] currentSet;

        for (String[] passedToken : this.passedTokenSets) {
            currentSet = passedToken;

            //Getting Save Token Values
            if(this.saveCommand.isSaveCommand(currentSet)){
                this.saveCommand.addToken(currentSet);
            }
            //Getting SHOW token Values
            else if(showCommand.isShowCommand(currentSet)){
                this.showCommand.addToken(currentSet);
            }

            else{
                isSyntaxError = true;
                break;
            }
        }

        try {
            displayOutput(isSyntaxError);
        } catch (ScriptException e) {
            e.printStackTrace();
        }
    }

    //Displaying output to the user
    public void displayOutput(boolean isSyntaxError) throws ScriptException {
        if(isSyntaxError){
            throw new ScriptException("syntax error");
        }
        else{
            System.out.println("SHOW Tokens");
            for(Character c : showCommand.getShowTokens()){
                if(!this.saveCommand.getSaveTokens().containsKey(c)){
                    throw new ScriptException("undeclared variable : " + c);
                }
                else if(this.saveCommand.getSaveTokens().get(c) == null)
                    throw new ScriptException("invalid value");
                else
                    System.out.println(this.saveCommand.getSaveTokens().get(c));
            }
        }
    }

    //Inner class for exceptions
    private static class ScriptException extends Exception
    {
        public ScriptException(String message) {
            super(message);
        }
    }
}
