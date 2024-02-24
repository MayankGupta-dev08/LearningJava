package dev.mayankg.design.patterns.structural.flyweight.example1;

import java.util.HashMap;
import java.util.Map;

//Flyweight factory. Returns shared flyweight based on a key
class ErrorMessageFactory {
    private static final ErrorMessageFactory FACTORY = new ErrorMessageFactory();
    private Map<ErrorType, SystemErrorMessage> systemErrorMessageCache = new HashMap<>();

    private ErrorMessageFactory() {
        systemErrorMessageCache.put(ErrorType.GenericSystemError,
                new SystemErrorMessage("A generic error of type $errorCode occurred. Please refer to:\n",
                        "http://google.com/q="));
        systemErrorMessageCache.put(ErrorType.PageNotFoundError,
                new SystemErrorMessage("Page not found. An error of type $errorCode occurred. Please refer to:\n",
                        "http://google.com/q="));
        systemErrorMessageCache.put(ErrorType.ServerError,
                new SystemErrorMessage("Server error of type $errorCode occurred. Please refer to:\n",
                        "http://google.com/q="));
    }

    public static ErrorMessageFactory getInstance() {
        return FACTORY;
    }

    public SystemErrorMessage getError(ErrorType type) {
        return systemErrorMessageCache.get(type);
    }

    public UserBannedErrorMessage getUserBannedMessage(String caseId) {
        return new UserBannedErrorMessage(caseId);
    }

    //This serves as key for getting flyweight instance
    public enum ErrorType {GenericSystemError, PageNotFoundError, ServerError}
}