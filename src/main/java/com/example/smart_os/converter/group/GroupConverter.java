package com.example.smart_os.converter.group;

import com.example.smart_os.dto.group.GroupsDto;
import com.example.smart_os.model.entity.Groups;
import org.springframework.stereotype.Component;

@Component
public class GroupConverter {

    public GroupsDto toDto(Groups groups) {
        return new GroupsDto(
                groups.getId(),
                groups.getName()
        );
    }
}
