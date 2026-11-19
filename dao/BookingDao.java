package dao;
import java.sql.*;

public class BookingDao {

    public void bookTicket(int customerId, int busId, int routeId, String date, int seats) throws Exception {
        Connection con = DBConnection.getConnection();
        String query = "INSERT INTO bookings(customer_id, bus_id, route_id, journey_date, seats_booked) VALUES(?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, customerId);
        ps.setInt(2, busId);
        ps.setInt(3, routeId);
        ps.setString(4, date);
        ps.setInt(5, seats);
        ps.executeUpdate();
        System.out.println("ticket booked successfully");
        con.close();
    }

    public void showAllBookings() throws Exception {
        Connection con = DBConnection.getConnection();
        Statement st = con.createStatement();
        ResultSet res = st.executeQuery("SELECT * FROM bookings");
        while(res.next()){
            System.out.println("Booking Id: " + res.getInt("booking_id") + " Customer: " + res.getInt("customer_id") + " Bus: " + res.getInt("bus_id") + " Seats: " + res.getInt("seats_booked"));
        }
        con.close();
    }
    public void CancelTicket(int bookingId) throws Exception{
        Connection con = DBConnection.getConnection();
        String query= "DELETE FROM bookings WHERE booking_id=? ";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, bookingId);
        int rows=ps.executeUpdate();
        if(rows>0){
            System.out.println("ticket cancel successfully");
        }
        else{
            System.out.println("ticket not exist");
        }
    }
}