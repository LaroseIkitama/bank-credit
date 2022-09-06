package com.bank.credit.repository;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.bank.credit.entity.ClientEntity;

public interface ClientRepository extends PagingAndSortingRepository<ClientEntity, Long> {
	Optional<ClientEntity> findByAdress(String adress);
}
