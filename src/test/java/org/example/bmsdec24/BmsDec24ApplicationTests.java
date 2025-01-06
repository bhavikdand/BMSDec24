package org.example.bmsdec24;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BmsDec24ApplicationTests {


    @Test
    public void test_OnePlusOne() throws Exception {
        //Arrange
        int a = 1;
        int b = 1;

        //Act
        int ans = a + b;

        //Assert
        //Option #1
//        if(ans != 3){
//            throw new Exception("Ans should be two");
//        }
        //Option #2
//        assert ans == 3;

        //Option #3
        assertEquals(3, ans, "Ans should always be 2");
        assertNotNull(new Object(), "sdfsdfsdf");
        assertNull(null, "sdfsdfsdf");

    }

}
