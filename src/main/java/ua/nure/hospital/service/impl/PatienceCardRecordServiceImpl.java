package ua.nure.hospital.service.impl;

import ua.nure.hospital.db.DAO.PatientCardRecordDAO;
import ua.nure.hospital.entity.PatienceCardRecord;
import ua.nure.hospital.service.PatienceCardRecordService;

import java.util.List;

public class PatienceCardRecordServiceImpl implements PatienceCardRecordService {
    private final PatientCardRecordDAO dao;

    public PatienceCardRecordServiceImpl(PatientCardRecordDAO dao) {
        this.dao = dao;
    }

    @Override
    public boolean addPatienceCardRecordForDoctor(PatienceCardRecord patienceCardRecord) {
        return dao.addPatienceCardRecordForDoctor(patienceCardRecord);
    }

    @Override
    public boolean addPatienceCardRecordForNurse(PatienceCardRecord patienceCardRecord) {
        return dao.addPatienceCardRecordForNurse(patienceCardRecord);
    }

    @Override
    public boolean updatePatienceCardRecordForDoctorById(PatienceCardRecord patienceCardRecord) {
        return dao.updatePatienceCardRecordForDoctorById(patienceCardRecord);
    }

    @Override
    public boolean updatePatienceCardRecordForNurseById(PatienceCardRecord patienceCardRecord) {
        return dao.updatePatienceCardRecordForNurseById(patienceCardRecord);
    }

    @Override
    public List<PatienceCardRecord> getAllPatienceCardRecordsByIdPatienceAndIdPersonal(int id_patience, int id_personal) {
        return dao.getAllPatienceCardRecordsByIdPatienceAndIdPersonal(id_patience, id_personal);
    }

    @Override
    public List<PatienceCardRecord> getAllPatienceCardRecordsByIdPatienceOrderBy(int id_patience, String orderBy) {
        return dao.getAllPatienceCardRecordsByIdPatienceOrderBy(id_patience, orderBy);
    }

    @Override
    public boolean deletePatienceCardRecordForDoctorById(int id) {
        return dao.deletePatienceCardRecordForDoctorById(id);
    }

    @Override
    public List<PatienceCardRecord> getAllPatienceCardRecordsByIdDoctorOrderBy(int id_doctor, String orderBy) {
        return dao.getAllPatienceCardRecordsByIdDoctorOrderBy(id_doctor, orderBy);
    }

    @Override
    public PatienceCardRecord getPatienceCardRecordsById(int id_cardRecord) {
        return dao.getPatienceCardRecordsById(id_cardRecord);
    }
}
