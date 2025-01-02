package org.fastcampus.user.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserTest {

    private final UserInfo userInfo = new UserInfo("test", "");
    private User user1;
    private User user2;

    // 매번 객체가 새로 생성이 된다는 것을 보장
    @BeforeEach
    void init() {
        user1 = new User(1L, userInfo);
        user2 = new User(2L, userInfo);
    }

    @Test
    void givenTwoUser_whenEqual_thenReturnFalse() {
        //given
        boolean value = user1.equals(user2);
        //then
        Assertions.assertFalse(value);
        //
    }

    @Test
    void givenTwoSameIdUser_whenEqual_thenReturnTrue() {
        //given
        User sameUser = new User(1L, userInfo);
        //when
        boolean isSame = user1.equals(sameUser);
        //
        Assertions.assertTrue(isSame);
    }

    @Test
    void givenTwoUser_whenHashCode_thenNotEqual() {

        //when
        int hashCode1 = user1.hashCode();
        int hashCode2 = user2.hashCode();
        //
        Assertions.assertNotEquals(hashCode1, hashCode2);
    }

    @Test
    void givenTwoUser_whenHashCode_thenReturnTrue() {

        //given
        User sameUser = new User(1L, userInfo);

        //when
        int hashCode1 = user1.hashCode();
        int sameUserHashCode = sameUser.hashCode();
        //
        Assertions.assertEquals(hashCode1, sameUserHashCode);
    }

    @Test
    void givenTwoUser_whenUser1FollowUser2_thenIncreaseUserCount() {

        //when
        user1.follow(user2);
        //then
        Assertions.assertEquals(1, user1.followingCount());
        Assertions.assertEquals(0, user1.followerCount());
        Assertions.assertEquals(0, user2.followingCount());
        Assertions.assertEquals(1, user2.followerCount());

    }
    @Test
    void givenTwoUser1FollowUser2_whenUnfollow_thenDecreaseUserCount() {

        //given
        user1.follow(user2);
        //when
        user1.unfollow(user2);
        //then
        Assertions.assertEquals(0, user1.followingCount());
        Assertions.assertEquals(0, user1.followerCount());
        Assertions.assertEquals(0, user2.followingCount());
        Assertions.assertEquals(0, user2.followerCount());
    }

    @Test
    void givenTwoUser_whenUnfollow_thenNotDecreaseUserCount() {
        //when
        user1.unfollow(user2);

        //then
        Assertions.assertEquals(0, user1.followingCount());
        Assertions.assertEquals(0, user1.followerCount());
        Assertions.assertEquals(0, user2.followingCount());
        Assertions.assertEquals(0, user2.followerCount());
    }


}
