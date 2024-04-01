public class SearchVisitor implements FileSystemVisitor{
    @Override
    public void visitFile(FileSystemElement element) {
        String name = element.getName();
        System.out.println("File Name: " + name);
    }

    @Override
    public void visitDirectory(FileSystemElement element) {
        String name = element.getName();
        System.out.println("File Name: " + name);
    }
}
