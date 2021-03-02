package ua.nure.hospital.utils.validators;

import org.apache.commons.lang3.StringUtils;
import ua.nure.hospital.constant.DBConstants;
import ua.nure.hospital.entity.PatienceCardRecord;

import java.util.HashMap;
import java.util.Map;

public class CreateOrChangePatienceCardRecordForNurse {

    public static final String TEXT_REGEX = "^[a-zA-Z0-9_., ]{0,255}$";
    public static final String INCORRECT_PROCEDURES = "Procedures entered incorrect!";
    public static final String INCORRECT_MEDICINES = "Medicines entered incorrect!";
    public static final String EMPTY = "Please enter info in some of the field!";

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