import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String [] args){
        List<FileSystemElement> fileSystem = new ArrayList<>();

        FileSystemElement file1 = new File("text1", 4);
        FileSystemElement file2 = new File("text2", 2);
        FileSystemElement file3 = new File("text3", 6);
        FileSystemElement file4 = new File("text4", 1);

        FileSystemElement directory1 = new Directory("folder1");
        FileSystemElement directory2 = new Directory("folder2");
        FileSystemElement directory3 = new Directory("folder3");

        directory1.addFile(file2);
        directory1.addFile(file3);
        directory2.addFile(file1);
        directory3.addFile(directory1);
        directory3.addFile(file4);

        fileSystem.add(file1);
        fileSystem.add(file2);
        fileSystem.add(file3);
        fileSystem.add(directory3);
        fileSystem.add(directory1);
        fileSystem.add(directory2);

        FileSystemVisitor sizeCalculator = new SizeCalculatorVisitor();

        for(FileSystemElement element:fileSystem){
            element.access(sizeCalculator);
        }

        System.out.println();

        fileSystem.add(file4);
        fileSystem.remove(file2);

        FileSystemVisitor search = new SearchVisitor();
        for (FileSystemElement element:fileSystem){
            if(element instanceof File){
                element.access(search);
            }
        }



    }
}
