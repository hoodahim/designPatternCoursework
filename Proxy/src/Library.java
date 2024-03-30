import java.util.HashMap;

public class Library {
    private HashMap<String, IDocument> library = new HashMap<>();
    public HashMap<String, IDocument> getLibrary() {
        return library;
    }
    public void addToLibrary(IDocument document){
        library.put(document.getIdentifier(), document);
    }
    public IDocument getDocument(String identifier){
        if(library.containsKey(identifier)){
            return library.get(identifier);
        }
        return null;
    }
}
