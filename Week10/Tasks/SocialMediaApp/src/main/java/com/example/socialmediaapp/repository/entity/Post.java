package com.example.socialmediaapp.repository.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;


@Table(name = "posts")
@Entity(name = "post")
@Data
@EqualsAndHashCode(callSuper = true)
public class Post extends BaseEntity{

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String content;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @JsonBackReference
    private User author;

    @OneToMany(mappedBy = "post")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @JsonManagedReference
    private List<Comment> comments;

    @OneToMany(mappedBy = "post")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @JsonManagedReference
    private List<Like> likes;
}
