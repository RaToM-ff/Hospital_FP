package ua.nure.hospital.service.impl;

import ua.nure.hospital.db.DAO.StatusDAO;
import ua.nure.hospital.entity.Status;
import ua.nure.hospital.service.StatusService;

import java.util.List;

public class StatusServiceImpl implements StatusService {
    private final StatusDAO dao;

    public StatusServiceImpl(StatusDAO dao) {
        this.dao = dao;
    }

    @Override
    public List<Status> getAllStatuses() {
        return dao.getAllStatuses();
    }

    @Override
    public Status getStatusByName(String name) {
        return dao.getStatusByName(name);
    }

    @Override
    public Status getStatusById(int id) {
        return dao.getStatusById(id);
    }
}
