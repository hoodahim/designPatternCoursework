public class Timer extends Thread{

//    int clock=1;
    @Override
    public void run() {
        for (int i=0;i<5;i++){
//            System.out.println("Timer: " + clock);
//            clock++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
            }
        }
    }
}
