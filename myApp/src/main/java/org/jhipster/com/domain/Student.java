package org.jhipster.com.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A Student.
 */
@Entity
@Table(name = "student")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "email_address")
    private String emailAddress;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "graduation_date")
    private LocalDate graduationDate;

    @OneToMany(mappedBy = "student")
    @JsonIgnore
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<PreferredContact> preferredContacts = new HashSet<>();

    @ManyToOne
    private Dormitory dormitory;

    @ManyToOne
    private School school;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public Student fullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public Student emailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        return this;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Student phoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getGraduationDate() {
        return graduationDate;
    }

    public Student graduationDate(LocalDate graduationDate) {
        this.graduationDate = graduationDate;
        return this;
    }

    public void setGraduationDate(LocalDate graduationDate) {
        this.graduationDate = graduationDate;
    }

    public Set<PreferredContact> getPreferredContacts() {
        return preferredContacts;
    }

    public Student preferredContacts(Set<PreferredContact> preferredContacts) {
        this.preferredContacts = preferredContacts;
        return this;
    }

    public Student addPreferredContact(PreferredContact preferredContact) {
        preferredContacts.add(preferredContact);
        preferredContact.setStudent(this);
        return this;
    }

    public Student removePreferredContact(PreferredContact preferredContact) {
        preferredContacts.remove(preferredContact);
        preferredContact.setStudent(null);
        return this;
    }

    public void setPreferredContacts(Set<PreferredContact> preferredContacts) {
        this.preferredContacts = preferredContacts;
    }

    public Dormitory getDormitory() {
        return dormitory;
    }

    public Student dormitory(Dormitory dormitory) {
        this.dormitory = dormitory;
        return this;
    }

    public void setDormitory(Dormitory dormitory) {
        this.dormitory = dormitory;
    }

    public School getSchool() {
        return school;
    }

    public Student school(School school) {
        this.school = school;
        return this;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Student student = (Student) o;
        if(student.id == null || id == null) {
            return false;
        }
        return Objects.equals(id, student.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Student{" +
            "id=" + id +
            ", fullName='" + fullName + "'" +
            ", emailAddress='" + emailAddress + "'" +
            ", phoneNumber='" + phoneNumber + "'" +
            ", graduationDate='" + graduationDate + "'" +
            '}';
    }
}
