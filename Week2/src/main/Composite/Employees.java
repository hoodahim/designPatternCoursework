public class Employees extends Units{

    String name;
    double salary;

    public Employees(String name, double salary){
        this.name = name;
        this.salary = salary;
    }

    @Override
    public void removeUnit(Units unit) {

    }

    @Override
    public void addUnit(Units unit) {

    }

    @Override
    public double getSalary(){
        return salary;
    }

    @Override
    public void print(){
        System.out.println("Employee name: " + name + ", Salary: " + salary);
    }

    public void printXML() {
        System.out.println("<Employee><Name>" + name + "</Name><Salary>" + salary + "</Salary></Employee>");
    }
}
