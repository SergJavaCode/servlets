package ru.netology.repository;

import ru.netology.model.Post;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

// Stub
public class PostRepository {
    private ConcurrentHashMap<Long, Post> postCollection;
    Long countPosts = 0L;

    public PostRepository() {
        this.postCollection = new ConcurrentHashMap<>();
    }

    public List<Post> all() {
        return new ArrayList<>(postCollection.values());
    }

    public Optional<Post> getById(long id) {
        return Optional.ofNullable(postCollection.get(id));
    }

    public Post save(Post post) {
        if (post.getId() == 0) {
            countPosts += 1;
            post.setId(countPosts);
            postCollection.put(countPosts, post);
            return postCollection.get(countPosts);
        } else {
            Post postByIdFromCollection = postCollection.get(post.getId());
            postByIdFromCollection.setContent(post.getContent());
            return postByIdFromCollection;
        }
    }

    public void removeById(long id) {
        postCollection.remove(id);
    }
}
