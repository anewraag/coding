package hiring.interview.swiggy.util;

import hiring.interview.swiggy.domain.Employee;
import hiring.interview.swiggy.service.EmployeeService;
import hiring.interview.swiggy.service.ProportionalDistribution;
import hiring.interview.swiggy.service.BonusDistributionService;
import hiring.interview.swiggy.tool.EmployeePosition;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asaxena on 9/22/2018.
 */
public class SwiggyAssignment {
    static EmployeeService employeeService = new EmployeeService();

    public static void main(String[] args) {
        // Enter employee hierarchy
        Employee e1 = new Employee(1L,"A",10000.0,4, EmployeePosition.CM,"Bangalore");

        Employee e2 = new Employee(2L,"B",10000.0,4, EmployeePosition.FM,"Bangalore");
        Employee e3 = new Employee(4L,"D",10000.0,4, EmployeePosition.DE,"Bangalore");
        Employee e4 = new Employee(5L,"E",10000.0,4, EmployeePosition.DE,"Bangalore");
        e2.addSubordinates(e3);
        e2.addSubordinates(e4);
        e1.addSubordinates(e2);

        Employee e5 = new Employee(3L,"C",10000.0,5, EmployeePosition.FM,"Bangalore");
        e5.addSubordinates(new Employee(6L,"F",10000.0,3, EmployeePosition.DE,"Bangalore"));
        e5.addSubordinates(new Employee(7L,"G",10000.0,3, EmployeePosition.DE,"Bangalore"));
        e5.addSubordinates(new Employee(8L,"H",10000.0,4, EmployeePosition.DE,"Bangalore"));
        e1.addSubordinates(e5);

        // trying to add same DE to multiple
        //e5.addSubordinates(e3);

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(e1);

        // Printing employee hierarchy
        employeeService.printHierarchy(e5);

        // Setting bonus distribution algorithm
        BonusDistributionService bonusDistributionService = new BonusDistributionService();
        bonusDistributionService.setBonusDistribution(new ProportionalDistribution());
        employeeService.setBonusDistribution(bonusDistributionService);
        employeeService.setEmployees(employeeList);

        // Printing bonus distribution
        System.out.println("\nPrinting DE Bonus");
        employeeService.distributeBonus("Bangalore",900.0);

        // Printing top DEs
        System.out.println("\nPrinting Top DEs");
        List<Employee> sortedList = employeeService.printTopEmployees(EmployeePosition.DE);
        for(Employee emp : sortedList){
            System.out.println(emp.toString());
        }
    }
}
