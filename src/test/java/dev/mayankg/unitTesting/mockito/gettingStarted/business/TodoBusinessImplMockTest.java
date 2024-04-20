package dev.mayankg.unitTesting.mockito.gettingStarted.business;

import dev.mayankg.unitTesting.mockito.gettingStarted.data.api.TodoService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

class TodoBusinessImplMockTest {
    private static final List<String> todos =
            List.of("Learn Spring Core", "Learn Spring Boot",
                    "Learn Spring MVC", "Learn Spring Security",
                    "Learn Dance", "Learn Finance");

    /**
     * <p>Mocking: It is creating objects that simulate the behavior of the real objects.</p>
     * <p>Unlike Stubs, mocks can be directly created from code at runtime.</p>
     * It offers a lot of features and one can verify method call and a lot of other things.
     */
    @Test
    void retrieveTodosRelatedToSpringForMayank_usingMock() {
        /* Dynamically Constructing the mock and using it. */
        TodoService todoService = mock(TodoService.class);
        when(todoService.retrieveTodos("Mayank")).thenReturn(todos);

        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
        List<String> todos = todoBusinessImpl.retrieveTodosRelatedToSpring("Mayank");
        System.out.println("Actual Todos: " + todos);
        assertEquals(4, todos.size());
    }

    @Test
    void retrieveTodosRelatedToSpringForAdam_usingMock() {
        TodoService todoService = mock(TodoService.class);
        when(todoService.retrieveTodos("Adam")).thenReturn(List.of());

        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
        List<String> todos = todoBusinessImpl.retrieveTodosRelatedToSpring("Adam");
        System.out.println("Actual Todos: " + todos);
        assertEquals(0, todos.size());
    }

    /**
     * <p>Using Behavior Driven Development Approach of Mockito</p>
     * Given --> When --> Then
     */
    @Test
    void retrieveTodosRelatedToSpringForAdam_usingMockBDD() {
        // used BDDMockito.given() --> BDDMockito.willReturn()
        TodoService todoService = mock(TodoService.class);
        given(todoService.retrieveTodos("someUser")).willReturn(todos);

        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
        List<String> todos = todoBusinessImpl.retrieveTodosRelatedToSpring("someUser");

        System.out.println("Actual Todos: " + todos);
        assertEquals(4, todos.size());
    }

    @Test
    void deleteTodosRelatedToSpringForMayank_usingMock() {
        /* setup */
        TodoService todoService = mock(TodoService.class);
        when(todoService.retrieveTodos("Mayank")).thenReturn(todos);
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);

        /* test method invocation */
        todoBusinessImpl.deleteTodosRelatedToSpring("Mayank");

        /* assertion */
        verify(todoService).deleteTodos("Learn Dance"); //checking whether this call was actually made or not
        verify(todoService, Mockito.never()).deleteTodos("Learn Spring MVC");
        verify(todoService, Mockito.never()).deleteTodos("Learn Spring");
        verify(todoService, Mockito.times(1)).deleteTodos("Learn Finance"); // atLeastOnce, atLeast
    }
}