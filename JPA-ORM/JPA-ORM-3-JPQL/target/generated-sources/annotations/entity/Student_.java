package entity;

import entity.Semester;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-01-10T10:36:36")
@StaticMetamodel(Student.class)
public class Student_ { 

    public static volatile SingularAttribute<Student, String> firstname;
    public static volatile SingularAttribute<Student, Semester> currentsemesterId;
    public static volatile SingularAttribute<Student, Long> id;
    public static volatile SingularAttribute<Student, String> lastname;

}