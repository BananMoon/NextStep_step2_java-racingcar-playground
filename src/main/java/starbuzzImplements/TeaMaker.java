package starbuzzImplements;

public class TeaMaker extends DrinkMaker {

    @Override
    public void addCondiments() {
        System.out.println("Please add a lemon.");
    }
    @Override
    public void brew() {
        System.out.println("Please steep teabag");
    }
}
