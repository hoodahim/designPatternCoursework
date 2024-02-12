import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class FilePrinter extends PrinterDecorator{

    private Printer printer;
    private String fileName;
    private BufferedWriter writer;

    public FilePrinter(Printer printer){
        this.printer = printer;
        fileName = "Printer.txt";
    }

    @Override
    public void print(String message) throws IOException {
        printer.print(message);
        try {
            writer = new BufferedWriter(new FileWriter(fileName));
            writer.write(message);
            writer.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
