package com.example.practiceproject.repository;

import com.example.practiceproject.entity.Tutorial;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TutorialRepositoryTest {
    @Autowired
    private TutorialRepository tutorialRepository;

    @BeforeEach
    void init(){
        Tutorial newTutorial_1 = new Tutorial(1,"Title_test_1", "Description_1",true);
        Tutorial newTutorial_2 = new Tutorial(2,"Title_test_2", "Description_2",false);
        tutorialRepository.save(newTutorial_1);
        tutorialRepository.save(newTutorial_2);
    }
    @AfterEach
    void tearDown(){
        tutorialRepository.deleteAll();
    }
    @Test
    void getTutorialByPublished(){
        if(tutorialRepository.findByPublished(true).isEmpty()){
            assertThatNullPointerException();
        }
        else{
            List<Tutorial> tutorialList = tutorialRepository.findByPublished(true);
            assertThat(tutorialList).isNotNull();
        }
    }
    @Test
    void getTutorialByTitleContaining(){
        if(tutorialRepository.findByTitleContaining("Title_test_1").isEmpty()){
            assertThatNullPointerException();
        }
        else{
            List<Tutorial> tutorialList = tutorialRepository.findByTitleContaining("title_1");
            assertThat(tutorialList).isNotNull();
        }
    }
    @Test
    void deleteTutorial(){
        if(tutorialRepository.findById(1L).isPresent()) {
            tutorialRepository.deleteById(1L);
            assertThat(tutorialRepository.findById(1L)).isEmpty();
        }
        else{
            assertThatNullPointerException();
        }
    }
    @Test
    void deleteAllTutorial(){
        List<Tutorial> tutorialList = tutorialRepository.findAll();
        if(tutorialList.size() != 0){
            tutorialRepository.deleteAll();
            tutorialList = tutorialRepository.findAll();
            assertThat(tutorialList).isEmpty();
        }
        else {
            assertThatException();
        }
    }
    @Test
    void updateTutorial(){
        if(tutorialRepository.findById(1L).isPresent()) {
            Tutorial tutorial = tutorialRepository.findById(1L).get();
            tutorial.setTitle("Changed_title_1");
            tutorial.setDescription("Changed_description_1");
            tutorialRepository.save(tutorial);
            assertEquals(tutorialRepository.findById(1L).get(), tutorial);
        }
        else{
            assertThatException();
        }
    }

}
