package dev.mayankg.design.patterns.structural.flyweight.example1;

//A concrete Flyweight. Instance is shared
// messageTemplate and helpUrlBase are the intrinsic properties whereas the getText(errorCode) is extrinsic
class SystemErrorMessage implements ErrorMessage {
    //some error message with an $errorCode
    private String messageTemplate;

    //http://somedomain.com/help?error=
    private String helpUrlBase;

    public SystemErrorMessage(String messageTemplate, String helpUrlBase) {
        this.messageTemplate = messageTemplate;
        this.helpUrlBase = helpUrlBase;
    }

    @Override
    public String getText(String code) {
        return messageTemplate.replace("$errorCode", code) + helpUrlBase + code;
    }

}