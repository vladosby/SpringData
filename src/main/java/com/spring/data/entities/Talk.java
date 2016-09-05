package com.spring.data.entities;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by vlados on 9/5/2016.
 */

@Entity
public class Talk {
    @Id
    @GeneratedValue
    private Long talkId;

    private Date whenDate;

    private String title;

    public Talk(){

    }

    public Talk(Date whenDate, String title) {
        this.whenDate = whenDate;
        this.title = title;
    }

    public Date getWhenDate() {
        return whenDate;
    }

    @Override
    public String toString() {
        return title;
    }
}
