package ua.nure.hospital.service;

import ua.nure.hospital.entity.PatienceWay;

import java.util.List;

public interface PatienceWayService {
    boolean addPatienceWay(PatienceWay patienceWay);

    boolean updatePatienceWay(PatienceWay patienceWay);

    boolean updatePatienceWayToFinal(PatienceWay patienceWay);

    List<PatienceWay> getPatienceWayForPatienceNotFinish(int id_patience);

    List<PatienceWay> getFinalWayForDoctorWithOrder(int id_doctor);

    List<PatienceWay> getPatienceWayForPatienceFinish(int id_patience);

    List<PatienceWay> getAllPatienceWays(String orderBy);

    PatienceWay getPatienceWayById(int idPatienceWay);

    boolean deletePatienceWayById(int id);

    List<PatienceWay> getAllPatienceWaysByPatienceId(int id_patience,String orderBy);
}
