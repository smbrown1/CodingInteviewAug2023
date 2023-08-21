package test.temp;

import main.temp.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest
{
    @Test
    public void testAddOne()
    {
        int result = Main.addOne(2);
        assertEquals(3, result);
    }
}