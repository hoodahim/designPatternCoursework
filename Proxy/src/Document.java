import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Formatter;

public class Document implements IDocument {
    private String identifier;
    private LocalDateTime time;
    private String content;
    public Document(String content, String identifier){
        this.content = content;
        this.identifier = identifier;
        this.time = LocalDateTime.now();
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
    @Override
    public String getContent(User user) {
        return content;
    }
}
