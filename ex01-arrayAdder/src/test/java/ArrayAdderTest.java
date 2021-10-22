import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;

public class ArrayAdderTest {
    ArrayAdder arrayAdder = new ArrayAdder();
    ArrayList<Integer> sampleArray1 = new ArrayList<>();
    {
        sampleArray1.add(1);
        sampleArray1.add(100);
        sampleArray1.add(12);
        sampleArray1.add(2500);
    }

    ArrayList<Integer> sampleArray2 = new ArrayList<>();
    {
        sampleArray2.add(34);
        sampleArray2.add(23);
        sampleArray2.add(789);
        sampleArray2.add(1212);
    }

    @Test
    public void setFirstArrayTest() throws Exception{
        arrayAdder.setFirstArray(sampleArray1);
        ArrayList<Integer> actual = arrayAdder.getFirstArray();
        Assert.assertArrayEquals(sampleArray1.toArray(), actual.toArray());
    }

    @Test
    public void setSecondArrayTest() throws Exception{
        arrayAdder.setSecondArray(sampleArray2);
        ArrayList<Integer> actual = arrayAdder.getSecondArray();
        Assert.assertArrayEquals(sampleArray2.toArray(), actual.toArray());
    }

    @Test
    public void getNewArrayTest() throws Exception{
        arrayAdder.setFirstArray(sampleArray1);
        arrayAdder.setSecondArray(sampleArray2);
        ArrayList<Integer> sample = new ArrayList<>();

        for(int i = 0 ; i < sampleArray1.size() ; i++)
        {
            sample.add(sampleArray1.get(i) + sampleArray2.get(i));
        }

        ArrayList<Integer> actual = arrayAdder.getNewArray();
        Assert.assertArrayEquals(sample.toArray(), actual.toArray());
    }
}