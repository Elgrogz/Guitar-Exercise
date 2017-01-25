package com.example.user.guitarexercise;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;
/**
 * Created by user on 21/01/2017.
 */
public class ExerciseTest {

    Exercise exercise1;

    @Before
    public void before() {
        exercise1 = new Exercise(1, "Gregor's Exercise", "Alzapua");
    }

    @Test
    public void canGetId() {
        assertEquals(1, exercise1.getId());
    }

    @Test
    public void canSetId() {
        exercise1.setId(2);
        assertEquals(2, exercise1.getId());
    }


    @Test
    public void canGetName() {
        assertEquals("Gregor's Exercise", exercise1.getName());
    }

    @Test
    public void canSetName() {
        exercise1.setName("GG's Exercise");
        assertEquals("GG's Exercise", exercise1.getName());
    }

    @Test
    public void canGetType() {
        assertEquals("Alzapua", exercise1.getType());
    }

    @Test
    public void canSetType() {
        exercise1.setType("Alzapua");
        assertEquals("Alzapua", exercise1.getType());
    }

    @Test
    public void canGetBpm() {
        assertEquals(0, exercise1.getBpm());
    }

    @Test
    public void canSetBpm() {
        exercise1.setBpm(20);
        assertEquals(20, exercise1.getBpm());
    }

    @Test
    public void canGetBpmToString() {
        assertEquals("0bpm", exercise1.bpmToString());
    }

    @Test
    public void canGetDate() {
        System.out.println(exercise1.getDate());
    }

//    @Test
//    public void canSetDate() {
//        System.out.println(exercise1.getDate());
//    }
}
