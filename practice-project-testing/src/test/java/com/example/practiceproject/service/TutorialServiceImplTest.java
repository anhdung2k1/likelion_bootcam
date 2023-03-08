package com.example.practiceproject.service;

import com.example.practiceproject.entity.Tutorial;
import com.example.practiceproject.repository.TutorialRepository;
import com.example.practiceproject.service.impl.TutorialServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class TutorialServiceImplTest {
    @Mock
    private TutorialRepository tutorialRepository;
    @InjectMocks
    private TutorialServiceImpl tutorialService;
    @Test
    void findAll(){
        List<Tutorial> tutorials = new ArrayList<>();
        tutorials.add(new Tutorial(1l, "Test tutorial 1", "This is a test tutorial 1", true));
        tutorials.add(new Tutorial(2l, "Test tutorial 2", "This is a test tutorial 2", false));

        when(tutorialRepository.findAll()).thenReturn(tutorials);
        List<Tutorial> tmp = tutorialService.findAll();
        verify(tutorialRepository).findAll();

        assertEquals(2, tmp.size());
        assertEquals(1l, tmp.get(0).getId());
        assertEquals("Test tutorial 1", tmp.get(0).getTitle());
    }
    @Test
    void findByTitleContaining(){
        List<Tutorial> tutorials = new ArrayList<>();
        tutorials.add(new Tutorial(1l, "Test tutorial 1", "This is a test tutorial 1", true));

        when(tutorialRepository.findByTitleContaining("Test tutorial 1")).thenReturn(tutorials);
        List<Tutorial>tmp = tutorialService.findByTitleContaining("Title_test_1");
        verify(tutorialRepository).findByTitleContaining("Title_test_1");
        assertThat(tmp).isNotNull();
    }
    @Test
    void findById(){
        when(tutorialRepository.findById(1l))
                .thenReturn(Optional.of(new Tutorial(1l, "Title 1", "Description 1", true)));
        Tutorial tutorial = tutorialService.findById(1L);
        verify(tutorialRepository).findById(1L);

        assertThat(tutorial.getTitle()).isEqualTo("Title 1");
    }
    @Test
    void saveTutorial(){
        Tutorial newTutorial_1 = new Tutorial(1,"Title_test_1", "Description_1",true);
        tutorialService.saveTutorial(newTutorial_1);
        ArgumentCaptor<Tutorial> tutorialArgumentCaptor = ArgumentCaptor.forClass(Tutorial.class);
        verify(tutorialRepository).save(tutorialArgumentCaptor.capture());
        verify(tutorialRepository).save(tutorialArgumentCaptor.capture());
        Tutorial capturedTutorial = tutorialArgumentCaptor.getValue();
        assertThat(capturedTutorial).isEqualTo(newTutorial_1);
    }
    @Test
    void deleteById(){
        tutorialService.deleteById(1L);
        verify(tutorialRepository).deleteById(1L);
    }
    @Test
    void deleteAll(){
        tutorialService.deleteAll();
        verify(tutorialRepository).deleteAll();
    }
}
