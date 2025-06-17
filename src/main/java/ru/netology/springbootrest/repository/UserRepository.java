package ru.netology.springbootrest.repository;

import ru.netology.springbootrest.model.Authorities;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Repository
public class UserRepository {
    public List<Authorities> getUserAuthorities(String user, String password) {
        if ("admin".equals(user) && "123".equals(password)) {
            return Arrays.asList(Authorities.READ, Authorities.WRITE, Authorities.DELETE);
        } else if ("user".equals(user) && "456".equals(password)) {
            return Arrays.asList(Authorities.READ);
        }
        return Collections.emptyList();
    }
}