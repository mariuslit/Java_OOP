package a_fundamental_java2;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class Fund_1_MySql_DB_Connection {

    public static void main(String[] args) {


        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // nebūtinas jeigu veikia ir be jo

            // gali neveikti su senesnėmis versijomis, tai reikia įterpti koduotę:
            // ?useUnicode=yes&characterEncoding=UTF-8
            // {localhost | 127.0.0.1}
            String url = "jdbc:mysql://localhost:3306/employees";// + "?useUnicode=yes&characterEncoding=UTF-8";
            con = DriverManager.getConnection(url, "root", "");
            Statement stmt = con.createStatement();
            ResultSet resultSet = stmt.executeQuery(
                    "SELECT * FROM employees WHERE emp_no >= 500000 order by emp_no desc limit 200;");

            // ištraukia duomenis iš ResultSet'o
            Map<Integer, String> map = new HashMap<>();
            System.out.println("start");
            while (resultSet.next()) {
                int x = resultSet.getInt("emp_no");
                map.put(resultSet.getInt("emp_no"), " " +
                        resultSet.getString("first_name") + " " +
                        resultSet.getString("last_name") + " " +
                        resultSet.getString("hire_date"));
            }

            // atspausdina duomenis
            for (Map.Entry m : map.entrySet()) {
                System.out.println(m.getKey() + " " + m.getValue());
            }

            stmt.close();
            con.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

        }




    }
}
