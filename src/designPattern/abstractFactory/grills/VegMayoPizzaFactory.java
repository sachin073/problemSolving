package designPattern.abstractFactory.grills;

import designPattern.abstractFactory.topppings.BaseToppingFactory;
import designPattern.abstractFactory.topppings.VegCheesyToppingFactory;
import designPattern.abstractFactory.topppings.VeganToppingFactory;

/**
 * Created by sachin on 8/6/19.
 */
public class VegMayoPizzaFactory implements BasePizzaFactory {


    BaseToppingFactory toppingFactory= new VeganToppingFactory();


    @SuppressWarnings("all")
    @Override
    public Pizza createPizza(String pizzaBase) {
        Pizza pizza;

        switch (pizzaBase.toLowerCase()) {

            case "pan":
                pizza = new FreshPanPizza(toppingFactory);
                break;
            case "plain":
                pizza = new PlainCoolPizza(toppingFactory);
                break;
            default:
                throw new RuntimeException(" wrong type of pizza found");

        }
        System.out.println( pizzaBase+" created");
        pizza.addIngredients();
        System.out.println( pizzaBase+" toppings added created");

        return pizza;
    }

}
