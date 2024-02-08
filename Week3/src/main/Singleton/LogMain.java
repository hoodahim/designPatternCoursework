public class LogMain {
    public static void main(String[] args){
        Logger logger = Logger.getInstance();
        logger.setFileName("Modified.txt");
        logger.write("This is modified file");
        logger.write("This is second line.");
        logger.write("File writer is utilized.");

        logger.close();

        logger.setFileName("modified2.txt");
        logger.write("No text valuable.");
        logger.close();
    }
}
