package com.james.api.post.adapter.in.web.request;

import lombok.Builder;

@Builder
public record PostCreateRequest(String title, String content) {
}
