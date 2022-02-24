import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBC {

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/client?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC", "root", "12345678");
            statement = connection.createStatement();

            String sql = "SELECT * FROM client.quiz;";

            resultSet = statement.executeQuery(sql);

//            List<String> ques = new ArrayList<String>();
//            while (resultSet.next()){
//                ques.add(resultSet.getString("question"));
//            }
//            if (ques != null && ques.size() > 0){
//                String[] arr = new String[ques.size()];
//                for (int i = 0; i < ques.size(); i++){
//                    arr[i] = ques.get(i);
//                }
//                for (int i = 0; i < arr.length; i++){
//                    System.out.println(arr[i]);
//                }
//            }

            while (resultSet.next()){
                  System.out.println(resultSet.getString("id"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (resultSet != null){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }



    }
}
