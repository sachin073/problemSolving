package designPattern.abstractFactory.grills;

import designPattern.abstractFactory.topppings.BaseToppingFactory;
import designPattern.abstractFactory.topppings.Topping;
import designPattern.abstractFactory.topppings.VegCheesyToppingFactory;

/**
 * Created by sachin on 8/6/19.
 */
public class VegCheesePizzaFactory implements BasePizzaFactory {


    BaseToppingFactory toppingFactory= new VegCheesyToppingFactory();

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
        System.out.println( pizzaBase+" pizza base created.\nAdding toppings ");
        pizza.addIngredients();
        System.out.println( pizzaBase+" toppings added ");
        System.out.println( pizzaBase+" pizza created ");
        return pizza;
    }
}
