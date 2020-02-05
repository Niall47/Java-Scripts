package classes.controller;

import classes.Main;
import classes.generator.VehicleGenerator;
import classes.illegalCombo.illegalVRMScan;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
@RequestMapping("/")
public class VehicleController {
    @RequestMapping(value = "count", method = RequestMethod.GET)
    public String count(){
        return "At present there are " + Main.vehicle_registry.size() + " vehicles registered.";
    }

    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public String delete(){
        Main.vehicle_registry.clear();
        return "At present there are " + Main.vehicle_registry.size() + " vehicles registered.";
    }

    @RequestMapping(value = "scan", method = RequestMethod.GET)
    public String scan(){
        new illegalVRMScan();
        return "Scanning for naughty words";
    }

    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String create(){
        VehicleGenerator fire_them_up = new VehicleGenerator();
        fire_them_up.generateMultipleVehicles();
        return "Creating 10,000 vehicles";
    }

    @RequestMapping(value = "log", method = RequestMethod.GET)
    public ArrayList<String> log(){
        return Main.logger;
    }

    @RequestMapping(value = "logger",  method = RequestMethod.GET)
    public String logger(){
        return "words \n words \r words /n words \r";
    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public HashMap listAll(){
        return Main.vehicle_registry;
    }

    @RequestMapping(value = "rude", method = RequestMethod.GET)
    public HashMap rude(){
        illegalVRMScan name = new illegalVRMScan();
        return name.getNaughtyList();
    }
}
