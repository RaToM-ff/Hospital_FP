package ua.nure.hospital.utils.validators;

import org.apache.commons.lang3.StringUtils;
import ua.nure.hospital.constant.DBConstants;
import ua.nure.hospital.entity.Work;

import java.util.HashMap;
import java.util.Map;

public class CreateOrChangeWork {
    public static final String NAME_REGEX = "^[A-Z\\u0410-\\u042F\\u0401][a-z\\-\\u0430-\\u044F\\u0451 ]{0,29}$";
    public static final String INCORRECT_WORK = "ERROR_INCORRECT_WORK";
    public static final String EMPTY_WORK = "ERROR_EMPTY_WORK";


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
