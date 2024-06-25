package com.james.api.post.adapter.in.web;


import com.james.api.chatcommon.annotation.WebAdapter;
import com.james.api.chatcommon.response.SuccessApiResponse;
import com.james.api.post.adapter.in.web.request.PostCreateRequest;

import com.james.api.post.application.port.in.PostCreateUseCase;
import com.james.api.post.application.port.in.PostLoadUseCase;
import com.james.api.post.application.port.in.command.PostCreateCommand;
import com.james.api.post.application.port.in.command.PostQuery;
import com.james.api.post.application.port.in.command.PostSearchByTitleQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@WebAdapter
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/posts")
class PostController {
    private final PostCreateUseCase createPostUseCase;
    private final PostLoadUseCase getPostUseCase;
    @PostMapping
    public SuccessApiResponse<?> createPost(@RequestBody PostCreateRequest createRequest){
        PostCreateCommand command = PostCreateCommand.builder()
                .title(createRequest.title())
                .content(createRequest.content())
                .build();
        return SuccessApiResponse.of(createPostUseCase.createPost(command));
    }
    @GetMapping("/{postId}")
    public SuccessApiResponse<?> getPostById(@PathVariable Long postId){
        PostQuery postQuery = PostQuery.builder()
                .postId(postId)
                .build();
        return SuccessApiResponse.of(getPostUseCase.getPostById(postQuery));
    }
    @GetMapping
    public SuccessApiResponse<?> getPostListByTitle(@RequestParam String title){
        PostSearchByTitleQuery postSearchByTitleQuery = PostSearchByTitleQuery.builder()
                .title(title)
                .build();
        return SuccessApiResponse.of(getPostUseCase.searchPostListByTitle(postSearchByTitleQuery));
    }
}
