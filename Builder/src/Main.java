public class Main {
    public static void main(String[] args){
        ComputerBuilder builder = new GamingComputer();
        Director director = new Director(builder);
        director.constructComputer();
        Computer computer = builder.getComputer();
        System.out.println(computer);

        ComputerBuilder builder1 = new OfficeComputer();
        new Director(builder1).constructComputer();
        Computer computer1 = builder1.getComputer();
        System.out.println(computer1);
    }
}
