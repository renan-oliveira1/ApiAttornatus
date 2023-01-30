package com.example.ApiAttornatus;

import com.example.ApiAttornatus.entities.People;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.time.LocalDate;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PeopleEntity {

    private People peopleEntity;

    @BeforeAll
    void setPeopleEntity() {
        this.peopleEntity = new People(
                10L,
                "Lucas Oliveira",
                LocalDate.parse("1999-05-14")
        );
    }

    @Test
    void testPeopleEntity(){
        Assertions.assertAll(
                () -> Assertions.assertEquals(10, peopleEntity.getId()),
                () -> Assertions.assertEquals("Lucas Oliveira", peopleEntity.getName()),
                () -> Assertions.assertEquals(LocalDate.parse("1999-05-14"), peopleEntity.getBirthDate())
        );
    }


}
