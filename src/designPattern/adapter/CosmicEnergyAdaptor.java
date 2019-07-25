package designPattern.adapter;

/**
 * Created by sachin on 9/6/19.
 */
public class CosmicEnergyAdaptor implements Power{

    CosmicEnergy energy;

    @Override
    public void discharge(String device) {
        energy=new CosmicPower();
        energy.gatherAndDischarge(device);
    }
}
