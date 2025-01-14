package co.inventorsoft.academy.articleanalyzer.repository;

import co.inventorsoft.academy.articleanalyzer.model.User;
import co.inventorsoft.academy.articleanalyzer.service.jsonmanager.JsonManagerService;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Type;
import java.util.Set;

@Repository
public class UserRepository {

    private final JsonManagerService<User> jsonManagerService;

    @Value("${users.path}")
    private String usersPath;

    public UserRepository(JsonManagerService<User> jsonManagerService) {
        this.jsonManagerService = jsonManagerService;
    }

    public Set<User> readAllUsers() {
        Type typeToken = new TypeToken<Set<User>>() {
        }.getType();
        return jsonManagerService.readAll(usersPath, typeToken);
    }

}
