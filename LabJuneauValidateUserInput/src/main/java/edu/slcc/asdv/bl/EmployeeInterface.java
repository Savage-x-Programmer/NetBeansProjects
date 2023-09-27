
package edu.slcc.asdv.bl;

import java.util.List;

/**
 *
 * @author ASDV1
 */
public interface EmployeeInterface
{
/**Inserts a new employee in thr list
 * 
 * @param e the employee to be inserted.
 * @return true if inserted successfully, false otherwise.
 */
    boolean insertEmployee(Employee e);
    
    /** Removes an employee from the list.
     * 
     * @param e the employee to be removed
     * @return true if the employee was successfully removed, false otherwise.
     */
    boolean removeEmployee(Employee e);
    
    /** Gets all employees in the list.
     * 
     * @return list of employees.
     */
    List<Employee> getEmployees();
    
}
