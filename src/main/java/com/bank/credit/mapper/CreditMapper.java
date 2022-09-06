package com.bank.credit.mapper;

import org.mapstruct.Mapper;

import com.bank.credit.domain.Credit;
import com.bank.credit.entity.CreditEntity;

@Mapper
public interface CreditMapper {
	Credit toCredit(CreditEntity creditEntity);
	
	CreditEntity fromCredit(Credit credit);
}

