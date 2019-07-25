package designPattern.abstractFactory.topppings;

/**
 * Created by sachin on 8/6/19.
 */
public class VeganToppingFactory implements BaseToppingFactory{


    @Override
    public Topping createExtraLayer() {
        return new MayoToppingModel();
    }

    @Override
    public Topping createBase() {
        return new VegToppingModel();
    }
}
