import java.util.LinkedList;
public class EmployeeWageBuilder implements IComputeEmpWage {

        public static final int IS_PART_TIME=1;
        public static final int IS_FULL_TIME=2;

        private int numOfCompany=0;
        private LinkedList<CompanyEmpWage> companyEmpWageList;


        public EmployeeWageBuilder()
        {
                companyEmpWageList=new LinkedList<>();
        }

        private void addCompanyEmpWage(String company,int empRatePerHour,int numOfWorkingDays,int maxHoursPerMonth)
        {
                CompanyEmpWage companyEmpWage=new CompanyEmpWage(company, empRatePerHour, numOfWorkingDays, maxHoursPerMonth);
                companyEmpWageList.add(companyEmpWage);
        }

        private void computeEmpWage()
        {
                for (int i = 0; i < companyEmpWageList.size(); i++)
                {
			CompanyEmpWage compantEmpWage=companyEmpWage.get(i);
                        companyEmpWage.setTotalEmpWage(this.computeEmpWage(companyEmpWage));
                        System.out.println(companyEmpWage);
                }
        }

	
        private int computeEmpWage(CompanyEmpWage companyEmpWage)
        {
        int empHrs=0,totalEmpHrs=0,totalWorkingDays=0;

        while(totalEmpHrs<=companyEmpWage.maxHoursPerMonth && totalWorkingDays<companyEmpWage.numOfWorkingDays)
        {
                totalWorkingDays++;

                int empCheck=(int) Math.floor(Math.random() * 10)%3;


                switch(empCheck)
                {
                case IS_PART_TIME:
                        empHrs=4;
			 break;

                case IS_FULL_TIME:
                        empHrs=8;
                        break;
                default:
                        empHrs=0;
                }
                totalEmpHrs+=empHrs;
                System.out.println("day: "+totalWorkingDays + "EmpHrs: "+empHrs);
                }

        return totalEmpHrs * companyEmpWage.empRatePerHour;
        }


        public static void main(String[] args) {
                IComputeEmpWage empWageBuilder=new EmpWageBuilder();
                empWageBuilder.addCompanyEmpWage("Dmart", 20, 2, 10);
                empWageBuilder.addCompanyEmpWage("Reliance", 10, 4, 20);
                empWageBuilder.computeEmpWage();
		System.out.println("total wage for DMart Company: "+empWageBuilder.getTotalWage(company"DMart"));
        }
}
