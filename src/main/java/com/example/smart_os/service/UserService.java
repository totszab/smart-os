package com.example.smart_os.service;

import com.example.smart_os.defaults.DefaultFactory;
import com.example.smart_os.dto.user.CreateUserRequest;
import com.example.smart_os.dto.user.UpdateUserRequest;
import com.example.smart_os.model.entity.Groups;
import com.example.smart_os.model.entity.User;
import com.example.smart_os.repository.GroupRepository;
import com.example.smart_os.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final GroupRepository groupRepository;
    private final DefaultFactory defaultFactory;

    @Transactional
    public User createUser(CreateUserRequest req) {

        Groups groups = groupRepository.findById(req.groupId())
                .orElseThrow();

        User user = new User();
        user.setId(UUID.randomUUID().toString());
        user.setName(req.name());
        user.setGroups(groups);

        user.setTheme(defaultFactory.defaultTheme());
        user.setBackground(defaultFactory.defaultBackground());
        user.setMenu(defaultFactory.defaultMenu());

        return userRepository.save(user);
    }

    @Transactional
    public User update(UpdateUserRequest dto) {

        User user = userRepository.findById(dto.id())
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setName(dto.name());

        return userRepository.save(user);
    }

    @Transactional
    public void delete(String id) {

        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User not found");
        }

        userRepository.deleteById(id);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }
}
