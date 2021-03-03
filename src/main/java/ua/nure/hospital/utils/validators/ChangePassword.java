package ua.nure.hospital.utils.validators;

import org.apache.commons.lang3.StringUtils;
import ua.nure.hospital.constant.DBConstants;

import java.util.HashMap;
import java.util.Map;

public class ChangePassword {

    public static final String LOGIN_PASSWORD_REGEX = "^\\w{1,14}$";
    public static final String INCORRECT_PASSWORD = "ERROR_INCORRECT_PASSWORD";
    public static final String INCORRECT_NEW_PASSWORD = "ERROR_INCORRECT_NEW_PASSWORD";
    public static final String EMPTY_PASSWORD = "ERROR_EMPTY_PASSWORD";
    public static final String EMPTY_NEW_PASSWORD = "ERROR_EMPTY_NEW_PASSWORD";
    public static final String PASSWORD_NOT_EQUALS = "ERROR_PASSWORD_NOT_EQUALS";

    public static Map<String, String> validatePassword(String oldPassword, String newPassword, String newPassword2) {

        Map<String, String> errors = new HashMap<>();


        if (StringUtils.isNotEmpty(oldPassword)) {
            if (!(oldPassword.matches(LOGIN_PASSWORD_REGEX))) {
                errors.put("oldPassword", INCORRECT_PASSWORD);
            }
        } else {
            errors.put("oldPassword", EMPTY_PASSWORD);
        }

        if (StringUtils.isNotEmpty(newPassword)) {
            if (!(newPassword.matches(LOGIN_PASSWORD_REGEX))) {
                errors.put("newPassword1", INCORRECT_NEW_PASSWORD);
            }
        } else {
            errors.put("newPassword1", EMPTY_NEW_PASSWORD);
        }

        if (!newPassword.equals(newPassword2)) {
            errors.put("newPassword2", PASSWORD_NOT_EQUALS);
        }

        return errors;
    }
}
