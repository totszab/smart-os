package com.example.smart_os.service;

import com.example.smart_os.dto.group.CreateGroupRequest;
import com.example.smart_os.dto.group.UpdateGroupRequest;
import com.example.smart_os.model.entity.Groups;
import com.example.smart_os.repository.GroupRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GroupService {

    private final GroupRepository groupRepository;


    @Transactional
    public Groups createGroup(CreateGroupRequest req) {
        Groups groups = new Groups();
        groups.setId(UUID.randomUUID().toString());
        groups.setName(req.name());

        return groupRepository.save(groups);

    }

    @Transactional
    public Groups update(UpdateGroupRequest req) {

        Groups group = groupRepository.findById(req.id())
                .orElseThrow(() -> new RuntimeException("Group not found"));

        group.setName(req.name());

        return groupRepository.save(group);
    }

    @Transactional
    public void delete(String id) {

        if (!groupRepository.existsById(id)) {
            throw new RuntimeException("Group not found");
        }

        groupRepository.deleteById(id);
    }

    public List<Groups> getAll() {
        return groupRepository.findAll();
    }
}
