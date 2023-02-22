package com.example.practiceproject.repository;

import com.example.practiceproject.entity.Tutorial;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TutorialRepositoryTest {
    @Autowired
    private TutorialRepository tutorialRepository;
    @BeforeEach
    void init(){
        tutorialRepository.save(new Tutorial(1L, "Title 1", "Title 1 Description", true));
        tutorialRepository.save(new Tutorial(2L, "Title 2", "Title 2 Description", true));
        tutorialRepository.save(new Tutorial(3L, "Title 3", "Title 3 Description", false));
    }
    @AfterEach
    void tearDown() {
        tutorialRepository.deleteAll();
    }
    @Test
    void findById() {
        assertThat(tutorialRepository.findById(1l)).isNotNull();
    }

    @Test
    void findByPublished() {
        List<Tutorial> tutorialList = new ArrayList<>();
        tutorialList.add(new Tutorial(1L, "Title 1", "Title 1 Description", true));
        tutorialList.add(new Tutorial(3L, "Title 3", "Title 3 Description", false));
        assertThat(tutorialRepository.findByPublished(true).get(0).getDescription())
                .isEqualTo(tutorialList.get(0).getDescription());
        assertThat(tutorialRepository.findByPublished(false).get(0).getTitle())
                .isEqualTo(tutorialList.get(1).getTitle());
    }
    @Test
    void findByTitleContainingIgnoreCase() {
        Tutorial tutorial = new Tutorial(1l, "Title 1", "Title 1 Description", true);
        assertThat(tutorialRepository.findByTitleContaining("Title 1").get(0).getDescription())
                .isEqualTo(tutorial.getDescription());
    }

    @Test
    void deleteAll() {
        tutorialRepository.deleteAll();
        assertThat(tutorialRepository.findAll().isEmpty());
    }
}
