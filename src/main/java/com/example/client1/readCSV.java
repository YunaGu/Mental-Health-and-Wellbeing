package com.example.client1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class readCSV {
    //   text file that uses a comma to separate values

    public static void main(String[] args) {
        String file = "C:\\Users\\c21019020\\OneDrive - Cardiff University\\Desktop\\team-9-mental-health-and-wellbeing\\build\\resources\\main\\static\\csv\\test1.csv";
        BufferedReader reader = null;
        String line = "";

        try {
            reader = new BufferedReader(new FileReader(file));
            while((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                //String[] row = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
                //use this if your values already contain commas
                for(String index : row) {
                    System.out.printf("%-10s", index);
                }
                System.out.println();
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
