package dao;
import java.sql.*;

public class BusDao {
    public void showAllBuses() throws Exception {
        Connection con = DBConnection.getConnection();
        Statement st = con.createStatement();
        ResultSet res = st.executeQuery("SELECT * FROM buses");
        while(res.next()){
            System.out.println(res.getInt("bus_id") + " " + res.getString("bus_number") + " " + res.getString("bus_name"));
        }
        con.close();
    }

    public void AddBuses(String number, String name, int seats, String type) throws Exception {
        Connection con = DBConnection.getConnection();
        String query = "INSERT INTO buses(bus_number, bus_name, total_seats, bus_type) VALUES(?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, number);
        ps.setString(2, name);
        ps.setInt(3, seats);
        ps.setString(4, type);
        ps.executeUpdate();
        System.out.println("bus added successfully");
        con.close();
    }
    public void searchBus(int busId) throws Exception{
        Connection con = DBConnection.getConnection();
        String query= "SELECT * FROM buses WHERE bus_id=? ";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, busId);
        ResultSet res=ps.executeQuery();
        boolean found=false;
        while(res.next()){
            found=true;
            System.out.println(res.getInt("bus_id") + " " + res.getString("bus_number") + " " + res.getString("bus_name"));
        }
        if(!found){
            System.out.println("bus not found");
        }
    }
    
    public void RemoveBus(int busId, String Name) throws Exception{
        Connection con = DBConnection.getConnection();
        String query= "DELETE FROM buses WHERE bus_id=? AND bus_name=? ";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, busId);
        ps.setString(2,Name);
        int rows=ps.executeUpdate();
        if(rows>0){
            System.out.println("bus remove successfully");
        }
        else{
            System.out.println("bus not exist");
        }
    }
}