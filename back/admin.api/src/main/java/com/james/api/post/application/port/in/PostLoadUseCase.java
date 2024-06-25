package com.james.api.post.application.port.in;

import com.james.api.post.adapter.in.web.response.PostResponse;
import com.james.api.post.adapter.in.web.response.PostSearchResponse;
import com.james.api.post.application.port.in.command.PostQuery;
import com.james.api.post.application.port.in.command.PostSearchByTitleQuery;

import java.util.List;

public interface PostLoadUseCase {
    PostResponse getPostById(PostQuery postQuery);
    List<PostSearchResponse> searchPostListByTitle(PostSearchByTitleQuery postSearchByTitleQuery);
}
