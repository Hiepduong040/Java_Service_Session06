// ClassRepository.java
package com.data.javaservice_session06.repository;

import com.data.javaservice_session06.model.entity.Classes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassRepository extends JpaRepository<Classes, Integer> {
    Classes findByClassName(String className);
}