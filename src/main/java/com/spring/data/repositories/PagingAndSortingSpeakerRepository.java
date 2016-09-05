package com.spring.data.repositories;


import com.spring.data.entities.Speaker;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by vlados on 9/5/2016.
 */

public interface PagingAndSortingSpeakerRepository extends PagingAndSortingRepository<Speaker, Long> {
}
