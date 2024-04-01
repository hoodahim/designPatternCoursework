public interface FileSystemElement {
    void access(FileSystemVisitor visitor);
    void addFile(FileSystemElement element);
    void removeFile(FileSystemElement element);
    String getName();
    float getSize();
}
