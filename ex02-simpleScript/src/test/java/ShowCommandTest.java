import org.junit.Assert;
import org.junit.Test;

public class ShowCommandTest {

    ShowCommand showCommand = new ShowCommand();

    @Test
    public void isShowCommandTest() {
        //Valid
        String[] sample1 = {"SHOW", "A"};
        String[] sample2 = {"SHOW", "C"};
        //Invalid
        String[] sample3 = {"SHOW", "A", "100"};
        String[] sample4 = {"SHOWWW", "G"};

        Assert.assertTrue(showCommand.isShowCommand(sample1));
        Assert.assertTrue(showCommand.isShowCommand(sample2));
        Assert.assertFalse(showCommand.isShowCommand(sample3));
        Assert.assertFalse(showCommand.isShowCommand(sample4));
    }
}