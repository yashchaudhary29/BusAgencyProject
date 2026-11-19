import dao.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner input=new Scanner(System.in);
        BusDao bd=new BusDao();
        BookingDao bkd=new BookingDao();
        UserDao ud=new UserDao();
        while(true){
            System.out.println("\n1: See All Buses 2: Add Bus 3: Book Ticket 4: See Bookings 5: Add New Customer, 6: See All Customers 7: Search Buses 8: Remove bus 9: cancel ticket 10: Exit");
            int ch=input.nextInt(); input.nextLine();
            if(ch==1) bd.showAllBuses();
            else if(ch==2){
                System.out.println("Bus number, Name, Seat, Type: ");
                bd.AddBuses(input.nextLine(), input. nextLine(), input.nextInt(), input.nextLine());

            }
            else if(ch==3){
                System.out.println("customer id, Bus id, RouteId, Date(2026-11-20), Seats");
                bkd.bookTicket(input.nextInt(),input.nextInt(), input.nextInt(), input.next(), input.nextInt());
            }
            else if(ch==4)bkd.showAllBookings();
            else if(ch==5){
                System.out.println("Name, Phone, Email: ");
                ud.addUser(input.nextLine(), input.nextLine(), input.nextLine());
            }
            else if(ch==6) ud.showAllUsers();
            else if(ch==7){
                System.out.println("bus_id");
                bd.searchBus(input.nextInt());
            }
            else if(ch==8){
                System.out.println("bus_id");
                bd.RemoveBus(input.nextInt(),input.nextLine());
            }
            else if(ch==9){
                System.out.println("booking_id");
                bkd.CancelTicket(input.nextInt());
            }
            else break;
        }
    }
    
}
