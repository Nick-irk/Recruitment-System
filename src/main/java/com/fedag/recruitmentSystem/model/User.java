package com.fedag.recruitmentSystem.model;


import com.fedag.recruitmentSystem.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name")
    private String firstname;

    @Column(name = "last_name")
    private String lastname;

    @Column(name = "email")
    private String email;

    @Column(name = "birthday")
    private LocalDateTime birthday;

    @Column(name="role")
    private Role role;

    @Column(name = "password")
    private String password;

    @OneToOne(
            cascade = CascadeType.ALL,
            mappedBy = "user")
    private Exam exam;

    @OneToMany(
            cascade = CascadeType.ALL,
            mappedBy = "user")
    private List<UserFeedback> userFeedbackList;

    @OneToMany(
            cascade = CascadeType.ALL,
            mappedBy = "user")
    private List<Resume> resumeList;

    @OneToMany(mappedBy = "user")
    private List<VacancyResponse> vacancyResponseList;

    @OneToMany(mappedBy = "user")
    private List<Message> messageList;

    public User(String firstname, String lastname, String email,
                LocalDateTime birthday, Role role, String password) {
        this.firstname=firstname;
        this.lastname=lastname;
        this.email=email;
        this.birthday=birthday;
        this.role=role;
        this.password=password;
    }
}

