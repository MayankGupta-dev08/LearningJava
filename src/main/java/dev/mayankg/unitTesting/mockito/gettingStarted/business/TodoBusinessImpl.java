package dev.mayankg.unitTesting.mockito.gettingStarted.business;

import dev.mayankg.unitTesting.mockito.gettingStarted.data.api.TodoService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Our SUT (Service Under Test), which is loosely coupled to TodoService (Dependency)
 */
public class TodoBusinessImpl {
    private final TodoService todoService;

    TodoBusinessImpl(TodoService todoService) {
        this.todoService = todoService;
    }

    public List<String> retrieveTodosRelatedToSpring(String user) {
        List<String> allTodos = todoService.retrieveTodos(user);
        return allTodos.stream()
                .filter(todo -> todo.contains("Spring"))
                .collect(Collectors.toList());
    }
}