import java.util.ArrayList;
import java.util.List;

public class Departments extends Units {

    String name;
    List <Units> structure;
    double totalSalary = 0;

    public Departments(String name){
        this.name = name;
        structure = new ArrayList<>();
    }


    @Override
    public void removeUnit(Units unit) {
        structure.remove(unit);
    }

    @Override
    public void addUnit(Units unit) {
        structure.add(unit);
    }

    @Override
    public double getSalary(){
        for(Units unit:structure){
            if(unit instanceof Departments){
                totalSalary += unit.getSalary();
            } else if (unit instanceof Employees) {
                totalSalary += unit.getSalary();
            }
        }
        return totalSalary;
    }

    @Override
    public void print(){
        System.out.println("Department name: " + name);
        for(Units unit:structure){
            unit.print();
        }
    }

    @Override
    public void printXML() {
        System.out.println("<Department><Name>" + name + "</Name>");
        for(Units unit:structure){
            unit.printXML();
        }
        System.out.println("</Department>");
    }


}
