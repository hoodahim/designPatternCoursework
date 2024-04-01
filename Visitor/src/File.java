public class File implements FileSystemElement{
    private String name;
    private float size;

    public File(String name, float size){
        this.name = name;
        this.size = size;
    }

    @Override
    public void addFile(FileSystemElement element) {

    }
    @Override
    public void removeFile(FileSystemElement element) {

    }
    @Override
    public void access(FileSystemVisitor visitor) {
        visitor.visitFile(this);
    }

    @Override
    public String getName() {
        return name;
    }

    public float getSize(){
        return size;
    }

}
