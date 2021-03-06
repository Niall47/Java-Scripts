package classes.generator;

import classes.Main;
import classes.fileHandler.JsonRead;
import classes.model.Vehicle;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.util.ArrayList;

public class VehicleGenerator {
    public void VehicleSpecGenerator(JSONArray vehicle_list, int number_of_vehicles){
        Main.logger.add("Generating " + (number_of_vehicles) + " vehicles");

        for (int count = 1; count <= number_of_vehicles; count++) {
            //Make JSON readable and generate a list of possible manufactures
            JSONObject makes = (JSONObject) vehicle_list.get(0);
            ArrayList<String> make = new ArrayList<>();
            Object[] manufacturers = makes.keySet().toArray();
            for (Object manufacturer : manufacturers) {
                make.add(manufacturer.toString());
            }

            //Pick a manufacture
            double random_number = getRandomInt(0, manufacturers.length-1);
            int random_manufacture = (int) random_number;
            String chosen_manufacture = make.get(random_manufacture);

            //Pick a model associated with our manufacture
            JSONObject vehicle_list1 = (JSONObject) vehicle_list.get(0);
            ArrayList models = (ArrayList) vehicle_list1.get(chosen_manufacture);
            double random_number2 = getRandomInt(0, models.size()-1);
            int random_model = (int) random_number2;
            String chosen_model = models.get(random_model).toString();

            //Pick a manufacture date
            double random_number3 = getRandomInt(1950, 2020);
            int chosen_manufacture_date = (int) random_number3;

            //Pick a colour
            String[] colours = {"Red", "Blue", "Silver", "Grey", "Black", "Green", "Yellow"};
            double random_number4 = getRandomInt(0, colours.length-1);
            int colour_picker = (int) random_number4;
            String chosen_colour = colours[colour_picker];

            //Pick a VRM associated with our manufacture date
            VRMGenerator newVRM = new VRMGenerator();
            String chosen_vrm = newVRM.Base_generator(chosen_manufacture_date);

            if(Main.vehicle_registry.get(chosen_vrm) != null ){
                count = count -1;
            }

            Vehicle vehicle = new Vehicle(chosen_manufacture, chosen_model, chosen_colour, chosen_manufacture_date);
            Main.vehicle_registry.put(chosen_vrm, vehicle);
        }
    }
    public void generateMultipleVehicles() {

        //Load list of makes and models
        JSONArray vehicle_list = new JSONArray();
        JsonRead jsonRead = new JsonRead();
        vehicle_list = jsonRead.JsonReader("src/main/resources/vehicles.json");

        int how_many_vehicles = 10000;
        VehicleSpecGenerator(vehicle_list, how_many_vehicles);

        //report back after generating records
        Main.logger.add("We now have " + Main.vehicle_registry.size() + " records");
        Main.logger.add("Caught " + new VRMGenerator().getDuplicateVRM() + " duplicates");
        Main.logger.add("Caught " + new VRMGenerator().getInvalidCharacters() + " invalid registrations ");


    }

    private double getRandomInt(double min, double max){
        return (int)(Math.random()*((max-min)+1))+min;
    }

}