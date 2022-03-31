package com.miniprojet.calcul.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.miniprojet.calcul.model.Session;

@Repository
public interface SessionRepository extends JpaRepository<Session, Integer> {

}
