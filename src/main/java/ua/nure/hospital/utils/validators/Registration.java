package ua.nure.hospital.utils.validators;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import ua.nure.hospital.constant.DBConstants;
import ua.nure.hospital.entity.User;

import java.util.HashMap;
import java.util.Map;

public class Registration {

    public static final String NAME_REGEX = "^[A-Z][a-z]{0,30}$";
    public static final String LOGIN_PASSWORD_REGEX = "^\\w{1,14}$";
    public static final String BIRTHDAY_REGEX = "^\\w{4}-\\w{2}-\\w{2}$";
    public static final String INCORRECT_NAME = "Name entered incorrect!";
    public static final String INCORRECT_SERNAME = "Sername entered incorrect!";
    public static final String INCORRECT_PATRONYMIC = "Patronymic entered incorrect!";
    public static final String INCORRECT_LOGIN = "Login entered incorrect!";
    public static final String INCORRECT_PASSWORD = "Password entered incorrect!";
    public static final String INCORRECT_BIRTHDAY = "Password entered incorrect!";
    public static final String EMPTY_FIRST_NAME = "Please enter name!";
    public static final String EMPTY_SERNAME = "Please enter sername!";
    public static final String EMPTY_PATRONYMIC = "Please enter patronymic!";
    public static final String EMPTY_LOGIN = "Please enter login!";
    public static final String EMPTY_PASSWORD = "Please enter password!";
    public static final String EMPTY_BIRTHDAY = "Password entered incorrect!";

    public static Map<String, String> validateRegistration(User user) {

        Map<String, String> errors = new HashMap<>();

        if (StringUtils.isNotEmpty(user.getName())) {
            if (!(user.getName().matches(NAME_REGEX))) {
                errors.put(DBConstants.FIELD_USER_NAME, INCORRECT_NAME);
            }
        } else {
            errors.put(DBConstants.FIELD_USER_NAME, EMPTY_FIRST_NAME);
        }

        if (StringUtils.isNotEmpty(user.getSername())) {
            if (!(user.getName().matches(NAME_REGEX))) {
                errors.put(DBConstants.FIELD_USER_SERNAME, INCORRECT_SERNAME);
            }
        } else {
            errors.put(DBConstants.FIELD_USER_SERNAME, EMPTY_SERNAME);
        }

        if (StringUtils.isNotEmpty(user.getPatronymic())) {
            if (!(user.getName().matches(NAME_REGEX))) {
                errors.put(DBConstants.FIELD_USER_PATRONYMIC, INCORRECT_PATRONYMIC);
            }
        } else {
            errors.put(DBConstants.FIELD_USER_PATRONYMIC, EMPTY_PATRONYMIC);
        }

        if (StringUtils.isNotEmpty(user.getLogin())) {
            if (!(user.getName().matches(LOGIN_PASSWORD_REGEX))) {
                errors.put(DBConstants.FIELD_USER_PATRONYMIC, INCORRECT_LOGIN);
            }
        } else {
            errors.put(DBConstants.FIELD_USER_PATRONYMIC, EMPTY_LOGIN);
        }

        if (StringUtils.isNotEmpty(user.getPassword())) {
            if (!(user.getName().matches(LOGIN_PASSWORD_REGEX))) {
                errors.put(DBConstants.FIELD_USER_PATRONYMIC, INCORRECT_PASSWORD);
            }
        } else {
            errors.put(DBConstants.FIELD_USER_PATRONYMIC, EMPTY_PASSWORD);
        }

        if (StringUtils.isNotEmpty(user.getBirthday().toString())) {
            if (!(user.getName().matches(BIRTHDAY_REGEX))) {
                errors.put(DBConstants.FIELD_USER_BIRTHDAY, INCORRECT_BIRTHDAY);
            }
        } else {
            errors.put(DBConstants.FIELD_USER_BIRTHDAY, EMPTY_BIRTHDAY);
        }

        return errors;
    }
}
