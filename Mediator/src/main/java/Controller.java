import javafx.scene.control.TextArea;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private String username;
    private ChatMediator chatMediator;
    private TextArea allMessages;
    private List<String> recipient;

    public Controller(TextArea allMessages, String username, ChatMediator chatMediator){
        this.username = username;
        this.allMessages = allMessages;
        this.chatMediator = chatMediator;
        this.recipient = new ArrayList<>();
        recipient.add(username);
    }

    public String getUsername() {
        return username;
    }

    public void sendMessage(String message){
        chatMediator.messageSent(message, username, this);
    }

    public void receivedMessage(String message, String username){
        allMessages.appendText("Message received: " + message + " from: " + username + "\n");
    }

    public void addRecipient(String username){
        recipient.add(username);
    }

    public List<String> getRecipient() {
        return recipient;
    }

    public void removeRecipient(String username){
        recipient.removeIf(username::equalsIgnoreCase);
    }
}
