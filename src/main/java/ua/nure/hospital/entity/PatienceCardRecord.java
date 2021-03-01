package ua.nure.hospital.entity;

import java.util.Date;
import java.util.Objects;

public class PatienceCardRecord {
    private int id;
    private User doctor;
    private User patience;
    private String procedures;
    private String medicines;
    private String operations;
    private String diagnosis;
    private Date date_of_set;

    public PatienceCardRecord(int id, User doctor, User patience, String procedures, String medicines, String operations, String diagnosis, Date date_of_set) {
        this.id = id;
        this.doctor = doctor;
        this.patience = patience;
        this.procedures = procedures;
        this.medicines = medicines;
        this.operations = operations;
        this.diagnosis = diagnosis;
        this.date_of_set = date_of_set;
    }

    public PatienceCardRecord(User doctor, User patience, String procedures, String medicines, String operations, String diagnosis, Date date_of_set) {
        this.doctor = doctor;
        this.patience = patience;
        this.procedures = procedures;
        this.medicines = medicines;
        this.operations = operations;
        this.diagnosis = diagnosis;
        this.date_of_set = date_of_set;
    }

    public PatienceCardRecord() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getDoctor() {
        return doctor;
    }

    public void setDoctor(User doctor) {
        this.doctor = doctor;
    }

    public User getPatience() {
        return patience;
    }

    public void setPatience(User patience) {
        this.patience = patience;
    }

    public String getProcedures() {
        return procedures;
    }

    public void setProcedures(String procedures) {
        this.procedures = procedures;
    }

    public String getMedicines() {
        return medicines;
    }

    public void setMedicines(String medicines) {
        this.medicines = medicines;
    }

    public String getOperations() {
        return operations;
    }

    public void setOperations(String operations) {
        this.operations = operations;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public Date getDate_of_set() {
        return date_of_set;
    }

    public void setDate_of_set(Date date_of_set) {
        this.date_of_set = date_of_set;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PatienceCardRecord that = (PatienceCardRecord) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "PatienceCardRecord{" +
                "id=" + id +
                ", doctor=" + doctor +
                ", patience=" + patience +
                ", procedure='" + procedures + '\'' +
                ", medicines='" + medicines + '\'' +
                ", operations='" + operations + '\'' +
                ", diagnosis='" + diagnosis + '\'' +
                ", date_of_set=" + date_of_set +
                '}';
    }
}
