package edu.slcc.asdv.bl;

import java.io.Serializable;

public class Employee implements Serializable
{

    private String employeeFirst;
    private String employeeLast;
    private String employeeTitle;
    private String photo;



    public Employee(String first, 
            String last, String title, 
            String photo)
    {
        employeeFirst = first;
        employeeLast = last;
        employeeTitle = title;
        this.photo = photo;
    }

    public String getEmployeeFirst() { return employeeFirst; }

    public void setEmployeeFirst(String employeeFirst){ this.employeeFirst = employeeFirst;}

    public String getEmployeeLast(){return employeeLast;}

    public void setEmployeeLast(String employeeLast){this.employeeLast = employeeLast;}

    public String getEmployeeTitle(){return employeeTitle; }

    public void setEmployeeTitle(String employeeTitle){ this.employeeTitle = employeeTitle; }

    public String getPhoto(){return photo;}

    public void setPhoto(String photo){this.photo = photo;}

}
