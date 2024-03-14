import java.util.Random;

public class ArrayGenerator {

    Random random = new Random();

    int[] arr30 = new int[30];
    int[] arr100k = new int[100000];


    public int[] getArr30() {
        for(int i=0; i<arr30.length; i++){
            arr30[i] = random.nextInt(30);
        }
        return arr30;
    }

    public int[] getArr100k() {
        for(int i=0; i<arr100k.length;i++){
            arr100k[i] = random.nextInt(100000);
        }
        return arr100k;
    }
}
