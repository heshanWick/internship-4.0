import org.junit.Assert;
import org.junit.Test;

public class SaveCommandTest {

    SaveCommand saveCommand = new SaveCommand();

    @Test
    public void isSaveCommandTest() throws Exception{
        //Valid
        String[] sample1 = {"SAVE", "A", "10"};
        String[] sample2 = {"SAVE", "G", "100"};
        //Invalid
        String[] sample3 = {"SAVE", "G", "100", "dsgfd"};
        String[] sample4 = {"SHOW", "G", "100"};

        Assert.assertTrue(saveCommand.isSaveCommand(sample1));
        Assert.assertTrue(saveCommand.isSaveCommand(sample2));
        Assert.assertFalse(saveCommand.isSaveCommand(sample3));
        Assert.assertFalse(saveCommand.isSaveCommand(sample4));
    }
}