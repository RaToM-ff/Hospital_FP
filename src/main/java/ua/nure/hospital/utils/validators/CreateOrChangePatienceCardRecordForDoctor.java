package ua.nure.hospital.utils.validators;

import org.apache.commons.lang3.StringUtils;
import ua.nure.hospital.constant.DBConstants;
import ua.nure.hospital.entity.PatienceCardRecord;

import java.util.HashMap;
import java.util.Map;

public class CreateOrChangePatienceCardRecordForDoctor {

    public static final String TEXT_REGEX = "^[A-Z\\u0430-\\u044F\\u0451]?[a-zA-Z0-9_\\-;.,\\u0430-\\u044F\\u0451\\u0410-\\u042F\\u0401 ]{0,254}$";
    public static final String INCORRECT_PROCEDURES = "Procedures entered incorrect!";
    public static final String INCORRECT_MEDICINES = "Medicines entered incorrect!";
    public static final String INCORRECT_OPERATIONS = "Operations entered incorrect!";
    public static final String INCORRECT_DIAGNOSIS = "Diagnosis entered incorrect!";
    public static final String EMPTY = "Please enter info in some of the field!";

    public static Map<String, String> validatePatienceCardRecord(PatienceCardRecord patienceCardRecord) {

        Map<String, String> errors = new HashMap<>();

        if (!(patienceCardRecord.getProcedures().matches(TEXT_REGEX))) {
            errors.put(DBConstants.FIELD_PATIENCE_CARD_RECORD_PROCEDURES, INCORRECT_PROCEDURES);
        }
        if (!(patienceCardRecord.getMedicines().matches(TEXT_REGEX))) {
            errors.put(DBConstants.FIELD_PATIENCE_CARD_RECORD_MEDICINES, INCORRECT_MEDICINES);
        }
        if (!(patienceCardRecord.getOperations().matches(TEXT_REGEX))) {
            errors.put(DBConstants.FIELD_PATIENCE_CARD_RECORD_OPERATIONS, INCORRECT_OPERATIONS);
        }
        if (!(patienceCardRecord.getDiagnosis().matches(TEXT_REGEX))) {
            errors.put(DBConstants.FIELD_PATIENCE_CARD_RECORD_DIAGNOSIS, INCORRECT_DIAGNOSIS);
        }

        if (StringUtils.isEmpty(patienceCardRecord.getProcedures())
                && StringUtils.isEmpty(patienceCardRecord.getMedicines())
                && StringUtils.isEmpty(patienceCardRecord.getOperations())
                && StringUtils.isEmpty(patienceCardRecord.getDiagnosis())) {
            errors.put(DBConstants.FIELD_PATIENCE_CARD_RECORD_PROCEDURES, EMPTY);
        }

        return errors;
    }
}
