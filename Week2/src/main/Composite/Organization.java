public class Organization {

    public static void main(String[] args){
        Departments engineering = new Departments("Mechanical");
        Employees emp1 = new Employees("Adam", 5000);
        Employees emp2 = new Employees("Mary", 7500);
        Employees emp3 = new Employees("Tom", 3500);

        Departments designers = new Departments("Designers");

        Departments admins = new Departments("Administration");

        Units organization = new Departments("ABC ltd.");

        organization.addUnit(engineering);
        organization.addUnit(admins);
        admins.addUnit(emp2);
        engineering.addUnit(designers);
        designers.addUnit(emp1);
        designers.addUnit(emp3);


        System.out.println("Organization's total salary: " + organization.getSalary());

        organization.print();


    }


}
