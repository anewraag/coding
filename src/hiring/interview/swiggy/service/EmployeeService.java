package hiring.interview.swiggy.service;

import hiring.interview.swiggy.domain.Employee;
import hiring.interview.swiggy.tool.EmployeePosition;

import java.util.*;

/**
 * Created by asaxena on 9/22/2018.
 */
public class EmployeeService {

    List<Employee> employees;
    BonusDistributionService bonusDistributionService;

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public BonusDistributionService getBonusDistributionService() {
        return bonusDistributionService;
    }

    public void setBonusDistribution(BonusDistributionService bonusDistributionService) {
        this.bonusDistributionService = bonusDistributionService;
    }

    public void printHierarchy(Employee employee){
        System.out.println("Printing employee hierarchy");
        Queue<Employee> empQueue = new LinkedList<Employee>();
        empQueue.add(employee);
        while(!empQueue.isEmpty()){
            Employee emp = empQueue.poll();
            System.out.println(emp.toString());
            for(Employee temp: emp.getSubordinates()){
                empQueue.add(temp);
            }
        }
    }

    public void distributeBonus(String city, Double totalBonus){
        // get CM for the passed city
        Employee CM = findCM(city);
        bonusDistributionService.distributeBonus(CM, totalBonus);
    }

    public List<Employee> printTopEmployees(EmployeePosition position){
        List<Employee> employeeList = new ArrayList<Employee>();

        Queue<Employee> empQueue = new LinkedList<Employee>();
        empQueue.add(employees.get(0));
        while(!empQueue.isEmpty()){
            Employee emp = empQueue.poll();
            if(emp.getPosition()== position)
                employeeList.add(emp);
            else {
                for (Employee temp : emp.getSubordinates()) {
                    empQueue.add(temp);
                }
            }
        }
        // sort the employeeList
        Collections.sort(employeeList, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return Double.compare(o2.getBonusReceived()/o2.getSalary(),o1.getBonusReceived()/o1.getSalary());
            }
        });
        return employeeList;
    }

    public Employee findCM(String city){
        Queue<Employee> empQueue = new LinkedList<Employee>();
        empQueue.add(employees.get(0));
        while(!empQueue.isEmpty()){
            Employee emp = empQueue.poll();
            if(emp.getCity()==city && emp.getPosition()== EmployeePosition.CM)
                return emp;
            else {
                for (Employee temp : emp.getSubordinates()) {
                    empQueue.add(temp);
                }
            }
        }
        return null;
    }
}
