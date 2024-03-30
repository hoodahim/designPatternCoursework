import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AccessControlService {
    private HashMap<String, User> users;
    private static AccessControlService accessControlService;
    private AccessControlService(){
        this.users = new HashMap<>();
    }
    public static AccessControlService instantiate(){
        if(accessControlService == null){
            accessControlService = new AccessControlService();
        }
        return accessControlService;
    }
    public void addToList(User user, IDocument document){
        users.put(document.getIdentifier(), user);
    }
    public boolean authenticate(String identifier, User user){
        return users.containsKey(identifier) && users.containsValue(user);
    }
}
