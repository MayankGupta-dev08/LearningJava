package dev.mayankg.design.principles.solid.OCP.refactored;

import java.util.List;

class PhoneSubscriber extends Subscriber {

    @Override
    public double calculateBill() {
        List<CallHistory.Call> sessions = CallHistory.getCurrentCalls(getSubscriberId());
        long totalDuration = sessions.stream().mapToLong(CallHistory.Call::getDuration).sum();
        return totalDuration * getBaseRate() / 100;
    }
}