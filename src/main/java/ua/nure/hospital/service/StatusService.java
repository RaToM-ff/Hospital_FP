package ua.nure.hospital.service;

import ua.nure.hospital.entity.Status;

import java.util.List;

public interface StatusService {

    List<Status> getAllStatuses();

    Status getStatusByName(String name);

    Status getStatusById(int id);

}
