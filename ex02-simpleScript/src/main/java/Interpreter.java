import java.util.ArrayList;

/**
 * Class representing an Interpreter.
 * Also displays Output to the user
 * */
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

            //Clearing Previous Show commands if not reading from a .simc file
            if(!isFile) this.showCommand.getShowTokens().clear();

            //Adding Save Token Values
            if(this.saveCommand.isSaveCommand(currentSet)){
                this.saveCommand.addToken(currentSet);
            }
            //Adding SHOW token Values
            else if(showCommand.isShowCommand(currentSet)){
                this.showCommand.addToken(currentSet);
            }

            else{
                isSyntaxError = true;
                break;
            }
        }

        //Displaying output to user
        displayOutput(isSyntaxError);

        //Clearing current Data for next iteration
        this.passedTokenSets.clear();
        this.showCommand.getShowTokens().clear();
    }

    // Function for displaying Error or Command outputs to user
    //////////////////////////////////////////////////////////////
    public void displayOutput(boolean isSyntaxError) {
        if(isSyntaxError){
            System.out.println("<- Syntax Error");
        }
        else{
            for(Character c : showCommand.getShowTokens()){
                if(!this.saveCommand.getSaveTokens().containsKey(c)){
                    System.out.println("<- Undeclared Variable : " + c);
                }
                else if(this.saveCommand.getSaveTokens().get(c) == null)
                    System.out.println("<- Invalid Value");
                else
                    System.out.println("<- " + this.saveCommand.getSaveTokens().get(c));
            }
        }
    }
}
