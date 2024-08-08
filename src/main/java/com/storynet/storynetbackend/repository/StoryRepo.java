package com.storynet.storynetbackend.repository;

import com.storynet.storynetbackend.Entity.Story;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StoryRepo extends JpaRepository<Story, Integer> {
    List<Story> findAllByTitle(String title);
}
