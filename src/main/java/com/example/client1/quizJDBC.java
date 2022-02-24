package com.example.client1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

public class quizJDBC {

    public static void addQuiz(){
        Connection connection = null;

        String csvPath = "C:\\Users\\c21019020\\OneDrive - Cardiff University\\Desktop\\team-9-mental-health-and-wellbeing\\build\\resources\\main\\static\\csv\\test1.csv";

        int batchSize = 20;

        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/charity?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC", "root", "comsc");

            String sql = "insert into new_quiz (id,question,optionA,optionB,optionC,optionD,optionE) values(?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement statement = connection.prepareStatement(sql);

            BufferedReader lineReader = new BufferedReader(new FileReader(csvPath));
            String lineText = null;

            int count = 0;

            lineReader.readLine(); //skip header line

            while ((lineText = lineReader.readLine()) != null) {
                String[] data = lineText.split(",");
                String id = data[0];
                String question = data[1];
                String optionA = data[2];
                String optionB = data[3];
                String optionC = data[4];
                String optionD = data[5];
                String optionE = data[6];

                statement.setString(1, id);
                statement.setString(2, question);
                statement.setString(3, optionA);
                statement.setString(4, optionB);
                statement.setString(5, optionC);
                statement.setString(6, optionD);
                statement.setString(7, optionE);

                statement.addBatch();

                if (count % batchSize == 0) {
                    statement.executeBatch();
                }
            }

            lineReader.close();

            //excute the remaining queries
            statement.executeBatch();
            connection.setAutoCommit(false);
//                connection.commit();
            connection.close();

        }catch (IOException ex){
            System.out.println(ex);
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }
    public static void main(String[] args) {
        addQuiz();
    }
}
