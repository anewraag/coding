package hiring.interview.swiggy.service;

import hiring.interview.swiggy.domain.Employee;
import hiring.interview.swiggy.tool.BonusDistribution;

import java.util.Date;

/**
 * Created by asaxena on 9/22/2018.
 */
public class BonusDistributionService {
    BonusDistribution bonusDistribution;
    Date startDate;
    Date endDate;

    public BonusDistribution getBonusDistribution() {
        return bonusDistribution;
    }

    public void setBonusDistribution(BonusDistribution bonusDistribution) {
        this.bonusDistribution = bonusDistribution;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void distributeBonus(Employee employee, Double totalBonus){
        bonusDistribution.distribute(employee,totalBonus);
    }
}
