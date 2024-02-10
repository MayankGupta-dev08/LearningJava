package dev.mayankg.design.principles.solid.OCP.refactored;

import java.time.LocalDateTime;
import java.util.*;

class CallHistory {
    private static final Map<Long, List<Call>> CALLS = new HashMap<>();

    public synchronized static List<Call> getCurrentCalls(Long subscriberId) {
        if (!CALLS.containsKey(subscriberId)) {
            return Collections.emptyList();
        }
        return CALLS.get(subscriberId);
    }

    public synchronized static void addSession(Long subscriberId, LocalDateTime begin, long duration) {
        List<Call> calls;
        if (!CALLS.containsKey(subscriberId)) {
            calls = new LinkedList<>();
            CALLS.put(subscriberId, calls);
        } else {
            calls = CALLS.get(subscriberId);
        }
        calls.add(new Call(subscriberId, begin, duration));
    }

    static class Call {
        private LocalDateTime begin;
        private long duration;
        private Long subscriberId;

        public Call(Long subscriberId, LocalDateTime begin, long duration) {
            this.begin = begin;
            this.duration = duration;
            this.subscriberId = subscriberId;
        }

        public LocalDateTime getBegin() {
            return begin;
        }

        public long getDuration() {
            return duration;
        }

        public Long getSubscriberId() {
            return subscriberId;
        }
    }
}