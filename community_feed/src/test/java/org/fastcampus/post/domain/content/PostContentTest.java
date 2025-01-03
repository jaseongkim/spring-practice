package org.fastcampus.post.domain.content;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class PostContentTest {

    @Test
    void givenContentLengthIsOk_whenCreatedPost_thenReturnTextContent() {
        //given
        String text = "this is a test";

        //when
        PostContent content = new PostContent(text);

        //then
        Assertions.assertEquals(text, content.contentText);
    }

    @Test
    void givenContentLengthIsOver_whenCreated_thenThrowError() {
        //given
        String content = "a".repeat(501);

        //when, then
        Assertions.assertThrows(IllegalArgumentException.class, () -> new PostContent(content));
    }

    @ParameterizedTest
    @ValueSource(strings = {"뷁, 닭, 굵, 삵, 숧"})
    void givenContentLengthIsOverAndKorean_whenCreated_thenThrowError(String koreanWord) {
        //given
        String content = koreanWord.repeat(501);

        //when, then
        Assertions.assertThrows(IllegalArgumentException.class, () -> new PostContent(content));
    }

    @Test
    void givenContentLengthIsUnder_whenCreated_thenThrowError() {
        //given
        String content = "a".repeat(4);

        //when, then
        Assertions.assertThrows(IllegalArgumentException.class, () -> new PostContent(content));
    }

   @ParameterizedTest
   @NullAndEmptySource
    void givenContentIsEmptyAndNull_whenCreated_thenThrowError(String value) {
        //when, then
        Assertions.assertThrows(IllegalArgumentException.class, () -> new PostContent(value));
    }

    @Test
    void givenContentLengthIsOkWhenUpdateContentThenNotThrowError() {
        // given
        String content = "this is a test content";
        PostContent postContent = new PostContent(content);

        // when
        String newContent = "this is an other test content";
        postContent.updateContent(newContent);

        // then
        Assertions.assertEquals(newContent, postContent.getContentText());
    }

    @Test
    void givenContentLengthIsOverLimitWhenUpdateContentThenThrowError() {
        // given
        String content = "this is a test content";
        PostContent postContent = new PostContent(content);

        // when, then
        String overLimitContent = "a".repeat(501);
        Assertions.assertThrows(IllegalArgumentException.class, () -> postContent.updateContent(overLimitContent));
    }

    @ParameterizedTest
    @NullAndEmptySource
    void givenContentLengthIsOverLimitAndKoreanWhenUpdateContentThenThrowError(String nullOrEmptyContent) {
        // given
        String content = "this is a test content";
        PostContent postContent = new PostContent(content);

        // when, then
        Assertions.assertThrows(IllegalArgumentException.class, () -> postContent.updateContent(nullOrEmptyContent));
    }

}