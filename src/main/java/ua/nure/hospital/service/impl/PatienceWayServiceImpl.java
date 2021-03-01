package ua.nure.hospital.service.impl;

import ua.nure.hospital.db.DAO.PatienceWayDAO;
import ua.nure.hospital.entity.PatienceWay;
import ua.nure.hospital.service.PatienceWayService;

import java.util.List;

public class PatienceWayServiceImpl implements PatienceWayService {
    private final PatienceWayDAO dao;

    public PatienceWayServiceImpl(PatienceWayDAO dao) {
        this.dao = dao;
    }

    @Override
    public boolean addPatienceWay(PatienceWay patienceWay) {
        return dao.addPatienceWay(patienceWay);
    }

    @Override
    public boolean updatePatienceWay(PatienceWay patienceWay) {
        return dao.updatePatienceWay(patienceWay);
    }

    @Override
    public boolean updatePatienceWayToFinal(PatienceWay patienceWay) {
        return dao.updatePatienceWayToFinal(patienceWay);
    }

    @Override
    public List<PatienceWay> getPatienceWayForPatienceNotFinish(int id_patience) {
        return dao.getAllPatienceWays(id_patience);
    }

    @Override
    public List<PatienceWay> getFinalWayForDoctorWithOrder(int id_doctor) {
        return dao.getFinalWayForDoctorWithOrder(id_doctor);
    }

    @Override
    public List<PatienceWay> getPatienceWayForPatienceFinish(int id_patience) {
        return dao.getPatienceWayForPatienceFinish(id_patience);
    }

    @Override
    public List<PatienceWay> getAllPatienceWays(String orderBy) {
        return dao.getAllPatienceWays(orderBy);
    }

    @Override
    public PatienceWay getPatienceWayById(int idPatienceWay) {
        return dao.getPatienceWayById(idPatienceWay);
    }

    @Override
    public boolean deletePatienceWayById(int id) {
        return dao.deletePatienceWayById(id);
    }

    @Override
    public List<PatienceWay> getAllPatienceWaysByPatienceId(int id_patience, String orderBy) {
        return dao.getAllPatienceWaysByPatienceId(id_patience, orderBy);
    }
}
