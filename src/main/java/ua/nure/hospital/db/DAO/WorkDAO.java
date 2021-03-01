package ua.nure.hospital.db.DAO;

import ua.nure.hospital.entity.Work;

import java.util.List;

public interface WorkDAO {

    boolean addWork(Work work);

    List<Work> getAllWorks();

    List<Work> getAllDoctorsWorks();

    boolean updateWork(Work work);
}
