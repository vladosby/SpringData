package com.spring.data.repositories;

import com.spring.data.config.JavaConfig;
import com.spring.data.entities.Speaker;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by vlados on 9/5/2016.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = JavaConfig.class)
@Transactional
public class PagingAndSortingSpeakerRepositoryTest {
    @Autowired
    private PagingAndSortingSpeakerRepository speakerRepository;

    @Before
    @Rollback(false)
    public void setUp() {
        speakerRepository.save(UnitDataUtils.initSpeakers());
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
        Iterable<Speaker> speakers = speakerRepository.findAll(new Sort(Sort.Direction.ASC, "name"));
        speakers.forEach(System.out::println);
        System.out.println("----------------------------------");
    }

    @After
    public void clean() {
        speakerRepository.deleteAll();
    }
}