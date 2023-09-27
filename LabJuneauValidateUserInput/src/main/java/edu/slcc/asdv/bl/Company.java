package edu.slcc.asdv.bl;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASDV1
 */
public class Company implements EmployeeInterface
{
    private List<Employee> employeeList;
    public Company(){employeeList = new ArrayList<Employee>();  }
    @Override
    public boolean insertEmployee(Employee e){return employeeList.add( e ); }

    @Override
    public boolean removeEmployee(Employee e){throw new UnsupportedOperationException("Not supported yet."); }

    @Override
    public List<Employee> getEmployees(){return employeeList;}

}
