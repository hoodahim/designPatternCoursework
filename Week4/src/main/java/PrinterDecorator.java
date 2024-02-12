import java.io.IOException;

public abstract class PrinterDecorator extends Printer{

    @Override
    public void print(String message) throws IOException {
        super.print(message);
    }
}
