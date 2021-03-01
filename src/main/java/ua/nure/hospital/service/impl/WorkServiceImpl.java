package ua.nure.hospital.service.impl;

import ua.nure.hospital.db.DAO.WorkDAO;
import ua.nure.hospital.entity.Work;
import ua.nure.hospital.service.WorkService;

import java.util.List;

public class WorkServiceImpl implements WorkService {
    private final WorkDAO dao;

    public WorkServiceImpl(WorkDAO dao) {
        this.dao = dao;
    }

    @Override
    public boolean addWork(Work work) {
        return dao.addWork(work);
    }

    @Override
    public List<Work> getAllWorks() {
        return dao.getAllWorks();
    }

    @Override
    public boolean updateWork(Work work) {
        return dao.updateWork(work);
    }

    @Override
    public List<Work> getAllDoctorsWorks() {
        return dao.getAllDoctorsWorks();
    }

}
