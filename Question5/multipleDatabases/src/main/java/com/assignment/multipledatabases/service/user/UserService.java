package com.assignment.multipledatabases.service.user;

import java.util.List;

public interface UserService<T> {
    public List<T> getAllUsers();
}
