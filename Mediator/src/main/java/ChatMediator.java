import java.util.ArrayList;
import java.util.List;

public class ChatMediator {
    private final List<Controller> controllers;

    public ChatMediator(){
        this.controllers = new ArrayList<>();
    }
    public void messageSent(String message, String username, Controller controller){
        for (String s: controller.getRecipient()){
            for(Controller c:controllers){
                if (c.getUsername().equalsIgnoreCase(s)){
                    c.receivedMessage(message, username);
                }
            }
        }
    }

    public void addController(Controller controller){
        controllers.add(controller);
    }

    public List<Controller> getControllers() {
        return controllers;
    }
}
