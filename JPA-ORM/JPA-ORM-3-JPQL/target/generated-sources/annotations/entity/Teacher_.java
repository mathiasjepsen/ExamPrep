package entity;

import entity.Semester;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-01-10T10:36:36")
@StaticMetamodel(Teacher.class)
public class Teacher_ { 

    public static volatile SingularAttribute<Teacher, String> firstname;
    public static volatile SingularAttribute<Teacher, Long> id;
    public static volatile ListAttribute<Teacher, Semester> semesterList;
    public static volatile SingularAttribute<Teacher, String> lastname;

}