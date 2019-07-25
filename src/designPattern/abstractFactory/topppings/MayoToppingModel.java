package designPattern.abstractFactory.topppings;

/**
 * Created by sachin on 8/6/19.
 */
public class MayoToppingModel implements Topping {

    String name="mast mayo";

    public MayoToppingModel(){

        prepareTopping();
    }

    @Override
    public void prepareTopping() {
        System.out.println(this.name+" topping adding");
    }



}
