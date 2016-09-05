package com.spring.data.repositories;


import com.spring.data.entities.Speaker;
import com.spring.data.entities.Talk;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by vlados on 9/5/2016.
 */
public class UnitDataUtils {
    public static List<Speaker> initSpeakers() {
        List<Speaker> speakers = new ArrayList<>();

        Speaker ivanov = new Speaker("Ivanov Ivan");

        Speaker semenov = new Speaker("Semenov Semen");
        semenov.addTalk(new Talk(new Date(100000), "Talk of Semenov number 1"));
        semenov.addTalk(new Talk(new Date(120000), "Talk of Semenov number 2"));

        Speaker petrov = new Speaker("Petrov Petr");
        petrov.addTalk(new Talk(new Date(140000), "Talk of Petrov number 1"));

        Speaker kozlov = new Speaker("Kozlov Vasya");
        kozlov.addTalk(new Talk(new Date(160000), "Talk of Kozlov number 1"));
        kozlov.addTalk(new Talk(new Date(180000), "Talk of Kozlov number 2"));

        speakers.add(ivanov);
        speakers.add(semenov);
        speakers.add(petrov);
        speakers.add(kozlov);

        return speakers;
    }
}
