package com.bank.credit.controller;


import java.util.Locale;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;

import com.bank.credit.domain.Credit;
import com.bank.credit.exception.RequestException;
import com.bank.credit.mapper.CreditMapper;
import com.bank.credit.repository.CreditRepository;

@SpringBootTest
public class CreditControllerTest {

	@Autowired
	CreditRepository creditRepository;

	@Autowired
	MessageSource messageSource;
	@Autowired
	CreditMapper creditMapper;

	@Test
	void createCredit() {
		
		Credit credit= new Credit();
		credit.setCreditNumber("3RFT");
		credit.setAmount(24.678);
		credit.setDuration(30);
		
		creditRepository.findByCreditNumberIgnoreCase(credit.getCreditNumber())
		.ifPresent(entity -> {
			throw new RequestException(messageSource.getMessage("credit.exists", new Object[]{credit.getCreditNumber()},
					Locale.getDefault()), HttpStatus.CONFLICT);
		});
		
		creditMapper.toCredit(creditRepository.save(creditMapper.fromCredit(credit)));
		
		System.out.println(credit.toString());
		
	}
}
