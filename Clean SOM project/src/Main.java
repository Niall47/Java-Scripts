import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.annotation.JacksonAnnotation;
import com.fasterxml.jackson.core.JsonParser;
import java.lang.*;
import java.io.*;

import java.io.InputStream;
import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;


public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome to the shit show!");
        Vehicle car1 = new Vehicle("Mazda", "MX5", "Green", 1995);
        Vehicle car2 = new Vehicle("Ford", "Capri", "Blue", 1989);
        System.out.println(car1);

//        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.writeValue(new File("lib/car.json"), car1);//
//        ObjectMapper mapper = new ObjectMapper();
//        InputStream is = Main.class.getResourceAsStream("lib/vehicles.json");
//        Vehicle jsonIN = mapper.readValues(is, Main.class);
//        Vehicle jsonIN = mapper.readValues(is, Main.class)
//        myjson2 = mapper.readValues(is, Main.class);
//
//        String filename = "vehicles.json";
//        File vehicles = new File(filename);
//        JSONParser parser = new JSONParser();
//        try (FileReader file = new FileReader(filename)) {
//            Object object = parser.parse(file);
//            JSONArray vehiclelist = (JSONArray)object;
//            System.out.println(vehiclelist);
//            //vehiclelist.forEach(manufacturer -> parsevehicleobject((JSONObject)manufacturer));
//        }catch (Exception e){
//
//        }

    }
}

class Vehicle {
    private String make;
    private String model;
    private String colour;
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

    Vehicle(String make, String model, String colour, int manufactureDate){
        this.make = make;
        this.model = model;
        this.colour = colour;
        this.manufactureDate = manufactureDate;
    }
}