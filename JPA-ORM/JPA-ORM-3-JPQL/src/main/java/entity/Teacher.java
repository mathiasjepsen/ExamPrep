/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author mathiasjepsen
 */
@Entity
@Table(name = "TEACHER")
@NamedQueries({
    @NamedQuery(name = "Teacher.findAll", query = "SELECT t FROM Teacher t")
    , @NamedQuery(name = "Teacher.findById", query = "SELECT t FROM Teacher t WHERE t.id = :id")
    , @NamedQuery(name = "Teacher.findByFirstname", query = "SELECT t FROM Teacher t WHERE t.firstname = :firstname")
    , @NamedQuery(name = "Teacher.findByLastname", query = "SELECT t FROM Teacher t WHERE t.lastname = :lastname")})
public class Teacher implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Column(name = "FIRSTNAME")
    private String firstname;
    @Column(name = "LASTNAME")
    private String lastname;
    @JoinTable(name = "TEACHER_SEMESTER", joinColumns = {
        @JoinColumn(name = "teachers_ID", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "teaching_ID", referencedColumnName = "ID")})
    @ManyToMany
    private List<Semester> semesterList;

    public Teacher() {
    }

    public Teacher(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public List<Semester> getSemesterList() {
        return semesterList;
    }

    public void setSemesterList(List<Semester> semesterList) {
        this.semesterList = semesterList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Teacher)) {
            return false;
        }
        Teacher other = (Teacher) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Teacher[ id=" + id + " ]";
    }
    
}
