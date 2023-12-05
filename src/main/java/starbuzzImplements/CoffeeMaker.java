package starbuzzImplements;

public class CoffeeMaker extends DrinkMaker{

    @Override
    public void addCondiments() {
        System.out.println("Please add Suger and milk.");
    }
    @Override
    public void brew() {
        System.out.println("Please brew coffee grinds.");
    }

}
