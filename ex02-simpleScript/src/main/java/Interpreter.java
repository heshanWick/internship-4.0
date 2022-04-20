import java.util.ArrayList;

public class Interpreter
{
    private ArrayList<String[]> passedTokenSets;
    private final SaveCommand saveCommand = new SaveCommand();
    private final ShowCommand showCommand = new ShowCommand();

    public void setPassedTokenSets(ArrayList<String[]> passedTokenSets){
        this.passedTokenSets = passedTokenSets;
    }

    public void interpret(boolean isFile){
        boolean isSyntaxError = false;
        String[] currentSet;

        for (String[] passedToken : this.passedTokenSets) {
            currentSet = passedToken;

            if(!isFile) this.showCommand.getShowTokens().clear();

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

        displayOutput(isSyntaxError);

        this.passedTokenSets.clear();
    }

    //.simc out put Displaying output to the user
    public void displayOutput(boolean isSyntaxError) {
        if(isSyntaxError){
            System.out.println("Syntax Error");
        }
        else{
            for(Character c : showCommand.getShowTokens()){
                if(!this.saveCommand.getSaveTokens().containsKey(c)){
                    System.out.println("Undeclared Variable : " + c);
                }
                else if(this.saveCommand.getSaveTokens().get(c) == null)
                    System.out.println("invalid value");
                else
                    System.out.println(this.saveCommand.getSaveTokens().get(c));
            }
        }
    }
}
