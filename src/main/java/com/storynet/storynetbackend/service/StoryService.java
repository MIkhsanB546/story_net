package com.storynet.storynetbackend.service;

import com.storynet.storynetbackend.Entity.Story;
import com.storynet.storynetbackend.repository.StoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StoryService {
    @Autowired
    private StoryRepo storyRepo;

    public Story save(Story story) {
        return storyRepo.save(story);
    }

    public List<Story> findAllStories() {
        return storyRepo.findAll();
    }

    public Story findStoryById(int id) {
        Optional<Story> story = storyRepo.findById(id);
        return story.orElse(null);
    }

    public List<Story> findStoriesByTitle(String title) {
        return storyRepo.findAllByTitle(title);
    }

    public void deleteStory(int id) {
        storyRepo.deleteById(id);
    }

}
