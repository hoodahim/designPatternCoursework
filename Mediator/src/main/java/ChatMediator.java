import java.util.ArrayList;
import java.util.List;

public class ChatMediator {
    private List<Controller> controllers;

    public ChatMediator(){
        this.controllers = new ArrayList<>();
    }
    public void messageSent(String message, String username){
        for (Controller c:controllers){
            c.receivedMessage(message, username);
        }
    }

    public void addController(Controller controller){
        controllers.add(controller);
    }

    public List<Controller> getControllers() {
        return controllers;
    }
}
