package geometry.sweepline;

import org.junit.Assert;
import org.junit.Test;
import spi.MessageService;
import spi.SPIManager;

import javax.swing.*;

import static org.junit.Assert.*;

public class PointsFormLineTest {

    @Test
    public void checkStraightLine() {
        MessageService messageService = SPIManager.getInstance().getMs4();
        Assert.assertNotNull(messageService);
        System.out.println(messageService.getMessage());
    }
}