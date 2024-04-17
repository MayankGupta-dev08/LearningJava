package dev.mayankg.unitTesting.mockito.gettingStarted.business;

import dev.mayankg.unitTesting.mockito.gettingStarted.data.api.TodoService;

import java.util.List;

class TodoServiceStub implements TodoService {

    /**
     * For diff users, we are using conditions, which is bad. Also, Static Condition.
     */
    @Override
    public List<String> retrieveTodos(String user) {
        if (user.equalsIgnoreCase("mayank"))
            return List.of("Learn Spring Core",
                    "Learn Spring Boot",
                    "Learn Spring MVC",
                    "Learn Spring Security",
                    "Learn Dance",
                    "Learn Finance");
        return List.of("Learn whatever...");
    }
}