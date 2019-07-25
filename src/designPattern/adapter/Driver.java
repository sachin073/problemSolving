package designPattern.adapter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

/**
 * Created by sachin on 9/6/19.
 */
public class Driver {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        //reader = new BufferedReader(new FileReader(new File("src/input.in")));
        String device = "motor";
        Power power = new ElectricPower();
        power.discharge(device);

        //using cosmic energy
        power = new CosmicEnergyAdaptor();
        power.discharge(device);

    }
}
