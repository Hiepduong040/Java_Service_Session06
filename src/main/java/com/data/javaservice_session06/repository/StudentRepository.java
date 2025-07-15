// StudentRepository.java
package com.data.javaservice_session06.repository;

import com.data.javaservice_session06.model.entity.Students;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Students, Integer> {
    List<Students> findByFullNameContainingIgnoreCase(String fullName);
    List<Students> findByAddressContainingIgnoreCase(String address);
    List<Students> findByClassesClassName(String className);
}