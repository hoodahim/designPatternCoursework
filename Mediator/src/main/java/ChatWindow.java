import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ChatWindow extends Application{
    private final ChatMediator chatMediator = new ChatMediator();
    public void start(Stage stage){
        windowStaging("Vesa");
        windowStaging("Jarkko");
        windowStaging("Matti");
    }

    public void windowStaging(String username){
        Stage stage = new Stage();
        Insets insets = new Insets(10, 10, 10, 10);
        TextArea allMessages = new TextArea();
        allMessages.setPadding(insets);
        allMessages.setEditable(false);

        Controller controller = new Controller(allMessages, username, chatMediator);
        chatMediator.addController(controller);

        TextField message = new TextField();
        message.setPadding(insets);
        Button sendButton = new Button("SEND");
        sendButton.setPadding(insets);
        Button selectRecipient = new Button("SEND TO");
        selectRecipient.setPadding(insets);
        VBox vBox = new VBox(allMessages, message, sendButton, selectRecipient);
        selectRecipient.setOnAction(actionEvent -> {
            for (Controller c:chatMediator.getControllers()){
                if(!username.equalsIgnoreCase(c.getUsername())){
                    CheckBox checkBox = new CheckBox(c.getUsername());
                    vBox.getChildren().add(checkBox);
                    checkBox.setOnAction(event->{
                        if (checkBox.isSelected()){
                            controller.addRecipient(checkBox.getText());
                            System.out.println("added to recipient for " + controller.getUsername());
                        }
                        else {
                            controller.removeRecipient(checkBox.getText());
                            System.out.println("removed from recipient for " + controller.getUsername());
                        }
                    });
                }
            }
            selectRecipient.setOnAction(null);
        });
        sendButton.setOnAction(event -> {
            controller.sendMessage(message.getText());
            message.clear();
        });
        stage.setScene(new Scene(vBox));

        stage.setTitle(controller.getUsername());
        stage.show();


    }
}
