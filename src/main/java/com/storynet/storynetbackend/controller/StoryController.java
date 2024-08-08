package com.storynet.storynetbackend.controller;

import com.storynet.storynetbackend.Entity.Story;
import com.storynet.storynetbackend.dto.ResponseData;
import com.storynet.storynetbackend.service.StoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/s")
public class StoryController {
    @Autowired
    private StoryService storyService;

    @PostMapping
    public ResponseEntity<ResponseData<Story>> createStory(@Valid @RequestBody Story story, Errors errors) {
        ResponseData<Story> responseData = new ResponseData<>();

        if (errors.hasErrors()) {
            for (ObjectError error : errors.getAllErrors()) {
                responseData.getMessages().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
        responseData.setStatus(true);
        responseData.setPayload(storyService.save(story));
        return ResponseEntity.ok(responseData);
    }

    @GetMapping
    public List<Story> findAllStories() {
        return storyService.findAllStories();
    }

    @GetMapping("/{id}")
    public Story findStoryById(@PathVariable int id) {
        return storyService.findStoryById(id);
    }

    @PutMapping
    public ResponseEntity<ResponseData<Story>> updateStory(@Valid @RequestBody Story story, Errors errors) {
        ResponseData<Story> responseData = new ResponseData<>();

        if (errors.hasErrors()) {
            for (ObjectError error : errors.getAllErrors()) {
                responseData.getMessages().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
        responseData.setStatus(true);
        responseData.setPayload(storyService.save(story));
        return ResponseEntity.ok(responseData);
    }

    @DeleteMapping("/{id}")
    public void deleteStory(@PathVariable int id) {
        storyService.deleteStory(id);
    }
}
