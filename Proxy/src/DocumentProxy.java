import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DocumentProxy implements IDocument{
    private String identifier;
    private LocalDateTime time;
    private String content;
    private Document document;
    private AccessControlService accessControlService;
    public DocumentProxy(String content, String identifier){
        this.content = content;
        this.identifier = identifier;
        this.time = LocalDateTime.now();
        this.accessControlService = AccessControlService.instantiate();
    }
    @Override
    public String getIdentifier() {
        return identifier;
    }
    @Override
    public String getTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        return time.format(formatter);
    }
    public String getContent(User user) {
        if(accessControlService.authenticate(identifier, user)){
            document = new Document(content, identifier);
            return document.getContent(user);
        }
        return failedAuth();
    }

    private String failedAuth(){
        return "Failed Authentication. The user is not authorized to view the Content of the protected document.";
    }
}
