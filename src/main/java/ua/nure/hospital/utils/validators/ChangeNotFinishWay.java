package ua.nure.hospital.utils.validators;

import org.apache.commons.lang3.StringUtils;
import ua.nure.hospital.constant.DBConstants;
import ua.nure.hospital.entity.PatienceCardRecord;
import ua.nure.hospital.entity.PatienceWay;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChangeNotFinishWay {

    public static final String BIRTHDAY_REGEX = "^(\\w{4})-(\\w{2})-(\\w{2})$";
    public static final String INCORRECT_DATE_COME = "ERROR_INCORRECT_DATE_COME";
    public static final String EMPTY_DATE_COME = "ERROR_EMPTY_DATE_COME";

    public static Map<String, String> validateWay(PatienceWay patienceWay) {

        Map<String, String> errors = new HashMap<>();


        String dateForCheck = (new java.sql.Date(patienceWay.getDate_come().getTime())).toString();
        if (StringUtils.isNotEmpty(dateForCheck)) {
            Pattern r = Pattern.compile(BIRTHDAY_REGEX);
            Matcher m = r.matcher(dateForCheck);
            if (m.find()) {
                int year = Integer.parseInt(m.group(1));
                int month = Integer.parseInt(m.group(2));
                int day = Integer.parseInt(m.group(3));
                if (year > 1900 && month > 12 && day > 31) {
                    errors.put(DBConstants.FIELD_PATIENCE_WAY_DATE_COME, INCORRECT_DATE_COME);
                }
            } else {
                errors.put(DBConstants.FIELD_PATIENCE_WAY_DATE_COME, INCORRECT_DATE_COME);
            }
        } else {
            errors.put(DBConstants.FIELD_PATIENCE_WAY_DATE_COME, EMPTY_DATE_COME);
        }

        return errors;
    }
}
