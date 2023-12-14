package com.solvd.interfaces;

import com.solvd.enums.SecurityLevel;

@FunctionalInterface
public interface ISecurityService<T> {
    SecurityLevel assignSecurityLevel(T obj);
}
