package designPattern.adapter;

/**
 * Created by sachin on 9/6/19.
 */
public class ElectricPower implements Power {

    @Override
    public void discharge(String device) {
        System.out.println(device+" using electric charger");
    }
}


