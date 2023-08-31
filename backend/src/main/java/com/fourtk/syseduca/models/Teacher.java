package com.fourtk.syseduca.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_teachers")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String teacherTitle;
    private String descriptionTitle;
    private String teacherStatus;
    @ManyToMany
    @JoinTable( name = "tb_teacher_discipline",
            joinColumns = @JoinColumn(name = "teacher_id"),
            inverseJoinColumns = @JoinColumn(name = "discipline_id"))
    Set<Discipline> teacherLearningDiscipline = new HashSet<>();

}
