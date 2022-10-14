package com.example.sgmowltnowtest;

import com.example.sgmowltnowtest.controller.TondeuseController;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.*;

@SpringBootApplication
public class SgMowltNowTestApplication {

    public static void main(String[] args) throws IOException {
        TondeuseController tondeuseController = new TondeuseController();
        BufferedReader br=tondeuseController.bufferedReader("input4");
        tondeuseController.setPositionMaxXY(br);
        tondeuseController.operation(br);
        System.out.println(tondeuseController.tondeuse.getResult());
    }
}
