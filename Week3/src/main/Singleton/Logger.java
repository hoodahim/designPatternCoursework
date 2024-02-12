import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {

    private String fileName;
    private static Logger instance;
    private BufferedWriter writer;

    private Logger(){
        fileName =  "newFile.txt";
        try{
            this.writer = new BufferedWriter(new FileWriter(fileName, true));
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static Logger getInstance(){
        if(instance == null){
            instance = new Logger();
        }
        return instance;
    }

    public void setFileName(String fileName){
        try {
            writer.close();
            this.fileName = fileName;
            writer = new BufferedWriter(new FileWriter(fileName, true));
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void write(String message){
        try{
            writer.write(message);
            writer.newLine();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void close(){
        try {
            writer.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }


}
