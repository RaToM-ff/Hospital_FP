package ua.nure.hospital.db.DAO;

import ua.nure.hospital.entity.PatienceWay;

import java.util.List;

public interface PatienceWayDAO {
    boolean addPatienceWay(PatienceWay patienceWay);

    boolean updatePatienceWay(PatienceWay patienceWay);

    boolean updatePatienceWayToFinal(PatienceWay patienceWay);

    List<PatienceWay> getAllPatienceWays(int id_patience);

    List<PatienceWay> getFinalWayForDoctorWithOrder(int id_doctor);

    List<PatienceWay> getPatienceWayForPatienceFinish(int id_patience);

    List<PatienceWay> getAllPatienceWays(String orderBy);

    PatienceWay getPatienceWayById(int idPatienceWay);

    boolean deletePatienceWayById(int id);

    List<PatienceWay> getAllPatienceWaysByPatienceId(int id_patience,String orderBy);
}
