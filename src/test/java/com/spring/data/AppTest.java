package com.spring.data;

import com.spring.data.config.JavaConfig;
import com.spring.data.entities.Speaker;
import com.spring.data.entities.Talk;
import com.spring.data.repositories.SpeakerRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Date;

/**
 * Created by vlados on 9/5/2016.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = JavaConfig.class)
@Transactional
public class AppTest {
    @Autowired
    private SpeakerRepository speakerRepository;

    @Before
    @Rollback(false)
    public void setUp() {
        Speaker ivanov = new Speaker("Ivanov Ivan");

        Speaker semenov = new Speaker("Semenov Semen");
        semenov.addTalk(new Talk(new Date(100000), "Talk of Semenov number 1"));
        semenov.addTalk(new Talk(new Date(120000), "Talk of Semenov number 2"));

        Speaker petrov = new Speaker("Petrov Petr");
        petrov.addTalk(new Talk(new Date(140000), "Talk of Petrov number 1"));

        Speaker kozlov = new Speaker("Kozlov Vasya");
        kozlov.addTalk(new Talk(new Date(160000), "Talk of Kozlov number 1"));
        kozlov.addTalk(new Talk(new Date(180000), "Talk of Kozlov number 2"));
        speakerRepository.save(Arrays.asList(ivanov, semenov, petrov, kozlov));
    }

    @Test
    public void testCount() {
        System.out.println("----------------------------------");
        System.out.printf("Speaker count %d\n", speakerRepository.count());
        System.out.println("----------------------------------");
    }

    @Test
    public void testFindAll() {
        System.out.println("----------------------------------");
        Iterable<Speaker> speakers = speakerRepository.findAll();
        speakers.forEach(System.out::println);
        System.out.println("----------------------------------");
    }

//    @Test
//    public void testFindByName() {
//        System.out.println("----------------------------------");
//        System.out.println("----------------------------------");
//    }

    @After
    public void clean() {
        speakerRepository.deleteAll();
    }
}
