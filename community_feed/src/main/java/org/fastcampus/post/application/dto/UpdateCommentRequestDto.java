package org.fastcampus.post.application.dto;

public record UpdateCommentRequestDto(Long commenId, Long userId, String content) {
}
