package dao;
import java.sql.*;

public class UserDao {

    public void addUser(String name, String phone, String email) throws Exception {
        Connection con = DBConnection.getConnection();
        String query = "INSERT INTO customers(name, phone, email) VALUES(?,?,?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, name);
        ps.setString(2, phone);
        ps.setString(3, email);
        ps.executeUpdate();
        System.out.println("customer added successfully");
        con.close();
    }

    public void showAllUsers() throws Exception {
        Connection con = DBConnection.getConnection();
        Statement st = con.createStatement();
        ResultSet res = st.executeQuery("SELECT * FROM customers");
        while(res.next()){
            System.out.println(res.getInt("customer_id") + " " + res.getString("name") + " " + res.getString("phone"));
        }
        con.close();
    }

    public int getUserIdByPhone(String phone) throws Exception {
        Connection con = DBConnection.getConnection();
        String query = "SELECT customer_id FROM customers WHERE phone = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, phone);
        ResultSet res = ps.executeQuery();
        int id = -1;
        if(res.next()){
            id = res.getInt("customer_id");
        }
        con.close();
        return id;
    }
}