package ua.nure.hospital.constant;

public class DBConstants {
    //users
    public static final String FIELD_USER_ID = "id";
    public static final String FIELD_USER_LOGIN = "login";
    public static final String FIELD_USER_PASSWORD = "password";
    public static final String FIELD_USER_STATUS_ID = "status_id";
    public static final String FIELD_USER_WORK_ID = "work_id";
    public static final String FIELD_USER_NAME = "name";
    public static final String FIELD_USER_SERNAME = "sername";
    public static final String FIELD_USER_PATRONYMIC = "patronymic";
    public static final String FIELD_USER_BIRTHDAY = "birthday";
    //status
    public static final String FIELD_STATUS_ID = "id";
    public static final String FIELD_STATUS_NAME = "status_name";
    //works
    public static final String FIELD_WORK_ID = "id";
    public static final String FIELD_WORK_NAME = "work_name";
    //patience_way
    public static final String FIELD_PATIENCE_WAY_ID = "id";
    public static final String FIELD_PATIENCE_WAY_DOCTOR_USER_ID = "doctor_user_id";
    public static final String FIELD_PATIENCE_WAY_PATIENCE_USER_ID = "patience_user_id";
    public static final String FIELD_PATIENCE_WAY_DIAGNOSIS = "diagnosis";
    public static final String FIELD_PATIENCE_WAY_DOCUMENT_WAY = "document_way";
    public static final String FIELD_PATIENCE_WAY_DATE_COME = "date_come";
    public static final String FIELD_PATIENCE_WAY_DATE_OUT = "date_out";
    //patience_card_record
    public static final String FIELD_PATIENCE_CARD_RECORD_ID = "id";
    public static final String FIELD_PATIENCE_CARD_RECORD_DOCTOR_USER_ID = "doctor_user_id";
    public static final String FIELD_PATIENCE_CARD_RECORD_PATIENCE_USER_ID = "patience_user_id";
    public static final String FIELD_PATIENCE_CARD_RECORD_PROCEDURES = "procedures";
    public static final String FIELD_PATIENCE_CARD_RECORD_MEDICINES = "medicines";
    public static final String FIELD_PATIENCE_CARD_RECORD_OPERATIONS = "operations";
    public static final String FIELD_PATIENCE_CARD_RECORD_DIAGNOSIS = "diagnosis";
    public static final String FIELD_PATIENCE_CARD_RECORD_DATE_OF_SET = "date_of_set";
    //users
    public static final String INSERT_USER = "INSERT INTO users(login,password,status_id,work_id,name,sername," +
            "patronymic,birthday) VALUES(?,?,?,?,?,?,?,?)";
    public static final String UPDATE_USER_ALL_NO_LOG_PASS = "UPDATE users SET status_id = ?, work_id = ?," +
            " name = ?, sername = ?, patronymic = ?, birthday = ? WHERE id = ?";
    public static final String UPDATE_USER_LOGIN = "UPDATE users SET login = ? WHERE id = ?";
    public static final String UPDATE_USER_PASSWORD = "UPDATE users SET password = ? WHERE id = ?";
    public static final String SELECT_USERS = "SELECT users.id,login,status_id,work_id,work_name,status_name,name,sername," +
            "patronymic,birthday FROM users INNER JOIN works ON users.work_id = works.id INNER JOIN status" +
            " ON users.status_id = status.id";
    public static final String SELECT_USER_BY_ID = "SELECT users.id,login,status_name,status_id,work_name,work_id" +
            ",name,sername,patronymic,birthday FROM users INNER JOIN status ON users.status_id = status.id" +
            " INNER JOIN works ON users.work_id = works.id WHERE users.id = ?";
    public static final String SELECT_USER_BY_LOGIN = "SELECT users.id,login,status_name,status_id," +
            "work_name,work_id,name,sername,patronymic,birthday FROM users" +
            " INNER JOIN works ON users.work_id = works.id INNER JOIN status" +
            " ON users.status_id = status.id WHERE login = ?";
    public static final String COUNT_USER_BY_LOGIN = "SELECT COUNT(id) AS number FROM users" +
            " WHERE login = ?";
    public static final String SELECT_USER_BY_PASSWORD_AND_ID = "SELECT users.id,login,status_name,status_id," +
            "work_name,work_id,name,sername,patronymic,birthday FROM users" +
            " INNER JOIN works ON users.work_id = works.id INNER JOIN status" +
            " ON users.status_id = status.id WHERE password = ? AND id = ?";
    public static final String SELECT_USER_BY_LOGIN_AND_PASSWORD = "SELECT users.id,login,status_name,status_id," +
            "work_name,work_id,name,sername,patronymic,birthday FROM users" +
            " INNER JOIN works ON users.work_id = works.id INNER JOIN status" +
            " ON users.status_id = status.id WHERE login = ? AND password = ?";
    public static final String SELECT_PASSWORD_BY_ID = "SELECT password FROM users WHERE id = ?";
    public static final String SELECT_USER_BY_ID_WITH_WORK_WITHOUT_PASSWORD = "SELECT users.id,login,work_name,name," +
            "sername,patronymic,birthday FROM users INNER JOIN works ON users.work_id = works.id WHERE users.id = ?";
    public static final String SELECT_USER_BY_ID_WITH_STATUS_AND_WORK_WITHOUT_PASSWORD = "SELECT users.id,login," +
            "status_name,status_id,work_name,work_id,name,sername,patronymic,birthday FROM users INNER JOIN" +
            " works ON users.work_id = works.id INNER JOIN status ON users.status_id = status.id WHERE users.id = ?";
    public static final String
            SELECT_USER_DOCTORS_WITH_ACTIVE_AND_COMPLETE_PATIENCE_WITHOUT_LOGIN_AND_PASSWORD_WITH_ORDER
            = "SELECT users.id,work_name,work_id,name,sername,patronymic,birthday,ActivePatience.amount" +
            " AS ActivePatience,CompletePatience.amount AS CompletePatience FROM users INNER JOIN works ON" +
            " users.work_id = works.id INNER JOIN status ON users.status_id = status.id LEFT JOIN (SELECT COUNT(id)" +
            " AS amount, doctor_user_id FROM patience_ways WHERE date_out IS NOT NULL GROUP BY doctor_user_id) AS" +
            " ActivePatience ON users.id = ActivePatience.doctor_user_id LEFT JOIN (SELECT COUNT(id) AS amount," +
            " doctor_user_id FROM patience_ways WHERE date_out IS NULL GROUP BY doctor_user_id) AS CompletePatience" +
            " ON users.id = CompletePatience.doctor_user_id WHERE status.status_name = 'doctor'" +
            " ORDER BY replaceColumn;";
    public static final String
            SELECT_USER_DOCTORS_WITH_ACTIVE_AND_COMPLETE_PATIENCE_AND_NURSES_WITHOUT_LOGIN_AND_PASSWORD_WITH_ORDER
            = "SELECT users.id,status_name,status_id,work_name,work_id,name,sername,patronymic,birthday, " +
            "ActivePatience.amount AS ActivePatience,CompletePatience.amount AS CompletePatience" +
            " FROM users INNER JOIN works ON users.work_id = works.id INNER JOIN status" +
            " ON users.status_id = status.id LEFT JOIN (SELECT COUNT(id) AS amount, doctor_user_id" +
            " FROM patience_ways WHERE date_out IS NOT NULL GROUP BY doctor_user_id) AS CompletePatience" +
            " ON users.id = CompletePatience.doctor_user_id LEFT JOIN (SELECT COUNT(id) AS amount," +
            " doctor_user_id FROM patience_ways WHERE date_out IS NULL GROUP BY doctor_user_id) AS ActivePatience" +
            " ON users.id = ActivePatience.doctor_user_id WHERE status.status_name = 'doctor'" +
            " OR status.status_name = 'nurse' ORDER BY replaceColumn";
    public static final String SELECT_USER_PATIENCES_FOR_DOCTOR_BY_DOCTOR_ID_ON_WAYS_WITH_ORDER = "SELECT users.id" +
            ",name,sername,patronymic,birthday,date_come AS dateCome,patience_ways.id AS idWay FROM patience_ways LEFT JOIN users" +
            " ON patience_ways.patience_user_id = users.id WHERE date_out IS NULL AND doctor_user_id = ?" +
            " ORDER BY replaceColumn";
    public static final String SELECT_USER_PATIENCES_WITHOUT_LOGIN_AND_PASSWORD_WITH_ORDER = "SELECT users.id," +
            "name,sername,patronymic,birthday FROM users INNER JOIN status ON users.status_id = status.id" +
            " WHERE status_name = 'patience' ORDER BY replaceColumn";
    public static final String SELECT_USER_ADMINS_WITHOUT_LOGIN_AND_PASSWORD_WITH_ORDER = "SELECT users.id," +
            "name,sername,patronymic,birthday FROM users INNER JOIN status ON users.status_id = status.id" +
            " WHERE status_name = 'administrator' AND users.id != ? ORDER BY replaceColumn";
    public static final String DELETE_USER_BY_ID = "DELETE FROM users WHERE id = ?";
    //Status
    public static final String SELECT_ALL_STATUSES = "SELECT id,status FROM status";
    public static final String SELECT_STATUS_BY_ID = "SELECT id,status FROM status WHERE id = ?";
    public static final String SELECT_STATUS_BY_NAME = "SELECT id,status FROM status WHERE status = ?";
    //Works
    public static final String SELECT_ALL_WORKS = "SELECT id,work_name FROM works";
    public static final String SELECT_ALL_DOCTORS_WORKS = "SELECT id,work_name FROM works WHERE id > 3";
    public static final String INSERT_WORK = "INSERT INTO works(work_name) VALUES(?)";
    public static final String UPDATE_WORK_BY_ID = "UPDATE works SET work_name = ? WHERE id = ?";
    //Patience_Cared_Records
    public static final String INSERT_PATIENCE_CARD_RECORD_FOR_DOCTOR = "INSERT INTO patience_card_records(" +
            "doctor_user_id,patience_user_id,procedures,medicines,operations,diagnosis,date_of_set)" +
            " VALUES(?,?,?,?,?,?,?)";
    public static final String INSERT_PATIENCE_CARD_RECORD_FOR_NURSE = "INSERT INTO patience_card_records(" +
            "doctor_user_id,patience_user_id,procedures,medicines,date_of_set)" +
            " VALUES(?,?,?,?,?)";
    public static final String UPDATE_PATIENCE_CARD_RECORD_FOR_DOCTOR = "UPDATE patience_card_records SET" +
            " procedures = ?, medicines = ?, operations = ?, diagnosis = ?, date_of_set = ? WHERE id = ?";
    public static final String UPDATE_PATIENCE_CARD_RECORD_FOR_NURSE = "UPDATE patience_card_records SET" +
            " procedures = ?, medicines = ?, date_of_set = ? WHERE id = ?";
    public static final String SELECT_PATIENCE_CARD_RECORDS_BY_ID_PATIENCE_AND_ID_PERSONAL_ORDER_BY_DATE_OF_SET =
            "SELECT id,doctor_user_id,patience_user_id,procedures,medicines,operations,diagnosis,date_of_set" +
                    " FROM patience_card_records WHERE doctor_user_id = ? AND patience_user_id = ?" +
                    " ORDER BY date_of_set";
    public static final String SELECT_PATIENCE_CARD_RECORDS_BY_ID_PATIENCE_ORDER_BY =
            "SELECT patience_card_records.id,doctor_user_id,patience_user_id,doctors.name AS doctorsName," +
                    "doctors.sername AS doctorsSername,doctors.patronymic AS doctorsPatronymic," +
                    "work_name,patiences.name AS patiencesName,patiences.sername AS patiencesSername," +
                    "patiences.patronymic AS patiencesPatronymic,procedures,medicines,operations,diagnosis," +
                    "date_of_set FROM patience_card_records INNER JOIN users AS doctors" +
                    " ON patience_card_records.doctor_user_id = doctors.id INNER JOIN users AS patiences" +
                    " ON patience_card_records.patience_user_id = patiences.id INNER JOIN works" +
                    " ON doctors.work_id = works.id WHERE patience_user_id = ? ORDER BY replaceColumn";
    public static final String SELECT_PATIENCE_CARD_RECORDS_BY_ID =
            "SELECT patience_card_records.id,doctor_user_id,patience_user_id,doctors.name AS doctorsName," +
                    "doctors.sername AS doctorsSername,doctors.patronymic AS doctorsPatronymic," +
                    "work_name,patiences.name AS patiencesName,patiences.sername AS patiencesSername," +
                    "patiences.patronymic AS patiencesPatronymic,procedures,medicines,operations,diagnosis," +
                    "date_of_set FROM patience_card_records INNER JOIN users AS doctors" +
                    " ON patience_card_records.doctor_user_id = doctors.id INNER JOIN users AS patiences" +
                    " ON patience_card_records.patience_user_id = patiences.id INNER JOIN works" +
                    " ON doctors.work_id = works.id WHERE patience_card_records.id = ?";
    public static final String SELECT_PATIENCE_CARD_RECORDS_BY_ID_DOCTOR_ORDER_BY =
            "SELECT patience_card_records.id,doctor_user_id,patience_user_id,doctors.name AS doctorsName," +
                    "doctors.sername AS doctorsSername,doctors.patronymic AS doctorsPatronymic," +
                    "work_name,patiences.name AS patiencesName,patiences.sername AS patiencesSername," +
                    "patiences.patronymic AS patiencesPatronymic,procedures,medicines,operations,diagnosis," +
                    "date_of_set FROM patience_card_records INNER JOIN users AS doctors" +
                    " ON patience_card_records.doctor_user_id = doctors.id INNER JOIN users AS patiences" +
                    " ON patience_card_records.patience_user_id = patiences.id INNER JOIN works" +
                    " ON doctors.work_id = works.id WHERE doctor_user_id = ? ORDER BY replaceColumn";
    public static final String DELETE_PATIENCE_CARD_RECORDS_FOR_DOCTOR_BY_ID = "DELETE FROM patience_card_records" +
            " WHERE id = ?";
    //Patience_Ways
    public static final String DELETE_PATIENCE_WAY_BY_ID = "DELETE FROM patience_ways WHERE id = ?";
    public static final String INSERT_PATIENCE_WAY = "INSERT INTO patience_ways(doctor_user_id,patience_user_id," +
            "date_come) VALUES(?,?,?)";
    public static final String UPDATE_PATIENCE_WAY = "UPDATE patience_ways SET doctor_user_id = ?," +
            "patience_user_id = ?,date_come = ? WHERE id = ?";
    public static final String UPDATE_PATIENCE_WAY_TO_FINAL = "UPDATE patience_ways SET diagnosis = ?," +
            "document_way = ?,date_out = ? WHERE id = ?";
    public static final String SELECT_FINAL_WAY_FOR_DOCTOR_WITH_ORDER = "SELECT users.id,patience_user_id,users.name,sername,patronymic," +
            "birthday,date_come AS dateCome FROM users INNER JOIN patience_ways" +
            " ON users.id = patience_ways.patience_user_id WHERE date_out IS NOT NULL AND doctor_user_id = ?" +
            " ORDER BY date_come";
    public static final String SELECT_PATIENCE_WAY_FOR_PATIENCE_NOT_FINISH = "SELECT patience_ways.id,doctor_user_id," +
            "sername,patronymic,name,work_name,date_come FROM patience_ways INNER JOIN users ON" +
            " patience_ways.doctor_user_id = users.id INNER JOIN works ON users.work_id = works.id" +
            " WHERE patience_user_id = ? AND date_out IS NULL";
    public static final String SELECT_PATIENCE_WAY_ALL_WITH_ORDER = "SELECT patience_ways.id,doctor_user_id," +
            "patience_user_id,doctors.sername AS doctorsSername,doctors.patronymic AS doctorsPatronymic," +
            "doctors.name AS doctorsName,patiences.sername AS patiencesSername,patiences.patronymic" +
            " AS patiencesPatronymic,patiences.name AS patiencesName,work_name,document_way,date_come," +
            "date_out,diagnosis FROM patience_ways INNER JOIN users AS doctors" +
            " ON patience_ways.doctor_user_id = doctors.id INNER JOIN works" +
            " ON doctors.work_id = works.id INNER JOIN users AS patiences" +
            " ON patience_ways.patience_user_id = patiences.id ORDER BY replaceColumn";
    public static final String SELECT_PATIENCE_WAY_ALL_BY_PATIENCE_ID_WITH_ORDER = "SELECT patience_ways.id,doctor_user_id," +
            "patience_user_id,doctors.sername AS doctorsSername,doctors.patronymic AS doctorsPatronymic," +
            "doctors.name AS doctorsName,patiences.sername AS patiencesSername,patiences.patronymic" +
            " AS patiencesPatronymic,patiences.name AS patiencesName,work_name,document_way,date_come," +
            "date_out,diagnosis FROM patience_ways INNER JOIN users AS doctors" +
            " ON patience_ways.doctor_user_id = doctors.id INNER JOIN works" +
            " ON doctors.work_id = works.id INNER JOIN users AS patiences" +
            " ON patience_ways.patience_user_id = patiences.id WHERE patience_user_id = ? ORDER BY replaceColumn";
    public static final String SELECT_PATIENCE_WAY_BY_ID = "SELECT patience_ways.id,doctor_user_id," +
            "patience_user_id,doctors.sername AS doctorsSername,doctors.patronymic AS doctorsPatronymic," +
            "doctors.name AS doctorsName,patiences.sername AS patiencesSername,patiences.patronymic" +
            " AS patiencesPatronymic,patiences.name AS patiencesName,work_name,document_way,date_come," +
            "date_out,diagnosis FROM patience_ways INNER JOIN users AS doctors" +
            " ON patience_ways.doctor_user_id = doctors.id INNER JOIN works" +
            " ON doctors.work_id = works.id INNER JOIN users AS patiences" +
            " ON patience_ways.patience_user_id = patiences.id WHERE patience_ways.id = ?";
    public static final String SELECT_PATIENCE_WAY_FOR_PATIENCE_FINISH = "SELECT patience_ways.id,doctor_user_id," +
            "sername,patronymic,name,work_name,diagnosis,document_way,date_come,date_out FROM patience_ways INNER JOIN users ON" +
            " patience_ways.doctor_user_id = users.id INNER JOIN works ON users.work_id = works.id" +
            " WHERE patience_user_id = ? AND date_out IS NOT NULL";
}
