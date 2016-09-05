package com.spring.data.repositories;

import com.spring.data.entities.Speaker;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by vlados on 9/5/2016.
 */

public interface SpeakerRepository extends CrudRepository<Speaker, Long> {
    Speaker findByName(String name);
    List<Speaker> findPleaseByNameLike(String nameLike);
    List<Speaker> findByNameEndingWith(String suffix);
}
