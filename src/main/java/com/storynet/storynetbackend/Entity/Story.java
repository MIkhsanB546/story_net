package com.storynet.storynetbackend.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
@Entity
@Table(name = "tbl_Story")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Story implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "storyId")
    private int id;

    @NotEmpty(message = "Title is required")
    @Column(name = "story_title", length = 100)
    private String title;

    @NotEmpty(message = "Description is required")
    @Column(name = "story_desription", length = 1000)
    private String description;

}
