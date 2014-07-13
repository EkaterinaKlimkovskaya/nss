package nss.mvc.validators;

import nss.helpers.DataCache;
import nss.mvc.constants.MVCConstants;
import nss.mvc.forms.AddNumberForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class DuplicateValuesValidator implements Validator {

    @Autowired
    private DataCache dataCache;

    private String errorMessage = "This value has already existed!";

    @Override
    public boolean supports(Class<?> aClass) {
        return AddNumberForm.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        if (dataCache.getStoredNumbers() != null && dataCache.getStoredNumbers().contains(((AddNumberForm) o).getNumberValue())) {
            errors.rejectValue(MVCConstants.NUMBER_VALUE, MVCConstants.NUMBER_VALUE_NOT_VALID, errorMessage);
        }
    }
}
