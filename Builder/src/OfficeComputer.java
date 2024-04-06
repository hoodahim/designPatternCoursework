public class OfficeComputer implements ComputerBuilder{
    private Computer computer;

    public OfficeComputer(){
        this.computer = new Computer();
    }

    @Override
    public void buildProcessor() {
        computer.addComponent(new Component("Intel i3"));
    }

    @Override
    public void buildRAM() {
        computer.addComponent(new Component("8GB DDR4"));
    }

    @Override
    public void buildHardDrive() {
        computer.addComponent(new Component("256GB HDD"));
    }

    @Override
    public void buildGraphicCard() {
        computer.addComponent(new Component("intel inBuilt"));
    }

    @Override
    public void buildOperatingSystem() {
        computer.addComponent(new Component("Window 11 Home"));
    }

    @Override
    public Computer getComputer() {
        return computer;
    }
}
