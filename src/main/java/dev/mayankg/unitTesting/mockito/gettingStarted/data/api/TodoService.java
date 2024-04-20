package dev.mayankg.unitTesting.mockito.gettingStarted.data.api;

import java.util.List;

// External Service - Let's say this comes from WunderList
public interface TodoService {
    List<String> retrieveTodos(String user);
    void deleteTodos(String todo);
}