package com.example.practiceproject.service.impl;

import com.example.practiceproject.entity.Tutorial;
import com.example.practiceproject.repository.TutorialRepository;
import com.example.practiceproject.service.TutorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TutorialServiceImpl implements TutorialService {
    @Autowired
    private TutorialRepository tutorialRepository;


    @Override
    public List<Tutorial> findAll() {
        return tutorialRepository.findAll();
    }

    @Override
    public List<Tutorial> findByTitleContaining(String title) {
        return tutorialRepository.findByTitleContaining(title);
    }

    @Override
    public Tutorial findById(long id) {
        return tutorialRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(long id) {
        tutorialRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        tutorialRepository.deleteAll();
    }

    @Override
    public List<Tutorial> findByPublished(boolean b) {
        return tutorialRepository.findByPublished(b);
    }

    @Override
    public Tutorial saveTutorial(Tutorial tutorial) {
        return tutorialRepository.save(tutorial);
    }
}
