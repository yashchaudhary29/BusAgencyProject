package model;
public class User{
    public int customer_id;
    public String name;
    public String phone;
    public String email;
    public User(){}
    public User(int id, String name, String phone, String email){
        this.customer_id=id;
        this.name=name;
        this.phone=phone;
        this.email=email;
    }
} 