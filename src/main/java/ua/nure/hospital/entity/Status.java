package ua.nure.hospital.entity;

import java.util.Objects;

public class Status {
    private int id;
    private String statusName;

    public Status() {
    }

    public Status(String statusName) {
        this.statusName = statusName;
    }

    public Status(int id, String statusName) {
        this.id = id;
        this.statusName = statusName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String status_name) {
        this.statusName = status_name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Status status = (Status) o;
        return id == status.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Status{" +
                "id=" + id +
                ", statusName='" + statusName + '\'' +
                '}';
    }
}
