package nss.mvc.controllers;

import nss.helpers.DataCache;
import nss.mvc.constants.MVCConstants;
import nss.mvc.forms.AddNumberForm;
import nss.mvc.validators.DuplicateValuesValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
public class HomeController {

    @Autowired
    private DataCache dataCache;
    @Autowired
    private DuplicateValuesValidator duplicateValuesValidator;

    @RequestMapping("/")
    public String goToHomePage(Map<String, Object> map) {
        map.put(MVCConstants.ADD_NUMBER_FORM, new AddNumberForm());
        map.put(MVCConstants.NUMBERS_LIST, dataCache.getStoredNumbers());
        return "index";
    }

    @RequestMapping(value = "/add_number", method = RequestMethod.POST)
    public String addNumber(@ModelAttribute(MVCConstants.ADD_NUMBER_FORM) AddNumberForm addNumberForm,
                            Map<String, Object> map, BindingResult result) {
        duplicateValuesValidator.validate(addNumberForm, result);
        if (result.hasErrors()) {
            map.put(MVCConstants.NUMBERS_LIST, dataCache.getStoredNumbers());
            return "index";
        }
        dataCache.addNumberToDBAndCache(addNumberForm.getNumberValue());
        return "redirect:/";
    }
}
