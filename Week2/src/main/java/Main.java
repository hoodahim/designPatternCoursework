public class Main {
    public static void main(String[] args){
        UIFactory factory = new BFactory();

        Button button = factory.createButton("Click me!");
        Checkbox checkbox = factory.createCheckbox("Check me!");
        TextField textField = factory.createTextField("Write me");

        button.display();
        checkbox.display();
        textField.display();

        button.setText("Click again!");

        button.display();

    }
}
