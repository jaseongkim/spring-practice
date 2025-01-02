package org.fastcampus.post.domain.content;

public class commentContent extends Content {

    private static final int MAX_CONTENT_LENGTH = 100;

    public commentContent(String contentText) {
        super(contentText);
    }

    @Override
    protected void checkText(String contentText) {
        if (contentText == null || contentText.isEmpty()) {
            throw new IllegalArgumentException();
        }

        if (MAX_CONTENT_LENGTH < contentText.length()) {
            throw new IllegalArgumentException();
        }
    }
}
