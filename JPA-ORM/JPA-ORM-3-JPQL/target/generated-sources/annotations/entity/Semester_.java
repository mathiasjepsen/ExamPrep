package entity;

import entity.Student;
import entity.Teacher;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-01-10T10:36:36")
@StaticMetamodel(Semester.class)
public class Semester_ { 

    public static volatile SingularAttribute<Semester, String> name;
    public static volatile ListAttribute<Semester, Student> studentList;
    public static volatile SingularAttribute<Semester, String> description;
    public static volatile ListAttribute<Semester, Teacher> teacherList;
    public static volatile SingularAttribute<Semester, Long> id;

}