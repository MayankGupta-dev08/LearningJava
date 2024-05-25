package dev.mayankg.design.patterns.behavioural.command.example;

/**
 * This class is the receiver.
 */
class EWSService {

    /**
     * Add a new member to the mailing list
     */
    public void addMember(String contact, String contactGroup) {
        //contact exchange ...
        System.out.println("Added " + contact + " to " + contactGroup);
    }

    /**
     * Remove member from the mailing list
     */
    public void removeMember(String contact, String contactGroup) {
        //contact exchange ...
        System.out.println("Removed " + contact + " from " + contactGroup);
    }
}