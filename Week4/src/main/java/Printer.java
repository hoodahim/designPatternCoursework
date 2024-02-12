import java.io.IOException;

public abstract class Printer {

    public void print(String message) throws IOException {
        System.out.println(message);
    };
}
