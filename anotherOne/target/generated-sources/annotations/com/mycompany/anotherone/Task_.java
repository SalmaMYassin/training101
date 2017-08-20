package com.mycompany.anotherone;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-08-20T13:35:32")
@StaticMetamodel(Task.class)
public class Task_ { 

    public static volatile SingularAttribute<Task, String> task;
    public static volatile SingularAttribute<Task, Date> due;
    public static volatile SingularAttribute<Task, String> details;
    public static volatile SingularAttribute<Task, Integer> id;
    public static volatile SingularAttribute<Task, Boolean> done;

}