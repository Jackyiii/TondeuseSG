package com.example.sgmowltnowtest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

import static org.springframework.test.util.AssertionErrors.assertEquals;

@SpringBootTest
class SgMowltNowTestApplicationTests {

    private Tondeuse tondeuse;

    @BeforeEach
    public void setUp() throws IOException {
        tondeuse = new Tondeuse();
        tondeuse.readAndSetPositionMaxXY();

    }
    @Test
    public void shouldReturn0IfNumberIs0(){
        assertEquals("Test Return 0","0", tondeuse.generate());
    }
    @Test
    //input1
    public void shouldReadPositionMaxXFromFile() throws IOException {
        assertEquals("Read 5 from file Input1.txt",5,tondeuse.getPositionMaxXY(Axis.X));
    }
    @Test
    //input1
    public void shouldReadPositionMaxYFromFile() throws IOException {
        assertEquals("Read 7 from file Input1.txt",7,tondeuse.getPositionMaxXY(Axis.Y));
    }

    @Test
    //input2
    public void shouldReadDirection() throws IOException{
        assertEquals("Read N from file Input2.txt",'N',tondeuse.dataTondeuse.getDirection());
    }

    @Test
    //input3
    public void shouldReadFirstResult() throws IOException{
        assertEquals("Read 1 1 3 N from file Input3.txt","1 3 N",tondeuse.dataTondeuse.getResult());
    }
    @Test
    //input4
    public void shouldReadAllResult() throws IOException{
        assertEquals("Read 1 1 3 N 4 1 E from file Input4.txt","1 3 N 4 1 E",tondeuse.dataTondeuse.getResult());
    }
}
