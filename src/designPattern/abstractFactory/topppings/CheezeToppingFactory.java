package designPattern.abstractFactory.topppings;

/**
 * Created by sachin on 8/6/19.
 */
public class CheezeToppingFactory implements BaseToppingFactory {

    @Override
    public Topping createBase() {
        return new CheeseToppingModel();
    }

    @Override
    public Topping createExtraLayer() {
        return new VegToppingModel();
    }
}
