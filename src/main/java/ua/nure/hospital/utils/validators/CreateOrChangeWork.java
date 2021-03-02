package ua.nure.hospital.utils.validators;

import org.apache.commons.lang3.StringUtils;
import ua.nure.hospital.constant.DBConstants;
import ua.nure.hospital.entity.Work;

import java.util.HashMap;
import java.util.Map;

public class CreateOrChangeWork {
    public static final String NAME_REGEX = "^[A-Z][a-z ]{0,29}$";
    public static final String INCORRECT_WORK = "Work entered incorrect!";
    public static final String EMPTY_WORK = "Please enter work!";


    public static Map<String, String> validateWork(Work work) {

        Map<String, String> errors = new HashMap<>();

        if (StringUtils.isNotEmpty(work.getName())) {
            if (!(work.getName().matches(NAME_REGEX))) {
                errors.put(DBConstants.FIELD_WORK_NAME, INCORRECT_WORK);
            }
        } else {
            errors.put(DBConstants.FIELD_WORK_NAME, EMPTY_WORK);
        }

        return errors;
    }
}
