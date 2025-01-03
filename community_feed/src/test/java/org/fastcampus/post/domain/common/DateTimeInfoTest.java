package org.fastcampus.post.domain.common;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

class DateTimeInfoTest {

    @Test
    void givenCreated_whenUpdated_thenTimeAndUpdated() {
        //given
        DatetimeInfo datetimeInfo = new DatetimeInfo();
        LocalDateTime localDateTime = datetimeInfo.getDateTime();
        System.out.println(localDateTime);
        //when
        datetimeInfo.updateEditDateTime();

        System.out.println(datetimeInfo.getDateTime());

        //then
        Assertions.assertTrue(datetimeInfo.isEdited());
        Assertions.assertNotEquals(localDateTime, datetimeInfo.getDateTime());
    }



}
