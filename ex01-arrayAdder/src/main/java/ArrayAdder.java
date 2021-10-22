import java.util.ArrayList;

public class ArrayAdder
{

    private ArrayList<Integer> firstArray = new ArrayList<>();
    private ArrayList<Integer> secondArray = new ArrayList<>();

    //Constructors
    /////////////////////////////////////////////////////////////
    public ArrayAdder(ArrayList<Integer> firstArray, ArrayList<Integer> secondArray){
        this.firstArray = firstArray;
        this.secondArray = secondArray;
    }

    public ArrayAdder(){}

    //Getters
    /////////////////////////////////////////////////////////////
    public ArrayList<Integer> getFirstArray() {
        return firstArray;
    }

    public ArrayList<Integer> getSecondArray() {
        return secondArray;
    }

    //Setters
    /////////////////////////////////////////////////////////////
    public void setFirstArray(ArrayList<Integer> firstArray) {
        this.firstArray = firstArray;
    }

    public void setSecondArray(ArrayList<Integer> secondArray) {
        this.secondArray = secondArray;
    }

    //Getting the new Array
    /////////////////////////////////////////////////////////////
    public ArrayList<Integer> getNewArray()
    {
        ArrayList<Integer> newArray = new ArrayList<>();
        if(firstArray.size() == secondArray.size()){
            for(int i = 0; i < firstArray.size() ; i++)
            {
                newArray.add(firstArray.get(i) + secondArray.get(i));
            }
        }

        return newArray;
    }
}
