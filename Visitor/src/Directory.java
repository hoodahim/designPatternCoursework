import java.util.ArrayList;
import java.util.List;

public class Directory implements FileSystemElement{
    private String name;
    private List<FileSystemElement> folder;

    public Directory(String name){
        this.name = name;
        this.folder = new ArrayList<>();
    }

    @Override
    public void addFile(FileSystemElement element) {
        folder.add(element);
    }
    @Override
    public void removeFile(FileSystemElement element) {
        folder.remove(element);
    }

    @Override
    public void access(FileSystemVisitor visitor) {
        visitor.visitDirectory(this);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public float getSize() {
        float totalSize = 0;
        for(FileSystemElement element:folder){
            totalSize += element.getSize();
        }
        return totalSize;
    }
}
