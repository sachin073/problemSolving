package designPattern.abstractFactory.topppings;

/**
 * Created by sachin on 8/6/19.
 */
public class VegToppingModel implements Topping {

    String name="Topping : veg Loaded ";

    public VegToppingModel(){
        prepareTopping();
    }


    @Override
    public void prepareTopping() {
        System.out.println(this.name + " adding");
    }


}
