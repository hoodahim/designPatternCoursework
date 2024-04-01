public interface FileSystemVisitor {
    void visitFile(FileSystemElement element);
    void visitDirectory(FileSystemElement element);
}
