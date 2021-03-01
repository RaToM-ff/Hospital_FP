package ua.nure.hospital.entity;

import java.util.Objects;

public class Work {
    private int id;
    private String name;

    public Work(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Work(String name) {
        this.name = name;
    }

    public Work() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Work work = (Work) o;
        return id == work.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Work{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
