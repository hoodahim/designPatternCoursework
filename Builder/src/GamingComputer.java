public class GamingComputer implements ComputerBuilder{

    private Computer computer;

    public GamingComputer() {
        this.computer = new Computer();
    }

    @Override
    public void buildProcessor() {
        computer.addComponent(new Component("Intel i11"));
    }
    @Override
    public void buildRAM() {
        computer.addComponent(new Component("32 GB DDR5"));
    }

    @Override
    public void buildHardDrive() {
        computer.addComponent(new Component("1TB SSD"));
    }

    @Override
    public void buildGraphicCard() {
        computer.addComponent(new Component("Nvidia RTX 4090"));
    }

    @Override
    public void buildOperatingSystem() {
        computer.addComponent(new Component("Windows 11 pro"));
    }

    @Override
    public Computer getComputer() {
        return computer;
    }
}
