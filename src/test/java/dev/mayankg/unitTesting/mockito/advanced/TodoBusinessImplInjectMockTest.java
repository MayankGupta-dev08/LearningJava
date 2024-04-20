package dev.mayankg.unitTesting.mockito.advanced;

import dev.mayankg.unitTesting.mockito.gettingStarted.business.TodoBusinessImpl;
import dev.mayankg.unitTesting.mockito.gettingStarted.data.api.TodoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Using Annotations to autowire the dependencies
 *
 * @ExtendWith(MockitoExtension.class), @Mock, @InjectMocks, @Captor
 */
@ExtendWith(MockitoExtension.class)
class TodoBusinessImplInjectMockTest {
    private static final List<String> todos =
            List.of("Learn Spring Core", "Learn Spring Boot",
                    "Learn Spring MVC", "Learn Spring Security",
                    "Learn Dance", "Learn Finance");

    @Mock   // removes need for: mock(TodoService.class)
    TodoService todoService;

    @InjectMocks    // removes the need for: new TodoBusinessImpl(todoService)
    TodoBusinessImpl todoBusinessImpl;

    @Captor // removes the need for: ArgumentCaptor.forClass(String.class)
    ArgumentCaptor<String> stringArgumentCaptor;


    @Test
    void retrieveTodosRelatedToSpringForMayank_usingMock() {
        when(todoService.retrieveTodos("Mayank")).thenReturn(todos);

        List<String> todos = todoBusinessImpl.retrieveTodosRelatedToSpring("Mayank");

        System.out.println("Actual Todos: " + todos);
        assertEquals(4, todos.size());
    }

    @Test
    void retrieveTodosRelatedToSpringForAdam_usingMock() {
        when(todoService.retrieveTodos("Adam")).thenReturn(List.of());

        List<String> todos = todoBusinessImpl.retrieveTodosRelatedToSpring("Adam");

        System.out.println("Actual Todos: " + todos);
        assertEquals(0, todos.size());
    }

    @Test
    void retrieveTodosRelatedToSpringForAdam_usingMockBDD() {
        // used BDDMockito.given() --> BDDMockito.willReturn()
        BDDMockito.given(todoService.retrieveTodos("someUser")).willReturn(todos);

        List<String> todos = todoBusinessImpl.retrieveTodosRelatedToSpring("someUser");

        System.out.println("Actual Todos: " + todos);
        assertEquals(4, todos.size());
    }

    @Test
    void deleteTodosRelatedToSpringForMayank_usingMockBDD() {
        /* setup */
        when(todoService.retrieveTodos("Mayank")).thenReturn(todos);

        /* test method invocation */
        todoBusinessImpl.deleteTodosRelatedToSpring("Mayank");

        /* assertion */
        verify(todoService).deleteTodos("Learn Dance"); //checking whether this call was actually made or not
        BDDMockito.then(todoService).should().deleteTodos("Learn Dance");

        verify(todoService, Mockito.never()).deleteTodos("Learn Spring MVC");
        verify(todoService, Mockito.never()).deleteTodos("Learn Spring");
        verify(todoService, Mockito.times(1)).deleteTodos("Learn Finance"); // atLeastOnce, atLeast
    }

    @Test
    void deleteTodosRelatedToSpringForMayank_usingMockBDDArgumentCapture() {
        /* setup */
        when(todoService.retrieveTodos("Mayank")).thenReturn(todos);

        /* test method invocation */
        todoBusinessImpl.deleteTodosRelatedToSpring("Mayank");

        /* assertion */
        // Verify that deleteTodos is called only once with the captured argument
        BDDMockito.then(todoService).should(times(2)).deleteTodos(stringArgumentCaptor.capture());
        assertThat(stringArgumentCaptor.getAllValues().size(), is(2));
    }
}