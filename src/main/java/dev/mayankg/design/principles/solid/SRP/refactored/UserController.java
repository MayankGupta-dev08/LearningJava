package dev.mayankg.design.principles.solid.SRP.refactored;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

//Handles incoming JSON requests that work on User resource/entity
class UserController {
    private ObjectMapper mapper;
    private UserValidator userValidator;
    private UserPersistenceService userPersistenceService;

    public UserController() {
        this.mapper = new ObjectMapper();
        this.userValidator = new UserValidator();
        this.userPersistenceService = new UserPersistenceService();
    }

    //Create a new user
    public String createUser(String userJson) throws IOException {
        User user = mapper.readValue(userJson, User.class);

        if (!userValidator.isValidUser(user)) {
            return "ERROR";
        }

        userPersistenceService.saveUser(user);
        return "SUCCESS";
    }
}