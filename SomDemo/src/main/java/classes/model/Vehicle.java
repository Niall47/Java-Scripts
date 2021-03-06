package classes.model;
import javax.persistence.*;

@Entity
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false, unique = false)
    private String make;

    @Column(nullable = false)
    private String model;

    @Column(nullable = false)
    private String colour;

    @Column(nullable = false)
    private int manufactureDate;

    @Override
    public String toString(){
        return "Make: " + make + ", Model: " + model + ", Colour: " + colour + ", Built: " + manufactureDate;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public int getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(int manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public Vehicle(String make, String model, String colour, int manufactureDate){
        this.make = make;
        this.model = model;
        this.colour = colour;
        this.manufactureDate = manufactureDate;
    }
}