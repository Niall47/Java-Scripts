package classes;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import classes.model.Vehicle;
import classes.fileHandler.asciiIntro;
import classes.generator.VehicleGenerator;
import classes.illegalCombo.illegalVRMScan;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@SpringBootApplication
public class Main {
    public static HashMap<String, Vehicle> vehicle_registry =  new HashMap<>();
    public static ArrayList<String> logger = new ArrayList<String>();
    public static void main(String[] args) {

        //Start API service
        SpringApplication.run(Main.class, args);
        logger.add("Started Spring Boot");

        //Load title
        asciiIntro intro = new asciiIntro();

        //Start generating vehicles
        VehicleGenerator fire_them_up = new VehicleGenerator();
        fire_them_up.generateMultipleVehicles();

        //Scan & replace offensive registrations
        //System.out.println("Scanning for illegal registration marks");
        //illegalVRMScan first = new illegalVRMScan();


//        vehicle_registry.entrySet()
//                .forEach(System.out::println);


    }
}