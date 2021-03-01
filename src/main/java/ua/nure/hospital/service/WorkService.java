package ua.nure.hospital.service;

import ua.nure.hospital.entity.Work;

import java.util.List;

public interface WorkService {

    boolean addWork(Work work);

    List<Work> getAllWorks();

    boolean updateWork(Work work);

    List<Work> getAllDoctorsWorks();

}
