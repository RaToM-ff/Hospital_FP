package ua.nure.hospital.utils.validators;

import org.apache.commons.lang3.StringUtils;
import ua.nure.hospital.constant.DBConstants;
import ua.nure.hospital.entity.PatienceCardRecord;

import java.util.HashMap;
import java.util.Map;

public class CreateOrChangePatienceCardRecordForNurse {

    public static final String TEXT_REGEX = "^[A-Z\\u0410-\\u042F\\u0401]?[a-zA-Z0-9_\\-;.,\\u0430-\\u044F\\u0451\\u0410-\\u042F\\u0401 ]{0,254}$";
    public static final String INCORRECT_PROCEDURES = "ERROR_INCORRECT_PROCEDURES";
    public static final String INCORRECT_MEDICINES = "ERROR_INCORRECT_MEDICINES";
    public static final String EMPTY = "ERROR_EMPTY";

    public static Map<String, String> validatePatienceCardRecord(PatienceCardRecord patienceCardRecord) {

        Map<String, String> errors = new HashMap<>();

        if (!(patienceCardRecord.getDiagnosis().matches(TEXT_REGEX))) {
            errors.put(DBConstants.FIELD_PATIENCE_CARD_RECORD_PROCEDURES, INCORRECT_PROCEDURES);
        }
        if (!(patienceCardRecord.getDiagnosis().matches(TEXT_REGEX))) {
            errors.put(DBConstants.FIELD_PATIENCE_CARD_RECORD_MEDICINES, INCORRECT_MEDICINES);
        }

        if (StringUtils.isEmpty(patienceCardRecord.getProcedures())
                && StringUtils.isEmpty(patienceCardRecord.getMedicines())) {
            errors.put(DBConstants.FIELD_PATIENCE_CARD_RECORD_PROCEDURES, EMPTY);
        }

        return errors;
    }
}
