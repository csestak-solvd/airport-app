package com.solvd.interfaces;

import com.solvd.enums.SecurityLevel;

@FunctionalInterface
public interface SecurityService<T> {
    SecurityLevel assignSecurityLevel(T obj);
}
