public abstract class Button{

    String text;

    public Button(String text){
        this.text = text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public abstract void display();
}
