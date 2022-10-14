package com.example.sgmowltnowtest;

import com.example.sgmowltnowtest.util.Axis;
import com.example.sgmowltnowtest.controller.TondeuseController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.BufferedReader;
import java.io.IOException;

import static org.springframework.test.util.AssertionErrors.assertEquals;

@SpringBootTest
class SgMowltNowTestApplicationTests {

    private TondeuseController tondeuseController;

    @BeforeEach
    public void setUp() throws IOException {
        tondeuseController = new TondeuseController();
    }
    @Test
    public void shouldReturn0IfNumberIs0(){
        assertEquals("Test Return 0","0", tondeuseController.generate());
    }
    @ParameterizedTest
    @CsvSource({"input1"})
    public void shouldReturn57(String input) throws IOException{
        assert(tondeuseController.bufferedReader(input)!=null);
        System.out.println(tondeuseController.bufferedReader(input).readLine());
    }
    @Test
    public void shouldReturn57() throws IOException {
        assertEquals("Test Return 5 7","5 7", tondeuseController.bufferedReader("input1").readLine());
    }
    @Test
    public void shouldReadPositionMaxXFromFile() throws IOException {
        BufferedReader br=tondeuseController.bufferedReader("input1");
        tondeuseController.setPositionMaxXY(br);
        assertEquals("Read 5 from file Input1.txt",5, tondeuseController.getPositionMaxXY(Axis.X));
    }
    @Test
    public void shouldReadPositionMaxYFromFile() throws IOException {
        BufferedReader br=tondeuseController.bufferedReader("input1");
        tondeuseController.setPositionMaxXY(br);

        assertEquals("Read 7 from file Input1.txt",7, tondeuseController.getPositionMaxXY(Axis.Y));
    }

    @Test
    public void shouldReadDirection() throws IOException{
        BufferedReader br=tondeuseController.bufferedReader("input2");
        tondeuseController.setPositionMaxXY(br);
        tondeuseController.operation(br);
        assertEquals("Read N from file Input2.txt",'N', tondeuseController.tondeuse.getDirection());
    }

    @Test
    public void shouldReadFirstResult() throws IOException{
        BufferedReader br=tondeuseController.bufferedReader("input3");
        tondeuseController.setPositionMaxXY(br);
        tondeuseController.operation(br);
        assertEquals("Read 1 1 3 N from file Input3.txt","1 3 N", tondeuseController.tondeuse.getResult());
    }
    @Test
    public void shouldReadAllResult() throws IOException{
        BufferedReader br=tondeuseController.bufferedReader("input4");
        tondeuseController.setPositionMaxXY(br);
        tondeuseController.operation(br);
        assertEquals("Read 1 1 3 N 4 1 E from file Input4.txt","1 3 N 4 1 E", tondeuseController.tondeuse.getResult());
    }
}
