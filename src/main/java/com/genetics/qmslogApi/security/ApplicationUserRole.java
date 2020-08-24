package com.genetics.qmslogApi.security;

import com.google.common.collect.Sets;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static com.genetics.qmslogApi.security.ApplicationUserPermission.*;

public enum ApplicationUserRole {

    TELLER(Sets.newHashSet()),
    ADMIN(Sets.newHashSet(TELLER_READ, TELLER_WRITE, TICKET_READ, TICKET_WRITE)),
    BRANCH_MANAGER(Sets.newHashSet(TELLER_READ));

    private final Set<ApplicationUserPermission> permissions;

    ApplicationUserRole(Set<ApplicationUserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<ApplicationUserPermission> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthorities(){

        Set<SimpleGrantedAuthority> permissions = getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect((Collectors.toSet()));

        permissions.add(new SimpleGrantedAuthority( "ROLE_" + this.name()));

        return permissions;
    }
}

