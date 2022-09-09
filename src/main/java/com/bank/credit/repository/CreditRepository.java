package com.bank.credit.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.credit.entity.CreditEntity;

public interface CreditRepository extends JpaRepository<CreditEntity, String> {

	Optional<CreditEntity> findByCreditNumberIgnoreCase(String creditNumber);
}
