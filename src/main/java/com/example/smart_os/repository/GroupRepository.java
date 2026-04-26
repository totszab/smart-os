package com.example.smart_os.repository;

import com.example.smart_os.model.entity.Groups;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Groups, String> {
}
