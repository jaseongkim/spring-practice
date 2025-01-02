package org.fastcampus.user.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UserInfoTest {

    @Test
    void givenNameAndProfileImage_whenCreated_thenThrowNothing() {
        //given
        String name ="abcd";
        String profileImage = "";

        //when
        //then
        Assertions.assertDoesNotThrow(()-> new UserInfo(name, profileImage));

    }

    @Test
    void givenBlankNameAndProfileImage_whenCreated_thenThrowError() {
        //given
        String name ="";
        String profileImage = "";

        //when
        //then
        Assertions.assertThrows(IllegalArgumentException.class, ()-> new UserInfo(name, profileImage));
    }


}
