import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main
{
/*Okay nice. Let's get started .As a warmup activity you can write a small program in your favorite language to add two arrays..
Eg: if the first user input is 1, 2, 4 and second input is 1, 0, 2.
the output is 2, 2, 6  if array size is not equal you can show an error*/
    public static void main(String []args){
        Scanner scanner = new Scanner(System.in);
        String strArray1, strArray2;

        //Getting the inputs
        System.out.println("Enter 1st Set of COMMA SEPARATED integer values");
        strArray1 = scanner.nextLine();
        System.out.println("Enter 2nd Set of COMMA SEPARATED integer values");
        strArray2 = scanner.nextLine();

        ArrayAdder arrayAdder = new ArrayAdder();
        arrayAdder.setFirstArray(stringToArrayList(strArray1));
        arrayAdder.setSecondArray(stringToArrayList(strArray2));

        //Displaying New Values
        displayNewArray(arrayAdder.getNewArray());

    }

    public static ArrayList<Integer> stringToArrayList(String csv){
        ArrayList<Integer> convertedArrayList = new ArrayList<>();
        String[] temp = csv.split(",");

        for(int i = 0 ; i < temp.length ; i++)
        {
            convertedArrayList.add(Integer.parseInt(temp[i]));
        }

        return convertedArrayList;
    }

    public static void displayNewArray(ArrayList<Integer> newArray){
        if(newArray.size() > 0){
            System.out.println(Arrays.toString(newArray.toArray()));
        }

        else
            System.out.println("Array sizes are Different");
    }
}
