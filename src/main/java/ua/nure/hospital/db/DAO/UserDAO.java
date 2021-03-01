package ua.nure.hospital.db.DAO;

import ua.nure.hospital.entity.User;

import java.util.List;

public interface UserDAO {

    boolean addUser(User user);

    List<User> getAllUsers();

    boolean updateUserWithoutLoginAndPasswordById(User user);

    boolean updateUserLoginById(User user);

    boolean updateUserPasswordById(User user);

    User getUserById(int id_user);

    User getUserByLogin(String login);

    User getUserByPasswordAndId(String password, int id_user);

    User getUserByLoginAndPassword(String login, String password);

    User getUserByIdWithWorkWithoutPassword(int id);

    User getUserByIdWithStatusAndWorkWithoutPassword(int id);

    List<User> getDoctorsWithActiveAndCompletePatienceWithoutLoginAndPasswordWithOrderBy(String orderBy);

    List<User> getDoctorsWithActiveAndCompletePatienceWithNursesWithoutLoginAndPasswordOrderBy(String orderBy);

    List<User> getPatiencesWithoutLoginAndPasswordOrderBy(String orderBy);

    List<User> getPatiencesForDoctorByDoctorIdOnWaysOrderBy(int doctor_id, String orderBy);

    boolean deleteUserById(int id);

    boolean getExistUserByLogin(String login);

    String getPasswordById(int id);

    List<User> getAdminsWithoutLoginAndPasswordOrderBy(int id, String orderBy);
}
