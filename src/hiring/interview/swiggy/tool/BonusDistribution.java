package hiring.interview.swiggy.tool;

import hiring.interview.swiggy.domain.Employee;

/**
 * Created by asaxena on 9/22/2018.
 */
public interface BonusDistribution {

    public void distribute(Employee employee, Double totalBonus);
}
