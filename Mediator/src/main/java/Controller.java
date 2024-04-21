import javafx.scene.control.TextArea;

public class Controller {
    private String username;
    private ChatMediator chatMediator;
    private TextArea allMessages;

//    public Controller(ChatWindow chatWindow, String username, ChatMediator chatMediator){
//        this.username = username;
//        this.chatWindow = chatWindow;
//        this.chatMediator = chatMediator;
//    }

    public Controller(TextArea allMessages, String username, ChatMediator chatMediator){
        this.username = username;
        this.allMessages = allMessages;
        this.chatMediator = chatMediator;
    }

    public String getUsername() {
        return username;
    }

    public void sendMessage(String message){
        chatMediator.messageSent(message, username);
    }

//    public void receivedMessage(String message, String username){
//        chatWindow.updateAllMessages(message, username);
//    }

    public void receivedMessage(String message, String username){
        allMessages.appendText("Message received: " + message + " from: " + username + "\n");
    }
}
