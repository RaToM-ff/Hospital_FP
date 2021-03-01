package ua.nure.hospital.service.impl;

import ua.nure.hospital.db.DAO.UserDAO;
import ua.nure.hospital.entity.User;
import ua.nure.hospital.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private final UserDAO dao;

    public UserServiceImpl(UserDAO dao) {
        this.dao = dao;
    }

    @Override
    public boolean addUser(User user) {
        return dao.addUser(user);
    }

    @Override
    public List<User> getAllUsers() {
        return dao.getAllUsers();
    }

    @Override
    public boolean updateUserWithoutLoginAndPasswordById(User user) {
        return dao.updateUserWithoutLoginAndPasswordById(user);
    }

    @Override
    public boolean updateUserLoginById(User user) {
        return dao.updateUserLoginById(user);
    }

    @Override
    public boolean updateUserPasswordById(User user) {
        return dao.updateUserPasswordById(user);
    }

    @Override
    public User getUserById(int id_user) {
        return dao.getUserById(id_user);
    }

    @Override
    public User getUserByLogin(String login) {
        return dao.getUserByLogin(login);
    }

    @Override
    public User getUserByPasswordAndId(String password, int id_user) {
        return dao.getUserByPasswordAndId(password, id_user);
    }

    @Override
    public User getUserByLoginAndPassword(String login, String password) {
        return dao.getUserByLoginAndPassword(login, password);
    }

    @Override
    public User getUserByIdWithWorkWithoutPassword(int id) {
        return dao.getUserByIdWithWorkWithoutPassword(id);
    }

    @Override
    public User getUserByIdWithStatusAndWorkWithoutPassword(int id) {
        return dao.getUserByIdWithStatusAndWorkWithoutPassword(id);
    }

    @Override
    public List<User> getDoctorsWithActiveAndCompletePatienceWithoutLoginAndPasswordWithOrderBy(String orderBy) {
        return dao.getDoctorsWithActiveAndCompletePatienceWithoutLoginAndPasswordWithOrderBy(orderBy);
    }

    @Override
    public List<User> getDoctorsWithActiveAndCompletePatienceWithNursesWithoutLoginAndPasswordOrderBy(String orderBy) {
        return dao.getDoctorsWithActiveAndCompletePatienceWithNursesWithoutLoginAndPasswordOrderBy(orderBy);
    }

    @Override
    public List<User> getPatiencesWithoutLoginAndPasswordOrderBy(String orderBy) {
        return dao.getPatiencesWithoutLoginAndPasswordOrderBy(orderBy);
    }

    @Override
    public List<User> getPatiencesForDoctorByDoctorIdOnWaysOrderBy(int doctor_id, String orderBy) {
        return dao.getPatiencesForDoctorByDoctorIdOnWaysOrderBy(doctor_id, orderBy);
    }

    @Override
    public boolean deleteUserById(int id) {
        return dao.deleteUserById(id);
    }

    @Override
    public boolean getExistUserByLogin(String login) {
        return dao.getExistUserByLogin(login);
    }

    @Override
    public String getPasswordById(int id) {
        return dao.getPasswordById(id);
    }

    @Override
    public List<User> getAdminsWithoutLoginAndPasswordOrderBy(int id, String orderBy) {
        return dao.getAdminsWithoutLoginAndPasswordOrderBy(id, orderBy);
    }
}
