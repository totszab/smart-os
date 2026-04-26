package com.example.smart_os.repository;

import com.example.smart_os.model.entity.Theme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ThemeRepository extends JpaRepository<Theme, String> {
}
