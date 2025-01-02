package org.fastcampus.common.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PositiveIntegerCounterTest {

    @Test
    void giverCreatedAnd_whenIncrease_thenCountInOne() {
        //given
        PositiveIntegerCounter counter = new PositiveIntegerCounter();

        //when
        counter.increase();

        //then
        Assertions.assertEquals(1, counter.getCount());
    }

    @Test
    void givenCreatedAndIncreasesd_whenDecrease_thenCountIsZero() {
        //given
        PositiveIntegerCounter counter = new PositiveIntegerCounter();
        counter.increase();

        //when
        counter.decreases();

        //then
        Assertions.assertEquals(0, counter.getCount());
    }

    @Test
    void givenCreated_whenDecrease_thenCountIsZero() {
        //given
        PositiveIntegerCounter counter = new PositiveIntegerCounter();

        //when
        counter.decreases();

        //then
        Assertions.assertEquals(0, counter.getCount());
    }



}
