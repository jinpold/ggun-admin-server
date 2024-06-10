package com.james.api.common.security.model.service;
import com.james.api.common.component.Messenger;
import com.james.api.admin.model.AdminDto;
import com.james.api.user.model.UserDto;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {
    Messenger login(AdminDto adminDto);
    Messenger userLogin(UserDto userDto);
    String createToken(AdminDto adminDto);
    String createUserToken(UserDto userDto);
}
