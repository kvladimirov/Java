package blog.services;

import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class LoginServiceStubImpl implements LoginService{

    @Override
    public boolean authenticate(String username, String password) {
        return Objects.equals(username, password);
    }
}