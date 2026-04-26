package com.example.smart_os.controller;

import com.example.smart_os.converter.group.GroupConverter;
import com.example.smart_os.dto.group.CreateGroupRequest;
import com.example.smart_os.dto.group.GroupsDto;
import com.example.smart_os.dto.group.UpdateGroupRequest;
import com.example.smart_os.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/group")
@RequiredArgsConstructor
public class GroupController {

    private final GroupService groupService;
    private final GroupConverter groupConverter;

    @PostMapping("/create")
    public GroupsDto create(@RequestBody CreateGroupRequest req) {
        return groupConverter.toDto(groupService.createGroup(req));
    }

    @PutMapping("/update/{id}")
    public GroupsDto update(@RequestBody UpdateGroupRequest req) {
        return groupConverter.toDto(groupService.update(req));
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable String id) {
        groupService.delete(id);
    }

    @GetMapping("/getAll")
    public List<GroupsDto> getAll() {
        return groupService.getAll()
                .stream()
                .map(groupConverter::toDto)
                .toList();
    }
}
