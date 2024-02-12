import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class FilePrinter extends PrinterDecorator{

    private Printer printer;
    private String fileName;
    private BufferedWriter writer;

    public FilePrinter(Printer printer){
        this.printer = printer;
        fileName = "Printer.txt";
    }

    @Override
    public void print(String message) throws IOException, InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
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
