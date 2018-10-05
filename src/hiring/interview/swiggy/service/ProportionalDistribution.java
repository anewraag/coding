package hiring.interview.swiggy.service;

import hiring.interview.swiggy.domain.Employee;
import hiring.interview.swiggy.tool.BonusDistribution;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by asaxena on 9/22/2018.
 */
public class ProportionalDistribution implements BonusDistribution {
    @Override
    public void distribute(Employee emp, Double totalBonus) {

        Queue<Employee> empQueue = new LinkedList<Employee>();
        empQueue.add(emp);
        emp.setBonusReceived(totalBonus);

        while(!empQueue.isEmpty()){
            Employee employee = empQueue.poll();

            Integer totalRating=0;
            for (Employee temp : employee.getSubordinates()) { totalRating+=temp.getRating();}

            if(employee.getSubordinateCount()==0){
                // print DE bonus
                System.out.println(employee.toString());
            }
            // set bonus of subordinates
            for (Employee temp : employee.getSubordinates()) {
                temp.setBonusReceived((employee.getBonusReceived()*temp.getRating()/totalRating));
                empQueue.add(temp);
            }

        }

    }
}
