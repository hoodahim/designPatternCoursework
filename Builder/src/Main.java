public class Main {
    public static void main(String[] args){
        ComputerBuilder builder = new GamingComputer();
        Director director = new Director(builder);
        director.constructComputer();
        Computer computer = builder.getComputer();
        System.out.println(computer);
    }
}
