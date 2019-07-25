package designPattern.abstractFactory.grills;

import designPattern.abstractFactory.topppings.BaseToppingFactory;
import designPattern.abstractFactory.topppings.Topping;
import designPattern.abstractFactory.topppings.VegCheesyToppingFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sachin on 8/6/19.
 */
public class FreshPanPizza implements Pizza {

    List<Topping> topping;

    BaseToppingFactory toppingFactory;

    FreshPanPizza(BaseToppingFactory toppingFactory){

        this.toppingFactory = toppingFactory;

        System.out.println(this.getClass().getName()+" pizza base preparing");
    }

    @Override
    public void addIngredients() {
        topping = new ArrayList<>();
        topping.add(toppingFactory.createBase());
        topping.add(toppingFactory.createExtraLayer());
    }


}
