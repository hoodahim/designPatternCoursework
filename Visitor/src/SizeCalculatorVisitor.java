public class SizeCalculatorVisitor implements FileSystemVisitor{
    @Override
    public void visitFile(FileSystemElement element) {
        float size =element.getSize();
        System.out.println("File Size: " + size);
    }

    @Override
    public void visitDirectory(FileSystemElement element) {
        float size = element.getSize();
        System.out.println("Folder size: " + size);
    }
}
