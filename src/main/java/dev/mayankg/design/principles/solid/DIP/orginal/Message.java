package dev.mayankg.design.principles.solid.DIP.orginal;

import java.time.LocalDateTime;
import java.time.ZoneId;

class Message {
    private String msg;
    private LocalDateTime timestamp;

    public Message(String msg) {
        this.msg = msg;
        this.timestamp = LocalDateTime.now(ZoneId.of("UTC"));
    }

    public String getMsg() {
        return msg;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}