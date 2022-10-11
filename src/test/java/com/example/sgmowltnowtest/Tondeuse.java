package com.example.sgmowltnowtest;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;


class Tondeuse {
    DataTondeuse dataTondeuse=new DataTondeuse();
    //Just Test
    String generate() {
        return "0";
    }

    //Get Mesh Max X and Y
    void readAndSetPositionMaxXY() throws IOException {
        String res = "";
        File file = new File("src/main/java/test/input4.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(Files.newInputStream(file.toPath())));
        String line = null;
        if ((line = br.readLine()) != null){
            String[] position = line.split(" ");
            dataTondeuse.setMaxX(Integer.parseInt(position[0]));
            dataTondeuse.setMaxY(Integer.parseInt(position[1]));
        }
        res=operation(br);
        System.out.println(res);
    }
    Integer getPositionMaxXY(Axis getAxis){
        return getAxis.equals(Axis.X)? dataTondeuse.getMaxX(): dataTondeuse.getMaxY();
    }

    public String operation(BufferedReader br) throws IOException {
        String line;
        String res = "";
        while((line = br.readLine()) != null) {
            String[] position = line.split(" ");
            int x = Integer.parseInt(position[0]);
            int y = Integer.parseInt(position[1]);
            dataTondeuse.setDirection(position[2].charAt(0));
            line = br.readLine();
            if(line!=null){
                for (int i = 0; i < line.length(); i++) {
                    if (line.charAt(i) != 'A') {
                        if (dataTondeuse.getDirection() == 'E') {
                            dataTondeuse.setDirection(dataTondeuse.getEast().get(line.charAt(i)));
                        } else if (dataTondeuse.getDirection() == 'W') {
                            dataTondeuse.setDirection(dataTondeuse.getWest().get(line.charAt(i)));
                        } else if (dataTondeuse.getDirection() == 'N') {
                            dataTondeuse.setDirection(dataTondeuse.getNorth().get(line.charAt(i)));
                        } else {
                            dataTondeuse.setDirection(dataTondeuse.getSouth().get(line.charAt(i)));
                        }
                    } else {
                        if (dataTondeuse.getDirection() == 'W' && x > 0) {
                            x--;
                        } else if (dataTondeuse.getDirection() == 'E' && x < dataTondeuse.getMaxX()) {
                            x++;
                        } else if (dataTondeuse.getDirection() == 'N' && y < dataTondeuse.getMaxY()) {
                            y++;
                        } else if (dataTondeuse.getDirection() == 'S' && y > 0) {
                            y--;
                        }
                    }
                }
                res += String.format("%d %d %c ", x, y, dataTondeuse.getDirection());
            }
        }
        dataTondeuse.setResult(res.trim());
        return res;
    }
}
