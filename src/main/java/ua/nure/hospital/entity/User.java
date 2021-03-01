package ua.nure.hospital.entity;

import java.util.Date;
import java.util.Objects;

public class User {

    private int id;
    private String login;
    private String password;
    private Status status;
    private Work work;
    private String name;
    private String sername;
    private String patronymic;
    private Date birthday;
    private int activePatience;//for doctor
    private int completePatience;//for doctor
    private Date dateCome;//for patience
    private int idWay;//for patience

    public User(int id, String login, String password, Status status, Work work, String name, String sername, String patronymic, Date birthday, int activePatience, int completePatience, Date dateCome) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.status = status;
        this.work = work;
        this.name = name;
        this.sername = sername;
        this.patronymic = patronymic;
        this.birthday = birthday;
        this.activePatience = activePatience;
        this.completePatience = completePatience;
        this.dateCome = dateCome;
    }

    public User(String login, String password, Status status, Work work, String name, String sername, String patronymic, Date birthday, int activePatience, int completePatience, Date dateCome) {
        this.login = login;
        this.password = password;
        this.status = status;
        this.work = work;
        this.name = name;
        this.sername = sername;
        this.patronymic = patronymic;
        this.birthday = birthday;
        this.activePatience = activePatience;
        this.completePatience = completePatience;
        this.dateCome = dateCome;
    }

    public User() {
    }

    public int getIdWay() {
        return idWay;
    }

    public void setIdWay(int idWay) {
        this.idWay = idWay;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Work getWork() {
        return work;
    }

    public void setWork(Work work) {
        this.work = work;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSername() {
        return sername;
    }

    public void setSername(String sername) {
        this.sername = sername;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getActivePatience() {
        return activePatience;
    }

    public void setActivePatience(int activePatience) {
        this.activePatience = activePatience;
    }

    public int getCompletePatience() {
        return completePatience;
    }

    public void setCompletePatience(int completePatience) {
        this.completePatience = completePatience;
    }

    public Date getDateCome() {
        return dateCome;
    }

    public void setDateCome(Date dateCome) {
        this.dateCome = dateCome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", status=" + status +
                ", work=" + work +
                ", name='" + name + '\'' +
                ", sername='" + sername + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", birthday=" + birthday +
                ", activePatience=" + activePatience +
                ", completePatience=" + completePatience +
                ", dateCome=" + dateCome +
                '}';
    }
}
