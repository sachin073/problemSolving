package designPattern.abstractFactory.topppings;

/**
 * Created by sachin on 8/6/19.
 */
public class VegCheesyToppingFactory implements BaseToppingFactory {

    @Override
    public Topping createBase() {
        return new VegToppingModel();
    }

    @Override
    public Topping createExtraLayer() {
        return new CheeseToppingModel();
    }
}
