package dev.mayankg.design.principles.solid.OCP.refactored;

import java.time.LocalDateTime;
import java.util.*;

class InternetSessionHistory {
    private static final Map<Long, List<InternetSession>> SESSIONS = new HashMap<>();

    public synchronized static List<InternetSession> getCurrentSessions(Long subscriberId) {
        if (!SESSIONS.containsKey(subscriberId)) {
            return Collections.emptyList();
        }
        return SESSIONS.get(subscriberId);
    }

    public synchronized static void addSession(Long subscriberId, LocalDateTime begin, long dataUsed) {
        List<InternetSession> sessions;
        if (!SESSIONS.containsKey(subscriberId)) {
            sessions = new LinkedList<>();
            SESSIONS.put(subscriberId, sessions);
        } else {
            sessions = SESSIONS.get(subscriberId);
        }
        sessions.add(new InternetSession(subscriberId, begin, dataUsed));
    }

    static class InternetSession {
        private LocalDateTime begin;
        private Long subscriberId;
        private Long dataUsed;

        public InternetSession(Long subscriberId, LocalDateTime begin, long dataUsed) {
            this.begin = begin;
            this.dataUsed = dataUsed;
            this.subscriberId = subscriberId;
        }

        public LocalDateTime getBegin() {
            return begin;
        }

        public long getDataUsed() {
            return dataUsed;
        }

        public Long getSubscriberId() {
            return subscriberId;
        }
    }
}