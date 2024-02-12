import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Printer printer = new FilePrinter(new BasicPrinter());
        printer.print("Hello B/a#Ch");
    }
}
