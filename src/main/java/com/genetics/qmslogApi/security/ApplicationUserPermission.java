package com.genetics.qmslogApi.security;

public enum ApplicationUserPermission {

    TELLER_READ("teller:read"),
    TELLER_WRITE("teller:write"),
    TICKET_READ("ticket:read"),
    TICKET_WRITE("ticket:write");

    private final String permission;

    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
