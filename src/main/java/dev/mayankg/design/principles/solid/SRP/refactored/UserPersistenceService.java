package dev.mayankg.design.principles.solid.SRP.refactored;

class UserPersistenceService {
    //Store used by controller
    private Store store = new Store();

    public void saveUser(User user){
        store.store(user);
    }
}