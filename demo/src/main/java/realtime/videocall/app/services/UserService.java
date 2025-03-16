package realtime.videocall.app.services;

import realtime.videocall.app.entities.*;
import realtime.videocall.app.repositories.IUserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

@Service
public class UserService {
    @Autowired
    private IUserRepository _userRepository;

    public User getUserById(Long id) {
        return _userRepository.findById(id).orElse(null);
    }

    public void save(User user) {
        _userRepository.save(user);
    }
}
