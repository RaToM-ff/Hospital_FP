package ua.nure.hospital.utils.validators;

import org.apache.commons.lang3.StringUtils;
import ua.nure.hospital.constant.DBConstants;

import java.util.HashMap;
import java.util.Map;

public class Login {

    public static final String LOGIN_PASSWORD_REGEX = "^\\w{1,14}$";
    public static final String INCORRECT_LOGIN = "ERROR_INCORRECT_LOGIN";
    public static final String EMPTY_LOGIN = "ERROR_EMPTY_LOGIN";
    public static final String INCORRECT_PASSWORD = "ERROR_INCORRECT_PASSWORD";
    public static final String EMPTY_PASSWORD = "ERROR_EMPTY_PASSWORD";

    public static Map<String, String> validateLogin(String login, String password) {

        Map<String, String> errors = new HashMap<>();


        if (StringUtils.isNotEmpty(login)) {
            if (!(login.matches(LOGIN_PASSWORD_REGEX))) {
                errors.put(DBConstants.FIELD_USER_LOGIN, INCORRECT_LOGIN);
            }
        } else {
            errors.put(DBConstants.FIELD_USER_LOGIN, EMPTY_LOGIN);
        }

        if (StringUtils.isNotEmpty(password)) {
            if (!(password.matches(LOGIN_PASSWORD_REGEX))) {
                errors.put(DBConstants.FIELD_USER_PASSWORD, INCORRECT_PASSWORD);
            }
        } else {
            errors.put(DBConstants.FIELD_USER_PASSWORD, EMPTY_PASSWORD);
        }

        return errors;
    }
}
