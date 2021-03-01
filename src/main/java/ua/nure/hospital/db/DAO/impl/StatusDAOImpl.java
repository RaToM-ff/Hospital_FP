package ua.nure.hospital.db.DAO.impl;

import org.apache.log4j.Logger;
import ua.nure.hospital.command.common.LoginCommand;
import ua.nure.hospital.constant.DBConstants;
import ua.nure.hospital.db.DAO.StatusDAO;
import ua.nure.hospital.db.DBManager;
import ua.nure.hospital.entity.Status;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StatusDAOImpl implements StatusDAO {

    public static Logger logger = Logger.getLogger(LoginCommand.class);

    @Override
    public List<Status> getAllStatuses() {
        DBManager DBM = DBManager.getInstance();
        List<Status> statuses = new ArrayList<>();
        try (Statement statement = DBM.getConnection(DBManager.getUrl()).createStatement();
             ResultSet resultSet = statement.executeQuery(DBConstants.SELECT_ALL_STATUSES)) {
            while (resultSet.next()) {
                Status status = new Status();
                status.setId(resultSet.getInt(DBConstants.FIELD_STATUS_ID));
                status.setStatusName(resultSet.getString(DBConstants.FIELD_STATUS_NAME));
                statuses.add(status);
            }
        } catch (SQLException throwables) {
            logger.error(throwables.getMessage());
        }
        return statuses;
    }

    @Override
    public Status getStatusByName(String name) {
        DBManager DBM = DBManager.getInstance();
        ResultSet resultSet = null;
        Status status = new Status();
        try (Connection connection = DBM.getConnection(DBManager.getUrl());
             PreparedStatement preparedStatement = connection.prepareStatement(DBConstants.SELECT_STATUS_BY_NAME)) {
            preparedStatement.setString(1, name);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                status.setId(resultSet.getInt(DBConstants.FIELD_STATUS_ID));
                status.setStatusName(resultSet.getString(DBConstants.FIELD_STATUS_NAME));
            }
        } catch (SQLException throwables) {
            logger.error(throwables.getMessage());
        }
        return status;
    }

    @Override
    public Status getStatusById(int id) {
        DBManager DBM = DBManager.getInstance();
        ResultSet resultSet = null;
        Status status = new Status();
        try (Connection connection = DBM.getConnection(DBManager.getUrl());
             PreparedStatement preparedStatement = connection.prepareStatement(DBConstants.SELECT_STATUS_BY_ID)) {
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                status.setId(resultSet.getInt(DBConstants.FIELD_STATUS_ID));
                status.setStatusName(resultSet.getString(DBConstants.FIELD_STATUS_NAME));
            }
        } catch (SQLException throwables) {
            logger.error(throwables.getMessage());
        }
        return status;
    }
}
