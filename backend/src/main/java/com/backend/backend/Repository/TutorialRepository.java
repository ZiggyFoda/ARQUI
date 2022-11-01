package com.backend.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.backend.Model.Tutorial;

@Repository
public interface TutorialRepository extends JpaRepository<Tutorial, Long> {
}