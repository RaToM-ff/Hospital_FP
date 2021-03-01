package ua.nure.hospital.db.DAO.impl;

import org.apache.log4j.Logger;
import ua.nure.hospital.command.CommandContainer;
import ua.nure.hospital.command.common.LoginCommand;
import ua.nure.hospital.constant.DBConstants;
import ua.nure.hospital.db.DAO.PatientCardRecordDAO;
import ua.nure.hospital.db.DBManager;
import ua.nure.hospital.entity.PatienceCardRecord;
import ua.nure.hospital.entity.User;
import ua.nure.hospital.entity.Work;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PatienceCardRecordDAOImpl implements PatientCardRecordDAO {

    public static Logger logger = Logger.getLogger(LoginCommand.class);

    @Override
    public boolean addPatienceCardRecordForDoctor(PatienceCardRecord patienceCardRecord) {
        ResultSet resultSet = null;
        DBManager DBM = DBManager.getInstance();
        try (Connection connection = DBM.getConnection(DBManager.getUrl());
             PreparedStatement preparedStatement = connection.prepareStatement(DBConstants.INSERT_PATIENCE_CARD_RECORD_FOR_DOCTOR, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setInt(1, patienceCardRecord.getDoctor().getId());
            preparedStatement.setInt(2, patienceCardRecord.getPatience().getId());
            preparedStatement.setString(3, patienceCardRecord.getProcedures());
            preparedStatement.setString(4, patienceCardRecord.getMedicines());
            preparedStatement.setString(5, patienceCardRecord.getOperations());
            preparedStatement.setString(6, patienceCardRecord.getDiagnosis());
            preparedStatement.setDate(7, new java.sql.Date(patienceCardRecord.getDate_of_set().getTime()));
            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                patienceCardRecord.setId(resultSet.getInt(1));
            }
            return true;
        } catch (SQLException throwables) {
            logger.error(throwables.getMessage());
            return false;
        }
    }

    @Override
    public boolean addPatienceCardRecordForNurse(PatienceCardRecord patienceCardRecord) {
        ResultSet resultSet = null;
        DBManager DBM = DBManager.getInstance();
        try (Connection connection = DBM.getConnection(DBManager.getUrl());
             PreparedStatement preparedStatement = connection.prepareStatement(DBConstants.INSERT_PATIENCE_CARD_RECORD_FOR_NURSE, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setInt(1, patienceCardRecord.getDoctor().getId());
            preparedStatement.setInt(2, patienceCardRecord.getPatience().getId());
            preparedStatement.setString(3, patienceCardRecord.getProcedures());
            preparedStatement.setString(4, patienceCardRecord.getMedicines());
            preparedStatement.setDate(5, new java.sql.Date(patienceCardRecord.getDate_of_set().getTime()));
            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                patienceCardRecord.setId(resultSet.getInt(1));
            }
            return true;
        } catch (SQLException throwables) {
            logger.error(throwables.getMessage());
            return false;
        }
    }

    @Override
    public boolean updatePatienceCardRecordForDoctorById(PatienceCardRecord patienceCardRecord) {
        DBManager DBM = DBManager.getInstance();
        try (Connection connection = DBM.getConnection(DBManager.getUrl());
             PreparedStatement preparedS = connection.prepareStatement(DBConstants.UPDATE_PATIENCE_CARD_RECORD_FOR_DOCTOR)) {
            preparedS.setString(1, patienceCardRecord.getProcedures());
            preparedS.setString(2, patienceCardRecord.getMedicines());
            preparedS.setString(3, patienceCardRecord.getOperations());
            preparedS.setString(4, patienceCardRecord.getDiagnosis());
            preparedS.setDate(5, new java.sql.Date(patienceCardRecord.getDate_of_set().getTime()));
            preparedS.setInt(6, patienceCardRecord.getId());
            preparedS.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            logger.error(throwables.getMessage());
            return false;
        }
    }

    @Override
    public boolean updatePatienceCardRecordForNurseById(PatienceCardRecord patienceCardRecord) {
        DBManager DBM = DBManager.getInstance();
        try (Connection connection = DBM.getConnection(DBManager.getUrl());
             PreparedStatement preparedS = connection.prepareStatement(DBConstants.UPDATE_PATIENCE_CARD_RECORD_FOR_NURSE)) {
            preparedS.setString(1, patienceCardRecord.getProcedures());
            preparedS.setString(2, patienceCardRecord.getMedicines());
            preparedS.setDate(3, new java.sql.Date(patienceCardRecord.getDate_of_set().getTime()));
            preparedS.setInt(4, patienceCardRecord.getId());
            preparedS.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            logger.error(throwables.getMessage());
            return false;
        }
    }

    @Override
    public List<PatienceCardRecord> getAllPatienceCardRecordsByIdPatienceAndIdPersonal(int id_patience, int id_personal) {
        DBManager DBM = DBManager.getInstance();
        ResultSet resultSet = null;
        List<PatienceCardRecord> patienceCardRecords = new ArrayList<>();
        try (Connection connection = DBM.getConnection(DBManager.getUrl());
             PreparedStatement preparedStatement = connection.prepareStatement(DBConstants.SELECT_PATIENCE_CARD_RECORDS_BY_ID_PATIENCE_AND_ID_PERSONAL_ORDER_BY_DATE_OF_SET)) {
            preparedStatement.setInt(1, id_patience);
            preparedStatement.setInt(2, id_personal);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                PatienceCardRecord patienceCardRecord = new PatienceCardRecord();
                patienceCardRecord.setId(resultSet.getInt(DBConstants.FIELD_PATIENCE_CARD_RECORD_ID));
                patienceCardRecord.getDoctor().setId(resultSet.getInt(DBConstants.FIELD_PATIENCE_CARD_RECORD_DOCTOR_USER_ID));
                patienceCardRecord.getPatience().setId(resultSet.getInt(DBConstants.FIELD_PATIENCE_CARD_RECORD_PATIENCE_USER_ID));
                patienceCardRecord.setProcedures(resultSet.getString(DBConstants.FIELD_PATIENCE_CARD_RECORD_PROCEDURES));
                patienceCardRecord.setMedicines(resultSet.getString(DBConstants.FIELD_PATIENCE_CARD_RECORD_MEDICINES));
                patienceCardRecord.setOperations(resultSet.getString(DBConstants.FIELD_PATIENCE_CARD_RECORD_OPERATIONS));
                patienceCardRecord.setDiagnosis(resultSet.getString(DBConstants.FIELD_PATIENCE_CARD_RECORD_DIAGNOSIS));
                patienceCardRecord.setDate_of_set(resultSet.getDate(DBConstants.FIELD_PATIENCE_CARD_RECORD_DATE_OF_SET));
                patienceCardRecords.add(patienceCardRecord);
            }
        } catch (SQLException throwables) {
            logger.error(throwables.getMessage());
        }
        return patienceCardRecords;
    }

    @Override
    public List<PatienceCardRecord> getAllPatienceCardRecordsByIdPatienceOrderBy(int id_patience,String orderBy) {
        DBManager DBM = DBManager.getInstance();
        ResultSet resultSet = null;
        List<PatienceCardRecord> patienceCardRecords = new ArrayList<>();
        try (Connection connection = DBM.getConnection(DBManager.getUrl());
             PreparedStatement preparedStatement = connection.prepareStatement(DBConstants.SELECT_PATIENCE_CARD_RECORDS_BY_ID_PATIENCE_ORDER_BY.replace("replaceColumn",orderBy))) {
            preparedStatement.setInt(1, id_patience);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                PatienceCardRecord patienceCardRecord = new PatienceCardRecord();
                User doctor = new User();
                User patience = new User();
                Work work = new Work();
                patienceCardRecord.setId(resultSet.getInt(DBConstants.FIELD_PATIENCE_CARD_RECORD_ID));
                doctor.setId(resultSet.getInt(DBConstants.FIELD_PATIENCE_CARD_RECORD_DOCTOR_USER_ID));;
                doctor.setSername(resultSet.getString("doctorsSername"));
                doctor.setName(resultSet.getString("doctorsName"));
                doctor.setPatronymic(resultSet.getString("doctorsPatronymic"));
                work.setName(resultSet.getString(DBConstants.FIELD_WORK_NAME));
                patience.setId(resultSet.getInt(DBConstants.FIELD_PATIENCE_CARD_RECORD_PATIENCE_USER_ID));
                patience.setSername(resultSet.getString("patiencesSername"));
                patience.setName(resultSet.getString("patiencesName"));
                patience.setPatronymic(resultSet.getString("patiencesPatronymic"));
                doctor.setWork(work);
                patienceCardRecord.setDoctor(doctor);
                patienceCardRecord.setPatience(patience);
                patienceCardRecord.setProcedures(resultSet.getString(DBConstants.FIELD_PATIENCE_CARD_RECORD_PROCEDURES));
                patienceCardRecord.setMedicines(resultSet.getString(DBConstants.FIELD_PATIENCE_CARD_RECORD_MEDICINES));
                patienceCardRecord.setOperations(resultSet.getString(DBConstants.FIELD_PATIENCE_CARD_RECORD_OPERATIONS));
                patienceCardRecord.setDiagnosis(resultSet.getString(DBConstants.FIELD_PATIENCE_CARD_RECORD_DIAGNOSIS));
                patienceCardRecord.setDate_of_set(resultSet.getDate(DBConstants.FIELD_PATIENCE_CARD_RECORD_DATE_OF_SET));
                patienceCardRecords.add(patienceCardRecord);
            }
        } catch (SQLException throwables) {
            logger.info(throwables.getMessage());
        }
        return patienceCardRecords;
    }

    @Override
    public PatienceCardRecord getPatienceCardRecordsById(int id_cardRecord) {
        DBManager DBM = DBManager.getInstance();
        ResultSet resultSet = null;
        PatienceCardRecord patienceCardRecord = new PatienceCardRecord();
        User doctor = new User();
        User patience = new User();
        Work work = new Work();
        try (Connection connection = DBM.getConnection(DBManager.getUrl());
             PreparedStatement preparedStatement = connection.prepareStatement(DBConstants.SELECT_PATIENCE_CARD_RECORDS_BY_ID)) {
            preparedStatement.setInt(1, id_cardRecord);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                patienceCardRecord.setId(resultSet.getInt(DBConstants.FIELD_PATIENCE_CARD_RECORD_ID));
                doctor.setId(resultSet.getInt(DBConstants.FIELD_PATIENCE_CARD_RECORD_DOCTOR_USER_ID));;
                doctor.setSername(resultSet.getString("doctorsSername"));
                doctor.setName(resultSet.getString("doctorsName"));
                doctor.setPatronymic(resultSet.getString("doctorsPatronymic"));
                work.setName(resultSet.getString(DBConstants.FIELD_WORK_NAME));
                patience.setId(resultSet.getInt(DBConstants.FIELD_PATIENCE_CARD_RECORD_PATIENCE_USER_ID));
                patience.setSername(resultSet.getString("patiencesSername"));
                patience.setName(resultSet.getString("patiencesName"));
                patience.setPatronymic(resultSet.getString("patiencesPatronymic"));
                doctor.setWork(work);
                patienceCardRecord.setDoctor(doctor);
                patienceCardRecord.setPatience(patience);
                patienceCardRecord.setProcedures(resultSet.getString(DBConstants.FIELD_PATIENCE_CARD_RECORD_PROCEDURES));
                patienceCardRecord.setMedicines(resultSet.getString(DBConstants.FIELD_PATIENCE_CARD_RECORD_MEDICINES));
                patienceCardRecord.setOperations(resultSet.getString(DBConstants.FIELD_PATIENCE_CARD_RECORD_OPERATIONS));
                patienceCardRecord.setDiagnosis(resultSet.getString(DBConstants.FIELD_PATIENCE_CARD_RECORD_DIAGNOSIS));
                patienceCardRecord.setDate_of_set(resultSet.getDate(DBConstants.FIELD_PATIENCE_CARD_RECORD_DATE_OF_SET));
            }
        } catch (SQLException throwables) {
            logger.info(throwables.getMessage());
        }
        return patienceCardRecord;
    }

    @Override
    public List<PatienceCardRecord> getAllPatienceCardRecordsByIdDoctorOrderBy(int id_doctor,String orderBy) {
        DBManager DBM = DBManager.getInstance();
        ResultSet resultSet = null;
        List<PatienceCardRecord> patienceCardRecords = new ArrayList<>();
        try (Connection connection = DBM.getConnection(DBManager.getUrl());
             PreparedStatement preparedStatement = connection.prepareStatement(DBConstants.SELECT_PATIENCE_CARD_RECORDS_BY_ID_DOCTOR_ORDER_BY.replace("replaceColumn",orderBy))) {
            preparedStatement.setInt(1, id_doctor);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                PatienceCardRecord patienceCardRecord = new PatienceCardRecord();
                User doctor = new User();
                User patience = new User();
                Work work = new Work();
                patienceCardRecord.setId(resultSet.getInt(DBConstants.FIELD_PATIENCE_CARD_RECORD_ID));
                doctor.setId(resultSet.getInt(DBConstants.FIELD_PATIENCE_CARD_RECORD_DOCTOR_USER_ID));;
                doctor.setSername(resultSet.getString("doctorsSername"));
                doctor.setName(resultSet.getString("doctorsName"));
                doctor.setPatronymic(resultSet.getString("doctorsPatronymic"));
                work.setName(resultSet.getString(DBConstants.FIELD_WORK_NAME));
                patience.setId(resultSet.getInt(DBConstants.FIELD_PATIENCE_CARD_RECORD_PATIENCE_USER_ID));
                patience.setSername(resultSet.getString("patiencesSername"));
                patience.setName(resultSet.getString("patiencesName"));
                patience.setPatronymic(resultSet.getString("patiencesPatronymic"));
                doctor.setWork(work);
                patienceCardRecord.setDoctor(doctor);
                patienceCardRecord.setPatience(patience);
                patienceCardRecord.setProcedures(resultSet.getString(DBConstants.FIELD_PATIENCE_CARD_RECORD_PROCEDURES));
                patienceCardRecord.setMedicines(resultSet.getString(DBConstants.FIELD_PATIENCE_CARD_RECORD_MEDICINES));
                patienceCardRecord.setOperations(resultSet.getString(DBConstants.FIELD_PATIENCE_CARD_RECORD_OPERATIONS));
                patienceCardRecord.setDiagnosis(resultSet.getString(DBConstants.FIELD_PATIENCE_CARD_RECORD_DIAGNOSIS));
                patienceCardRecord.setDate_of_set(resultSet.getDate(DBConstants.FIELD_PATIENCE_CARD_RECORD_DATE_OF_SET));
                patienceCardRecords.add(patienceCardRecord);
            }
        } catch (SQLException throwables) {
            logger.info(throwables.getMessage());
        }
        return patienceCardRecords;
    }

    @Override
    public boolean deletePatienceCardRecordForDoctorById(int id) {
        DBManager DBM = DBManager.getInstance();
        try (Connection connection = DBM.getConnection(DBManager.getUrl());
             PreparedStatement preparedS = connection.prepareStatement(DBConstants.DELETE_PATIENCE_CARD_RECORDS_FOR_DOCTOR_BY_ID)) {
            preparedS.setInt(1, id);
            preparedS.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            logger.error(throwables.getMessage());
            return false;
        }
    }
}
