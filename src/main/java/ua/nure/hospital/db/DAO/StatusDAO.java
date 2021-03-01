package ua.nure.hospital.db.DAO;

import ua.nure.hospital.entity.Status;

import java.util.List;

public interface StatusDAO {

    List<Status> getAllStatuses();

    Status getStatusByName(String name);

    Status getStatusById(int id);

}
