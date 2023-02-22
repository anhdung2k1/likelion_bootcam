package com.example.practiceproject.service;

import com.example.practiceproject.entity.Tutorial;
import com.example.practiceproject.repository.TutorialRepository;
import com.example.practiceproject.service.impl.TutorialServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TutorialServiceTest {
    @Mock
    private TutorialRepository tutorialRepository;
    @InjectMocks
    private TutorialServiceImpl tutorialService;

    @Test
    void findAllTutorial(){
        List<Tutorial> tutorials = new ArrayList<>();
        tutorials.add(new Tutorial(1l, "Test tutorial 1", "This is a test tutorial 1", true));
        tutorials.add(new Tutorial(2l, "Test tutorial 2", "This is a test tutorial 2", false));

        when(tutorialRepository.findAll()).thenReturn(tutorials);

        List<Tutorial> temp = tutorialService.findAll();

        assertEquals("Test tutorial 1", temp.get(0).getTitle());
        assertEquals("This is a test tutorial 2", temp.get(1).getDescription());
    }
    @Test
    void findByTitleContaining() {
        List<Tutorial> tutorials = new ArrayList<>();
        tutorials.add(new Tutorial(1l, "Test tutorial 1", "This is a test tutorial 1", true));

        when(tutorialRepository.findByTitleContaining("Test tutorial 1")).thenReturn(tutorials);

        assertThat(tutorialService.findByTitleContaining("Test tutorial 1")).isNotNull();
    }

    @Test
    void findById() {
        when(tutorialRepository.findById(1L))
                .thenReturn(Optional.of(new Tutorial(1L, "Title Testing 1", "Description 1", true)));
        assertThat(tutorialService.findById(1l).getId()).isEqualTo(1L);
        assertThat(tutorialService.findById(1L).getTitle()).isEqualTo("Title Testing 1");
    }

    @Test
    void deleteById() {
        tutorialService.deleteById(1l);
        verify(tutorialRepository).deleteById(1l);
    }

    @Test
    void deleteAll() {
        tutorialService.deleteAll();
        verify(tutorialRepository).deleteAll();
    }

    @Test
    void findByPublished() {
        List<Tutorial> tutorials = new ArrayList<>();
        tutorials.add(new Tutorial(1l, "Test tutorial 1", "This is a test tutorial 1", true));

        when(tutorialRepository.findByPublished(true)).thenReturn(tutorials);
        List<Tutorial> returnedTutorials = tutorialService.findByPublished(true);

        assertThat(returnedTutorials.get(0).getId()).isEqualTo(1l);
    }

    @Test
    void saveTutorial() {
        Tutorial tutorial = new Tutorial(1l, "Test tutorial 1", "This is a test tutorial 1", true);

        when(tutorialRepository.save(tutorial)).thenReturn(tutorial);

        assertThat(tutorialService.saveTutorial(tutorial)).isNotNull();
    }
}
