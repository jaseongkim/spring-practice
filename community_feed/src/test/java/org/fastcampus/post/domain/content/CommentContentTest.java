package org.fastcampus.post.domain.content;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class CommentContentTest {

    @Test
    void givenContentLengthIsOk_WhenCreateCommentContent_ThenReturnTextContext() {
        // given
        String contentText = "this is a test content";

        //when
        CommentContent content = new CommentContent(contentText);

        // when, then
        Assertions.assertEquals(contentText, content.getContentText());
    }

    @Test
    void givenContentLengthIsOverLimitCreatePostContentThenThrowError() {
        // given
        String content = "a".repeat(101);

        // when, then
        Assertions.assertThrows(IllegalArgumentException.class, () -> new CommentContent(content));
    }

    @ParameterizedTest
    @ValueSource(strings = {"뷁", "닭", "굵"})
    void givenContentLengthIsOverLimitAndKoreanCreatePostContentThenThrowError(String koreanContent) {
        // given
        String content = koreanContent.repeat(101);

        // when, then
        Assertions.assertThrows(IllegalArgumentException.class, () -> new CommentContent(content));
    }

    @Test
    void givenContentLengthIsUnderLimitCreatePostContentThenNotThrowError() {
        // given
        String content = "abcd";

        // when, then
        Assertions.assertDoesNotThrow(() -> new CommentContent(content));
    }

    @ParameterizedTest
    @NullAndEmptySource
    void givenContentLengthIsEmptyLimitCreatePostContentThenThrowError(String source) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new CommentContent(source));
    }
}