package designPattern.abstractFactory.topppings;

/**
 * Created by sachin on 8/6/19.
 */
public interface BaseToppingFactory {

    Topping createBase();

    Topping createExtraLayer();

}
