package ua.nure.hospital.db.DAO.impl;

import org.apache.log4j.Logger;
import ua.nure.hospital.constant.DBConstants;
import ua.nure.hospital.db.DAO.PatienceWayDAO;
import ua.nure.hospital.db.DBManager;
import ua.nure.hospital.entity.PatienceWay;
import ua.nure.hospital.entity.User;
import ua.nure.hospital.entity.Work;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PatienceWayDAOImpl implements PatienceWayDAO {

    public static Logger logger = Logger.getLogger(PatienceWayDAOImpl.class);

    @Override
    public boolean addPatienceWay(PatienceWay patienceWay) {
        ResultSet resultSet = null;
        DBManager DBM = DBManager.getInstance();
        try (Connection connection = DBM.getConnection(DBManager.getUrl());
             PreparedStatement preparedStatement = connection.prepareStatement(DBConstants.INSERT_PATIENCE_WAY, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setInt(1, patienceWay.getDoctor().getId());
            preparedStatement.setInt(2, patienceWay.getPatience().getId());
            preparedStatement.setDate(3, new java.sql.Date(patienceWay.getDate_come().getTime()));
            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                patienceWay.setId(resultSet.getInt(1));
            }
            return true;
        } catch (SQLException throwables) {
            logger.error(throwables.getMessage());
            return false;
        }
    }

    @Override
    public boolean updatePatienceWay(PatienceWay patienceWay) {
        DBManager DBM = DBManager.getInstance();
        try (Connection connection = DBM.getConnection(DBManager.getUrl());
             PreparedStatement preparedS = connection.prepareStatement(DBConstants.UPDATE_PATIENCE_WAY)) {
            preparedS.setInt(1, patienceWay.getDoctor().getId());
            preparedS.setInt(2, patienceWay.getPatience().getId());
            preparedS.setDate(3, new java.sql.Date(patienceWay.getDate_come().getTime()));
            preparedS.setInt(4, patienceWay.getId());
            preparedS.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            logger.error(throwables.getMessage());
            return false;
        }
    }

    @Override
    public boolean updatePatienceWayToFinal(PatienceWay patienceWay) {
        DBManager DBM = DBManager.getInstance();
        try (Connection connection = DBM.getConnection(DBManager.getUrl());
             PreparedStatement preparedS = connection.prepareStatement(DBConstants.UPDATE_PATIENCE_WAY_TO_FINAL)) {
            preparedS.setString(1, patienceWay.getDiagnosis());
            preparedS.setString(2, patienceWay.getDocumentWay());
            if (patienceWay.getDate_out() != null) {
                preparedS.setDate(3, new java.sql.Date(patienceWay.getDate_out().getTime()));
            } else {
                preparedS.setDate(3, null);
            }
            preparedS.setInt(4, patienceWay.getId());
            preparedS.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            logger.error(throwables.getMessage());
            return false;
        }
    }

    @Override
    public List<PatienceWay> getAllPatienceWays(int id_patience) {
        DBManager DBM = DBManager.getInstance();
        ResultSet resultSet = null;
        List<PatienceWay> patienceWays = new ArrayList<>();
        try (Connection connection = DBM.getConnection(DBManager.getUrl());
             PreparedStatement preparedStatement = connection.prepareStatement(DBConstants.SELECT_PATIENCE_WAY_FOR_PATIENCE_NOT_FINISH)) {
            preparedStatement.setInt(1, id_patience);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                PatienceWay patienceWay = new PatienceWay();
                patienceWay.setId(resultSet.getInt(DBConstants.FIELD_PATIENCE_WAY_ID));
                User doctor = new User();
                Work work = new Work();
                patienceWay.setId(resultSet.getInt(DBConstants.FIELD_PATIENCE_WAY_ID));
                doctor.setId(resultSet.getInt(DBConstants.FIELD_PATIENCE_WAY_DOCTOR_USER_ID));
                doctor.setSername(resultSet.getString(DBConstants.FIELD_USER_SERNAME));
                doctor.setName(resultSet.getString(DBConstants.FIELD_USER_NAME));
                doctor.setPatronymic(resultSet.getString(DBConstants.FIELD_USER_PATRONYMIC));
                work.setName(resultSet.getString(DBConstants.FIELD_WORK_NAME));
                doctor.setWork(work);
                patienceWay.setDoctor(doctor);
                patienceWay.setDate_come(resultSet.getDate(DBConstants.FIELD_PATIENCE_WAY_DATE_COME));
                patienceWays.add(patienceWay);
            }
        } catch (SQLException throwables) {
            logger.error(throwables.getMessage());
        }
        return patienceWays;
    }

    @Override
    public List<PatienceWay> getFinalWayForDoctorWithOrder(int id_doctor) {
        DBManager DBM = DBManager.getInstance();
        ResultSet resultSet = null;
        List<PatienceWay> patienceWays = new ArrayList<>();
        try (Connection connection = DBM.getConnection(DBManager.getUrl());
             PreparedStatement preparedStatement = connection.prepareStatement(DBConstants.SELECT_FINAL_WAY_FOR_DOCTOR_WITH_ORDER)) {
            preparedStatement.setInt(1, id_doctor);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                PatienceWay patienceWay = new PatienceWay();
                patienceWay.setId(resultSet.getInt(DBConstants.FIELD_PATIENCE_WAY_ID));
                patienceWay.getPatience().setId(resultSet.getInt(DBConstants.FIELD_PATIENCE_WAY_PATIENCE_USER_ID));
                patienceWay.getPatience().setName(resultSet.getString(DBConstants.FIELD_USER_NAME));
                patienceWay.getPatience().setSername(resultSet.getString(DBConstants.FIELD_USER_SERNAME));
                patienceWay.getPatience().setPatronymic(resultSet.getString(DBConstants.FIELD_USER_PATRONYMIC));
                patienceWay.setDiagnosis(resultSet.getString(DBConstants.FIELD_PATIENCE_WAY_DIAGNOSIS));
                patienceWay.setDocumentWay(resultSet.getString(DBConstants.FIELD_PATIENCE_WAY_DOCUMENT_WAY));
                patienceWay.setDate_come(resultSet.getDate(DBConstants.FIELD_PATIENCE_WAY_DATE_COME));
                patienceWay.setDate_out(resultSet.getDate(DBConstants.FIELD_PATIENCE_WAY_DATE_OUT));
                patienceWays.add(patienceWay);
            }
        } catch (SQLException throwables) {
            logger.error(throwables.getMessage());
        }
        return patienceWays;
    }

    @Override
    public List<PatienceWay> getPatienceWayForPatienceFinish(int id_patience) {
        DBManager DBM = DBManager.getInstance();
        ResultSet resultSet = null;
        List<PatienceWay> patienceWays = new ArrayList<>();
        try (Connection connection = DBM.getConnection(DBManager.getUrl());
             PreparedStatement preparedStatement = connection.prepareStatement(DBConstants.SELECT_PATIENCE_WAY_FOR_PATIENCE_FINISH)) {
            preparedStatement.setInt(1, id_patience);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                PatienceWay patienceWay = new PatienceWay();
                User doctor = new User();
                Work work = new Work();
                patienceWay.setId(resultSet.getInt(DBConstants.FIELD_PATIENCE_WAY_ID));
                doctor.setId(resultSet.getInt(DBConstants.FIELD_PATIENCE_WAY_DOCTOR_USER_ID));
                doctor.setSername(resultSet.getString(DBConstants.FIELD_USER_SERNAME));
                doctor.setName(resultSet.getString(DBConstants.FIELD_USER_NAME));
                doctor.setPatronymic(resultSet.getString(DBConstants.FIELD_USER_PATRONYMIC));
                work.setName(resultSet.getString(DBConstants.FIELD_WORK_NAME));
                doctor.setWork(work);
                patienceWay.setDoctor(doctor);
                patienceWay.setDiagnosis(resultSet.getString(DBConstants.FIELD_PATIENCE_WAY_DIAGNOSIS));
                patienceWay.setDocumentWay(resultSet.getString(DBConstants.FIELD_PATIENCE_WAY_DOCUMENT_WAY));
                patienceWay.setDate_come(resultSet.getDate(DBConstants.FIELD_PATIENCE_WAY_DATE_COME));
                patienceWay.setDate_out(resultSet.getDate(DBConstants.FIELD_PATIENCE_WAY_DATE_OUT));
                patienceWays.add(patienceWay);
            }
        } catch (SQLException throwables) {
            logger.error(throwables.getMessage());
        }
        return patienceWays;
    }

    @Override
    public List<PatienceWay> getAllPatienceWays(String orderBy) {
        DBManager DBM = DBManager.getInstance();
        ResultSet resultSet = null;
        List<PatienceWay> patienceWays = new ArrayList<>();
        try (Connection connection = DBM.getConnection(DBManager.getUrl());
             PreparedStatement preparedStatement = connection.prepareStatement(DBConstants.SELECT_PATIENCE_WAY_ALL_WITH_ORDER.replace("replaceColumn", orderBy))) {
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                PatienceWay patienceWay = new PatienceWay();
                patienceWay.setId(resultSet.getInt(DBConstants.FIELD_PATIENCE_WAY_ID));
                User doctor = new User();
                User patience = new User();
                Work work = new Work();
                patienceWay.setId(resultSet.getInt(DBConstants.FIELD_PATIENCE_WAY_ID));
                doctor.setId(resultSet.getInt(DBConstants.FIELD_PATIENCE_WAY_DOCTOR_USER_ID));
                doctor.setSername(resultSet.getString("doctorsSername"));
                doctor.setName(resultSet.getString("doctorsName"));
                doctor.setPatronymic(resultSet.getString("doctorsPatronymic"));
                work.setName(resultSet.getString(DBConstants.FIELD_WORK_NAME));
                doctor.setWork(work);
                patienceWay.setDoctor(doctor);
                patience.setId(resultSet.getInt(DBConstants.FIELD_PATIENCE_WAY_PATIENCE_USER_ID));
                patience.setSername(resultSet.getString("patiencesSername"));
                patience.setName(resultSet.getString("patiencesName"));
                patience.setPatronymic(resultSet.getString("patiencesPatronymic"));
                patienceWay.setPatience(patience);
                patienceWay.setDiagnosis(resultSet.getString(DBConstants.FIELD_PATIENCE_WAY_DIAGNOSIS));
                patienceWay.setDocumentWay(resultSet.getString(DBConstants.FIELD_PATIENCE_WAY_DOCUMENT_WAY));
                patienceWay.setDate_come(resultSet.getDate(DBConstants.FIELD_PATIENCE_WAY_DATE_COME));
                patienceWay.setDate_out(resultSet.getDate(DBConstants.FIELD_PATIENCE_WAY_DATE_OUT));
                patienceWays.add(patienceWay);
            }
        } catch (SQLException throwables) {
            logger.error(throwables.getMessage());
        }
        return patienceWays;
    }

    @Override
    public List<PatienceWay> getAllPatienceWaysByPatienceId(int id_patience, String orderBy) {
        DBManager DBM = DBManager.getInstance();
        ResultSet resultSet = null;
        List<PatienceWay> patienceWays = new ArrayList<>();
        try (Connection connection = DBM.getConnection(DBManager.getUrl());
             PreparedStatement preparedStatement = connection.prepareStatement(DBConstants.SELECT_PATIENCE_WAY_ALL_BY_PATIENCE_ID_WITH_ORDER.replace("replaceColumn", orderBy))) {
            preparedStatement.setInt(1, id_patience);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                PatienceWay patienceWay = new PatienceWay();
                patienceWay.setId(resultSet.getInt(DBConstants.FIELD_PATIENCE_WAY_ID));
                User doctor = new User();
                User patience = new User();
                Work work = new Work();
                patienceWay.setId(resultSet.getInt(DBConstants.FIELD_PATIENCE_WAY_ID));
                doctor.setId(resultSet.getInt(DBConstants.FIELD_PATIENCE_WAY_DOCTOR_USER_ID));
                doctor.setSername(resultSet.getString("doctorsSername"));
                doctor.setName(resultSet.getString("doctorsName"));
                doctor.setPatronymic(resultSet.getString("doctorsPatronymic"));
                work.setName(resultSet.getString(DBConstants.FIELD_WORK_NAME));
                doctor.setWork(work);
                patienceWay.setDoctor(doctor);
                patience.setId(resultSet.getInt(DBConstants.FIELD_PATIENCE_WAY_PATIENCE_USER_ID));
                patience.setSername(resultSet.getString("patiencesSername"));
                patience.setName(resultSet.getString("patiencesName"));
                patience.setPatronymic(resultSet.getString("patiencesPatronymic"));
                patienceWay.setPatience(patience);
                patienceWay.setDiagnosis(resultSet.getString(DBConstants.FIELD_PATIENCE_WAY_DIAGNOSIS));
                patienceWay.setDocumentWay(resultSet.getString(DBConstants.FIELD_PATIENCE_WAY_DOCUMENT_WAY));
                patienceWay.setDate_come(resultSet.getDate(DBConstants.FIELD_PATIENCE_WAY_DATE_COME));
                patienceWay.setDate_out(resultSet.getDate(DBConstants.FIELD_PATIENCE_WAY_DATE_OUT));
                patienceWays.add(patienceWay);
            }
        } catch (SQLException throwables) {
            logger.error(throwables.getMessage());
        }
        return patienceWays;
    }

    @Override
    public PatienceWay getPatienceWayById(int idPatienceWay) {
        DBManager DBM = DBManager.getInstance();
        ResultSet resultSet = null;
        PatienceWay patienceWay = new PatienceWay();
        User doctor = new User();
        User patience = new User();
        Work work = new Work();
        try (Connection connection = DBM.getConnection(DBManager.getUrl());
             PreparedStatement preparedStatement = connection.prepareStatement(DBConstants.SELECT_PATIENCE_WAY_BY_ID)) {
            preparedStatement.setInt(1, idPatienceWay);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                patienceWay.setId(resultSet.getInt(DBConstants.FIELD_PATIENCE_WAY_ID));
                patienceWay.setId(resultSet.getInt(DBConstants.FIELD_PATIENCE_WAY_ID));
                doctor.setId(resultSet.getInt(DBConstants.FIELD_PATIENCE_WAY_DOCTOR_USER_ID));
                doctor.setSername(resultSet.getString("doctorsSername"));
                doctor.setName(resultSet.getString("doctorsName"));
                doctor.setPatronymic(resultSet.getString("doctorsPatronymic"));
                work.setName(resultSet.getString(DBConstants.FIELD_WORK_NAME));
                doctor.setWork(work);
                patienceWay.setDoctor(doctor);
                patience.setId(resultSet.getInt(DBConstants.FIELD_PATIENCE_WAY_PATIENCE_USER_ID));
                patience.setSername(resultSet.getString("patiencesSername"));
                patience.setName(resultSet.getString("patiencesName"));
                patience.setPatronymic(resultSet.getString("patiencesPatronymic"));
                patienceWay.setPatience(patience);
                patienceWay.setDiagnosis(resultSet.getString(DBConstants.FIELD_PATIENCE_WAY_DIAGNOSIS));
                patienceWay.setDocumentWay(resultSet.getString(DBConstants.FIELD_PATIENCE_WAY_DOCUMENT_WAY));
                patienceWay.setDate_come(resultSet.getDate(DBConstants.FIELD_PATIENCE_WAY_DATE_COME));
                patienceWay.setDate_out(resultSet.getDate(DBConstants.FIELD_PATIENCE_WAY_DATE_OUT));
            }
        } catch (SQLException throwables) {
            logger.error(throwables.getMessage());
        }
        return patienceWay;
    }

    @Override
    public boolean deletePatienceWayById(int id) {
        DBManager DBM = DBManager.getInstance();
        try (Connection connection = DBM.getConnection(DBManager.getUrl());
             PreparedStatement preparedS = connection.prepareStatement(DBConstants.DELETE_PATIENCE_WAY_BY_ID)) {
            preparedS.setInt(1, id);
            preparedS.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            logger.error(throwables.getMessage());
            return false;
        }
    }
}
