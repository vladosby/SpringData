package com.spring.data.entities;

import javax.persistence.*;
import java.lang.annotation.Target;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by vlados on 9/5/2016.
 */

@Entity
public class Speaker {
    @Id
    @GeneratedValue
    private Long speakerId;

    private String name;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Talk> talks;

    public Speaker() {

    }

    public Speaker(String name) {
        this.name = name;
    }


    public void addTalk(Talk talk) {
        if (talks == null) {
            talks = new HashSet<>();
        }

        talks.add(talk);
    }

    public String getName() {
        return name;
    }

    public Set<Talk> getTalks() {
        return talks;
    }

    @Override
    public String toString() {
        return "Speaker{" +
                "name='" + name + '\'' +
                '}';
    }
}
