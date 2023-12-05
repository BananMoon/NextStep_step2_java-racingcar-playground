package starbuzzImplements;

public abstract class DrinkMaker {
    public void prepareReciepe() {
        boilWater();
        brew();
        putIntoTheCup();
        addCondiments();
    }

    protected void boilWater() {
        System.out.println("Boil the water.");
    }

    public void putIntoTheCup() {
        System.out.println("Put your drink into the cup.");
    }

    abstract void addCondiments();
    abstract void brew();
}
