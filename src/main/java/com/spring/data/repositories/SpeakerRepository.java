package com.spring.data.repositories;

import com.spring.data.entities.Speaker;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by vlados on 9/5/2016.
 */

public interface SpeakerRepository extends CrudRepository<Speaker, Long> {
    Speaker findByName(String name);
}
