package fr.wf3.alphabetise.enums;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.HashSet;
import java.util.Set;

public enum Role {
    CLIENT("CLIENT"), ADMIN("ADMIN");

    private final String permission;

    Role(String permission){
        this.permission = permission;
    }

    public String getPermissions(){
        return permission;
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthorities(){
        Set<SimpleGrantedAuthority> permissions = new HashSet<>();
        permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return permissions;
    }

}
