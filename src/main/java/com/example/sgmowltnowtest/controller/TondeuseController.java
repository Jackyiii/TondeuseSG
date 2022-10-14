package com.example.sgmowltnowtest.controller;

import com.example.sgmowltnowtest.util.Axis;
import com.example.sgmowltnowtest.dao.Tondeuse;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;

public class TondeuseController {
    public Tondeuse tondeuse =new Tondeuse();
    public String generate() {
        return "0";
    }
    public BufferedReader bufferedReader(String fileName) throws IOException {
        File file = new File("src/main/resources/input/"+fileName+".txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(Files.newInputStream(file.toPath())));
        return br;
    }
    public void setPositionMaxXY(BufferedReader br) throws IOException {
        String line = null;
        if ((line = br.readLine()) != null){
            String[] position = line.split(" ");
            tondeuse.setMaxX(Integer.parseInt(position[0]));
            tondeuse.setMaxY(Integer.parseInt(position[1]));
        }
    }
    public Integer getPositionMaxXY(Axis getAxis){
        return getAxis.equals(Axis.X)? tondeuse.getMaxX(): tondeuse.getMaxY();
    }
    public String operation(BufferedReader br) throws IOException {
        String line;
        String res = "";
        while((line = br.readLine()) != null) {
            String[] position = line.split(" ");
            int x = Integer.parseInt(position[0]);
            int y = Integer.parseInt(position[1]);
            tondeuse.setDirection(position[2].charAt(0));
            line = br.readLine();
            if(line!=null){
                for (int i = 0; i < line.length(); i++) {
                    if (line.charAt(i) != 'A') {
                        if (tondeuse.getDirection() == 'E') {
                            tondeuse.setDirection(tondeuse.getEast().get(line.charAt(i)));
                        } else if (tondeuse.getDirection() == 'W') {
                            tondeuse.setDirection(tondeuse.getWest().get(line.charAt(i)));
                        } else if (tondeuse.getDirection() == 'N') {
                            tondeuse.setDirection(tondeuse.getNorth().get(line.charAt(i)));
                        } else {
                            tondeuse.setDirection(tondeuse.getSouth().get(line.charAt(i)));
                        }
                    } else {
                        if (tondeuse.getDirection() == 'W' && x > 0) {
                            x--;
                        } else if (tondeuse.getDirection() == 'E' && x < tondeuse.getMaxX()) {
                            x++;
                        } else if (tondeuse.getDirection() == 'N' && y < tondeuse.getMaxY()) {
                            y++;
                        } else if (tondeuse.getDirection() == 'S' && y > 0) {
                            y--;
                        }
                    }
                }
                res += String.format("%d %d %c ", x, y, tondeuse.getDirection());
            }
        }
        tondeuse.setResult(res.trim());
        return res;
    }
}
