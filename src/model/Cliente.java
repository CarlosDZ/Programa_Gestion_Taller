import java.sql.Date;

public class Cliente {
    private int id;
    private String name;
    private String phone_num;
    private String shipping_location;
    private Date registration_date;
    private int entity_type; // 1 - Person  // 2 - Enterprise
    

    //Constructor
    public Cliente(String name,String phone,String location,int entity_type){
        this.name = name;
        this.phone_num = phone;
        this.shipping_location = location;
        this.entity_type = entity_type;
    }

    //Getters
    public int getID(){ return this.id; }
    public String getName(){ return this.name; }
    public String getPhone(){ return this.phone_num; }
    public String getLocation(){ return this.shipping_location; }
    public Date getDate(){ return this.registration_date; }
    public int getType(){ return this.entity_type; }

    //Setters
    public void setRegistrationDate(Date date){ this.registration_date = date; }
    public void setID(int id){ this.id = id; }

}
