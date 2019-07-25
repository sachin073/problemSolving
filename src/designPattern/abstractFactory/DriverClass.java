package designPattern.abstractFactory;

import designPattern.abstractFactory.grills.BasePizzaFactory;
import designPattern.abstractFactory.grills.Pizza;
import designPattern.abstractFactory.grills.VegCheesePizzaFactory;
import designPattern.abstractFactory.grills.VegMayoPizzaFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

/**
 * Created by sachin on 8/6/19.
 *
 * Pizza factory
 *
 * pizza => type of grill + type of topping
 * topping => set fo sause and verggies
 *
 * we create two factory
 * pizza Base factory >
 * Pan pizza
 * plain pizza
 *
 * topping factory >
 * a. cheeza     > cheese + veg
 * b. cheeseMayo > cheese + mayo
 * c. vegMayo    > mayo + vegan
 *
 *
 */

public class DriverClass {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        //reader = new BufferedReader(new FileReader(new File("src/input.in")));
        bakeVegCheese();
        System.out.println("\n\n");
        bakePlainVegCheese();
        System.out.println("\n\n");
        bakePlainVegMayoPizza();
    }



    public static Pizza bakeVegCheese(){
        BasePizzaFactory factory = new VegCheesePizzaFactory();
        System.out.println(" creating veg cheese pan pizza");

        Pizza pizza = factory.createPizza("pan");

      //  Pizza pizza2 = factory.createPizza("plain");

    return pizza;

    }

    public static Pizza bakePlainVegCheese(){
        BasePizzaFactory factory = new VegCheesePizzaFactory();
        System.out.println(" creating veg cheese plain pizza");

        Pizza pizza = factory.createPizza("plain");

        //  Pizza pizza2 = factory.createPizza("plain");

        return pizza;

    }

    public static Pizza bakePlainVegMayoPizza(){
        BasePizzaFactory factory = new VegMayoPizzaFactory();
        System.out.println(" creating veg Mayo plain pizza");

        Pizza pizza = factory.createPizza("plain");

        return pizza;

    }



}
