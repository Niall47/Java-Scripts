package classes.illegalCombo;

import classes.Main;
import classes.generator.VRMGenerator;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class illegalVRMScan {
    List<String> lines;
    ArrayList<String> ReplaceList = new ArrayList();

    public HashMap<String, ArrayList> getNaughtyList() {
        return NaughtyList;
    }

    HashMap<String, ArrayList> NaughtyList =  new HashMap<>();
    public illegalVRMScan() {

        try {
            lines = Files.readAllLines(new File("src/main/resources/illegal_vrm_list.txt").toPath());
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        //We iterate through our criteria list
        System.out.println("Comparing " + lines.size() + " illegal formats against " + Main.vehicle_registry.size() + " vehicle records");
        for (String line : lines) {
            Pattern pattern = Pattern.compile(line);
            //we iterate through our VRM list
            Main.vehicle_registry.forEach((key, value) -> {
                Matcher m = pattern.matcher(key);
                //we print our results that violated the rules
                if (m.find()) {
                    System.out.println("Caught: " + key + " comparing: " + m.pattern());
                    ArrayList<String> matches = new ArrayList<>();
                    if (NaughtyList.get(key) != null) {
                        matches.add(NaughtyList.get(key).toString());
                    }
                    matches.add(key);
                    NaughtyList.put(m.pattern().toString(), matches);
                    ReplaceList.add(key);
                }
            });
        }
        //Send the list to get less offensive registration marks
        if (NaughtyList.isEmpty()){
            System.out.println("No illegal registrations found");
        }else {
            ReplaceBadVRM(ReplaceList);
        }
    }
    private static void ReplaceBadVRM(ArrayList NaughtyList){
        System.out.println("Replacing " + NaughtyList.size() + " registration marks");
        //iterate through our naughty list and generate new vrm for each
        NaughtyList.forEach((vrm) -> {
            try {
                VRMGenerator newVRM = new VRMGenerator();
                String chosen_vrm = newVRM.Base_generator(Main.vehicle_registry.get(vrm).getManufactureDate());
                Main.vehicle_registry.put(chosen_vrm, Main.vehicle_registry.get(vrm));
                Main.vehicle_registry.remove(vrm);
                System.out.println("Replacing: " + vrm + " with: " + chosen_vrm );
            }catch(Exception e){
                e.printStackTrace();
            }
        });
    }


}

