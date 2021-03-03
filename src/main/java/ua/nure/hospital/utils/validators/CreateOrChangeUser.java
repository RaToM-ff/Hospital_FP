package ua.nure.hospital.utils.validators;

import org.apache.commons.lang3.StringUtils;
import ua.nure.hospital.constant.DBConstants;
import ua.nure.hospital.entity.User;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CreateOrChangeUser {

    public static final String NAME_REGEX = "^[A-Z\\u0410-\\u042F\\u0401][a-z\\-\\u0430-\\u044F\\u0451 ]{0,29}$";
    public static final String LOGIN_PASSWORD_REGEX = "^\\w{1,14}$";
    public static final String BIRTHDAY_REGEX = "^(\\w{4})-(\\w{2})-(\\w{2})$";
    public static final String INCORRECT_NAME = "ERROR_INCORRECT_NAME";
    public static final String INCORRECT_SERNAME = "ERROR_INCORRECT_SERNAME";
    public static final String INCORRECT_PATRONYMIC = "ERROR_INCORRECT_PATRONYMIC";
    public static final String INCORRECT_LOGIN = "ERROR_INCORRECT_LOGIN";
    public static final String INCORRECT_PASSWORD = "ERROR_INCORRECT_PASSWORD";
    public static final String INCORRECT_BIRTHDAY = "ERROR_INCORRECT_BIRTHDAY";
    public static final String EMPTY_FIRST_NAME = "ERROR_EMPTY_FIRST_NAME";
    public static final String EMPTY_SERNAME = "ERROR_EMPTY_SERNAME";
    public static final String EMPTY_PATRONYMIC = "ERROR_EMPTY_PATRONYMIC";
    public static final String EMPTY_LOGIN = "ERROR_EMPTY_LOGIN";
    public static final String EMPTY_PASSWORD = "ERROR_EMPTY_PASSWORD";
    public static final String EMPTY_BIRTHDAY = "ERROR_EMPTY_BIRTHDAY";

    public static Map<String, String> validateRegistration(User user, boolean passwordCheck) {

        Map<String, String> errors = new HashMap<>();

        if (StringUtils.isNotEmpty(user.getName())) {
            if (!(user.getName().matches(NAME_REGEX))) {
                errors.put(DBConstants.FIELD_USER_NAME, INCORRECT_NAME);
            }
        } else {
            errors.put(DBConstants.FIELD_USER_NAME, EMPTY_FIRST_NAME);
        }

        if (StringUtils.isNotEmpty(user.getSername())) {
            if (!(user.getSername().matches(NAME_REGEX))) {
                errors.put(DBConstants.FIELD_USER_SERNAME, INCORRECT_SERNAME);
            }
        } else {
            errors.put(DBConstants.FIELD_USER_SERNAME, EMPTY_SERNAME);
        }

        if (StringUtils.isNotEmpty(user.getPatronymic())) {
            if (!(user.getPatronymic().matches(NAME_REGEX))) {
                errors.put(DBConstants.FIELD_USER_PATRONYMIC, INCORRECT_PATRONYMIC);
            }
        } else {
            errors.put(DBConstants.FIELD_USER_PATRONYMIC, EMPTY_PATRONYMIC);
        }

        if (StringUtils.isNotEmpty(user.getLogin())) {
            if (!(user.getLogin().matches(LOGIN_PASSWORD_REGEX))) {
                errors.put(DBConstants.FIELD_USER_LOGIN, INCORRECT_LOGIN);
            }
        } else {
            errors.put(DBConstants.FIELD_USER_LOGIN, EMPTY_LOGIN);
        }

        if (passwordCheck) {
            if (StringUtils.isNotEmpty(user.getPassword())) {
                if (!(user.getPassword().matches(LOGIN_PASSWORD_REGEX))) {
                    errors.put(DBConstants.FIELD_USER_PASSWORD, INCORRECT_PASSWORD);
                }
            } else {
                errors.put(DBConstants.FIELD_USER_PASSWORD, EMPTY_PASSWORD);
            }
        }

        String dateForCheck = (new java.sql.Date(user.getBirthday().getTime())).toString();
        if (StringUtils.isNotEmpty(dateForCheck)) {
            Pattern r = Pattern.compile(BIRTHDAY_REGEX);
            Matcher m = r.matcher(dateForCheck);
            if (m.find()) {
                int year = Integer.parseInt(m.group(1));
                int month = Integer.parseInt(m.group(2));
                int day = Integer.parseInt(m.group(3));
                if (year > 1900 && month > 12 && day > 31) {
                    errors.put(DBConstants.FIELD_USER_BIRTHDAY, INCORRECT_BIRTHDAY);
                }
            } else {
                errors.put(DBConstants.FIELD_USER_BIRTHDAY, INCORRECT_BIRTHDAY);
            }
        } else {
            errors.put(DBConstants.FIELD_USER_BIRTHDAY, EMPTY_BIRTHDAY);
        }

        return errors;
    }
}
