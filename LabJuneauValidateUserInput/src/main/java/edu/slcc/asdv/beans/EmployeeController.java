package edu.slcc.asdv.beans;

import edu.slcc.asdv.bl.Company;
import edu.slcc.asdv.bl.Employee;
import edu.slcc.asdv.bl.EmployeeInterface;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import java.io.Serializable;


@Named(value = "employeeController")
@SessionScoped
public class EmployeeController implements Serializable
{

    private String employeeFirst;
    private String employeeLast;
    private String employeeTitle;

    private EmployeeInterface company;//placeholder
    
    public EmployeeController() { company = new Company(); }
    
    public EmployeeInterface getCompany(){ return this.company ;}
    
    public String getEmployeeFirst(){return employeeFirst;}
    public void setEmployeeFirst(String employeeFirst){ this.employeeFirst = employeeFirst; }
    public String getEmployeeLast(){return employeeLast;}
    public void setEmployeeLast(String employeeLast){ this.employeeLast = employeeLast; }
    public String getEmployeeTitle(){return employeeTitle;}
    public void setEmployeeTitle(String employeeTitle){ this.employeeTitle = employeeTitle;}
    public void insert()
    {
        boolean b = company.insertEmployee(
                new Employee(
                        this.employeeFirst, //from textbox
                        this.getEmployeeLast(), //from textbox
                        this.employeeTitle, "1.png"));
        FacesMessage facesMsg = null;
        if (b)
        {
            facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Employee Successfully Added", null);
            this.employeeFirst = "";//reset text boxes too
            this.employeeLast = "";
            this.employeeTitle = "";
        }
        else
            facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Employee Not Added", null);   
        FacesContext.getCurrentInstance().addMessage(null, facesMsg);
    }
}
