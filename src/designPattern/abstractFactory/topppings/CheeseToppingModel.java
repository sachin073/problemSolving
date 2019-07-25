package designPattern.abstractFactory.topppings;

/**
 * Created by sachin on 8/6/19.
 */
public class CheeseToppingModel implements Topping{

    String cheeseName="Topping : Brown cheese";

    public CheeseToppingModel(){
        prepareTopping();
    }

    @Override
    public void prepareTopping() {
        System.out.println(this.cheeseName+" topping adding");
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
