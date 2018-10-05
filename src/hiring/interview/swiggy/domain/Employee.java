package hiring.interview.swiggy.domain;

import hiring.interview.swiggy.tool.EmployeePosition;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asaxena on 9/22/2018.
 */
public class Employee {
    Long id;
    String name;
    Double salary;
    Double bonusReceived;
    Integer rating;
    EmployeePosition position;
    String city;

    Employee manager;
    List<Employee> subordinates;
    Integer subordinateCount;

    public Employee(Long id, String name, Double salary, Integer rating, EmployeePosition position, String city) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.rating = rating;
        this.position = position;
        this.city = city;
        subordinates = new ArrayList<Employee>();
        subordinateCount=0;
        manager=null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Double getBonusReceived() {
        return bonusReceived;
    }

    public void setBonusReceived(Double bonusReceived) {
        this.bonusReceived = bonusReceived;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public EmployeePosition getPosition() {
        return position;
    }

    public void setPosition(EmployeePosition position) {
        this.position = position;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public List<Employee> getSubordinates() {
        return subordinates;
    }

    public void setSubordinates(List<Employee> subordinates) {
        this.subordinates = subordinates;
        subordinateCount=subordinates.size();
    }

    public void addSubordinates(Employee subordinate){
        if(subordinate.position == EmployeePosition.DE && subordinate.manager!=null) {
            System.out.println("DE can not be assigned to multiple FM");
            return;
            //throw new Exception("DE can not be assigned to multiple FM");
        }
        subordinate.manager = this;
        subordinates.add(subordinate);
        subordinateCount++;
    }

    public void removeSubordinate(Employee subordinate){
        subordinate.manager=null;
        subordinates.remove(subordinate);
        subordinateCount--;
    }

    public Integer getSubordinateCount() {
        return subordinateCount;
    }

    public void setSubordinateCount(Integer subordinateCount) {
        this.subordinateCount = subordinateCount;
    }

    public String toString() {
        return (this.id +", " + this.name + ", " + this.position +", "+ this.bonusReceived + ", " + this.salary + ", " + this.rating
                + ", " + this.city);
    }
}
