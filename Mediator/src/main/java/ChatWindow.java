import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ChatWindow extends Application{
    private final ChatMediator chatMediator = new ChatMediator();
//    private final TextArea allMessages = new TextArea();
    public void start(Stage stage){
        windowStaging("Vesa");
        windowStaging("Jarkko");
        windowStaging("Matti");
    }

    public void windowStaging(String username){
        Stage stage = new Stage();
        TextArea allMessages = new TextArea();
//        Controller controller = new Controller(this, username, chatMediator);
        Controller controller = new Controller(allMessages, username, chatMediator);
        chatMediator.addController(controller);

        Insets insets = new Insets(10, 10, 10, 10);


        allMessages.setEditable(false);
        TextField message = new TextField();
        Button sendButton = new Button("SEND");
        Button selectRecipient = new Button("SEND TO");
        VBox vBox = new VBox(allMessages, message, sendButton, selectRecipient);
//        selectRecipient.setOnAction(actionEvent -> {
//            for (Controller c:chatMediator.getControllers()){
//                if(!username.equalsIgnoreCase(c.getUsername())){
//                    vBox.getChildren().add(new CheckBox(c.getUsername()));
//                }
//            }
//        });
        sendButton.setOnAction(event -> {
            controller.sendMessage(message.getText());
            message.clear();
        });
        stage.setScene(new Scene(vBox));

        stage.setTitle(controller.getUsername());
        stage.show();


    }

//    public void updateAllMessages(String message, String username){
//        allMessages.appendText("Message received: " + message + " from: " + username + "\n");
//    }



}
