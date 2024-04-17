package dev.mayankg.unitTesting.mockito.gettingStarted.business;

import dev.mayankg.unitTesting.mockito.gettingStarted.data.api.TodoService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TodoBusinessImplStubTest {
    /**
     * Using old school Stud
     */
    @Test
    void retrieveTodosRelatedToSpringForMayank_usingStub() {
        TodoService todoService = new TodoServiceStub();
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
        List<String> todos = todoBusinessImpl.retrieveTodosRelatedToSpring("Mayank");
        assertEquals(4, todos.size());
    }

    @Test
    void retrieveTodosRelatedToSpringForAdam_usingStub() {
        TodoService todoService = new TodoServiceStub();
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
        List<String> todos = todoBusinessImpl.retrieveTodosRelatedToSpring("Adam");
        assertEquals(0, todos.size());
    }
}