package com.miniprojet.calcul.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.miniprojet.calcul.model.Operation;

@Repository
public interface OperationRepository extends JpaRepository<Operation, Integer> {

}
