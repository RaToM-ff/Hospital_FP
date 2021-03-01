package ua.nure.hospital.entity;

import java.util.Date;
import java.util.Objects;

public class PatienceWay {
    private int id;
    private User doctor;
    private User patience;
    private String diagnosis;
    private String documentWay;
    private Date date_come;
    private Date date_out;

    public PatienceWay(int id, User doctor, User patience, String diagnosis, String documentWay, Date date_come, Date date_out) {
        this.id = id;
        this.doctor = doctor;
        this.patience = patience;
        this.diagnosis = diagnosis;
        this.documentWay = documentWay;
        this.date_come = date_come;
        this.date_out = date_out;
    }

    public PatienceWay(User doctor, User patience, String diagnosis, String documentWay, Date date_come, Date date_out) {
        this.doctor = doctor;
        this.patience = patience;
        this.diagnosis = diagnosis;
        this.documentWay = documentWay;
        this.date_come = date_come;
        this.date_out = date_out;
    }

    public PatienceWay() {
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

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getDocumentWay() {
        return documentWay;
    }

    public void setDocumentWay(String documentWay) {
        this.documentWay = documentWay;
    }

    public Date getDate_come() {
        return date_come;
    }

    public void setDate_come(Date date_come) {
        this.date_come = date_come;
    }

    public Date getDate_out() {
        return date_out;
    }

    public void setDate_out(Date date_out) {
        this.date_out = date_out;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PatienceWay that = (PatienceWay) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "PatienceWay{" +
                "id=" + id +
                ", doctor=" + doctor +
                ", patience=" + patience +
                ", diagnosis='" + diagnosis + '\'' +
                ", documentWay='" + documentWay + '\'' +
                ", date_come=" + date_come +
                ", date_out=" + date_out +
                '}';
    }
}
