package designPattern.adapter;

/**
 * Created by sachin on 9/6/19.
 */
public class CosmicPower implements CosmicEnergy {

    @Override
    public void gatherAndDischarge(String device) {
        System.out.println("Cosmic energy Gathering from nature");
        System.out.println("discharging into "+device);

    }

}
