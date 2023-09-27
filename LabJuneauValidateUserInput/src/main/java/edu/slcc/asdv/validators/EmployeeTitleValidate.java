package edu.slcc.asdv.validators;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.FacesValidator;
import jakarta.faces.validator.Validator;
import jakarta.faces.validator.ValidatorException;

@FacesValidator("employeeTitleValidate")
public class EmployeeTitleValidate implements Validator
{

    @Override
    public void validate(FacesContext fc, UIComponent uic, Object t) 
            throws ValidatorException
    {
        checkTitle(t);
    }

    private void checkTitle(Object value)
    {
        String title = value.toString();
        title = title.toLowerCase();
        if (!title.contains("java"))
        {
            String messageText = "Title does not include the word Java";
            String messageTextLong = "Title does not include the word Java. "
                                         + "Please type java";
            throw new ValidatorException(
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    messageText, messageTextLong));
        }
    }

}
