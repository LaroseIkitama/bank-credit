package com.bank.credit.mapper;

import org.mapstruct.Mapper;

import com.bank.credit.domain.Client;
import com.bank.credit.entity.ClientEntity;

@Mapper
public interface ClientMapper {

	Client toClient(ClientEntity clientEntity);
	
	ClientEntity fromClient(Client client);
}
