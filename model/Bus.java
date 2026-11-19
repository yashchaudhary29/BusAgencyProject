package model;

public class Bus {
    public int bus_id;
    public String bus_number, bus_name, bus_type;
    public int total_seats;
    public Bus(int id, String no, String name, int seats, String type){
        bus_id=id;
        bus_number=no;
        bus_name=name;
        total_seats=seats;
        bus_type=type;
    }
}
