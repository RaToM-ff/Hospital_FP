package ua.nure.hospital.service;

import ua.nure.hospital.entity.PatienceCardRecord;

import java.util.List;

public interface PatienceCardRecordService {
    boolean addPatienceCardRecordForDoctor(PatienceCardRecord patienceCardRecord);

    boolean addPatienceCardRecordForNurse(PatienceCardRecord patienceCardRecord);

    boolean updatePatienceCardRecordForDoctorById(PatienceCardRecord patienceCardRecord);

    boolean updatePatienceCardRecordForNurseById(PatienceCardRecord patienceCardRecord);

    List<PatienceCardRecord> getAllPatienceCardRecordsByIdPatienceAndIdPersonal(int id_patience, int id_personal);

    List<PatienceCardRecord> getAllPatienceCardRecordsByIdPatienceOrderBy(int id_patience, String orderBy);

    boolean deletePatienceCardRecordForDoctorById(int id);

    List<PatienceCardRecord> getAllPatienceCardRecordsByIdDoctorOrderBy(int id_doctor, String orderBy);

    PatienceCardRecord getPatienceCardRecordsById(int id_cardRecord);
}
