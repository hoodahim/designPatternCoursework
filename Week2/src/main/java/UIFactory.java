public abstract class UIFactory {

    public Button createButton(String text){
        return new Button(){};
    };

    public TextField createTextField(String text){
        return new TextField() {
        };
    }

    public Checkbox createCheckbox(String text){
        return new Checkbox() {
        };
    }
}
