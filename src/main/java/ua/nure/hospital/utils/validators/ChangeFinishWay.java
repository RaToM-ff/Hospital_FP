package ua.nure.hospital.utils.validators;

import org.apache.commons.lang3.StringUtils;
import ua.nure.hospital.constant.DBConstants;
import ua.nure.hospital.entity.PatienceWay;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChangeFinishWay {

    public static final String DATE_REGEX = "^(\\w{4})-(\\w{2})-(\\w{2})$";
    private static final String DIAGNOSIS_REGEX = "^[A-Z\\u0410-\\u042F\\u0401][a-zA-Z0-9_\\-;:.,\\u0430-\\u044F\\u0451\\u0410-\\u042F\\u0401 ]{1,254}$";
    public static final String INCORRECT_DATE_OUT = "ERROR_INCORRECT_DATE_OUT";
    private static final String INCORRECT_DIAGNOSIS = "ERROR_INCORRECT_DIAGNOSIS";
    private static final String EMPTY_DATE_OUT = "ERROR_EMPTY_DATE_OUT";
    private static final String EMPTY_DIAGNOSIS = "ERROR_EMPTY_DIAGNOSIS";
    private static final String EMPTY_DOCUMENT_WAY = "ERROR_EMPTY_DOCUMENT_WAY";

    public static Map<String, String> validateWay(PatienceWay patienceWay, boolean doc) {

        Map<String, String> errors = new HashMap<>();

        String dateForCheck = (new java.sql.Date(patienceWay.getDate_out().getTime())).toString();
        if (StringUtils.isNotEmpty(dateForCheck)) {
            Pattern r = Pattern.compile(DATE_REGEX);
            Matcher m = r.matcher(dateForCheck);
            if (m.find()) {
                int year = Integer.parseInt(m.group(1));
                int month = Integer.parseInt(m.group(2));
                int day = Integer.parseInt(m.group(3));
                if (year > 1900 && month > 12 && day > 31) {
                    errors.put(DBConstants.FIELD_PATIENCE_WAY_DATE_OUT, INCORRECT_DATE_OUT);
                }
            } else {
                errors.put(DBConstants.FIELD_PATIENCE_WAY_DATE_OUT, INCORRECT_DATE_OUT);
            }
        } else {
            errors.put(DBConstants.FIELD_PATIENCE_WAY_DATE_OUT, EMPTY_DATE_OUT);
        }

        if (StringUtils.isNotEmpty(patienceWay.getDiagnosis())) {
            if (!(patienceWay.getDiagnosis().matches(DIAGNOSIS_REGEX))) {
                errors.put(DBConstants.FIELD_PATIENCE_WAY_DIAGNOSIS, INCORRECT_DIAGNOSIS);
            }
        } else {
            errors.put(DBConstants.FIELD_PATIENCE_WAY_DIAGNOSIS, EMPTY_DIAGNOSIS);
        }

        if (doc) {
            errors.put(DBConstants.FIELD_PATIENCE_WAY_DOCUMENT_WAY, EMPTY_DOCUMENT_WAY);
        }

        return errors;
    }
}
