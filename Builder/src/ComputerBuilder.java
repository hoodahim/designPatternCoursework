public interface ComputerBuilder {
    void buildProcessor();
    void buildRAM();
    void buildHardDrive();
    void buildGraphicCard();
    void buildOperatingSystem();
    Computer getComputer();
}
