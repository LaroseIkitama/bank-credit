package com.bank.credit.service;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


import com.bank.credit.domain.Credit;
import com.bank.credit.mapper.CreditMapper;
import com.bank.credit.repository.ClientRepository;
import com.bank.credit.repository.CreditRepository;
import com.bank.credit.exception.EntityNotFoundException;
import com.bank.credit.exception.RequestException;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CreditService {

	CreditRepository creditRepository;
	ClientRepository clientRepository;
	CreditMapper creditMapper;
	MessageSource messageSource;



	public List<Credit> getCredits() {
		return StreamSupport.stream(creditRepository.findAll().spliterator(), false)
				.map(creditMapper::toCredit)
				.collect(Collectors.toList());
	}


	public Credit getCredit(String creditNumber) {
		return creditMapper.toCredit(creditRepository.findByCreditNumberIgnoreCase(creditNumber).orElseThrow(() ->
		new EntityNotFoundException(messageSource.getMessage("credit.notfound", new Object[]{creditNumber},
				Locale.getDefault()))));
	}


	public Credit createCredit(Credit credit) {
		creditRepository.findByCreditNumberIgnoreCase(credit.getCreditNumber())
		.ifPresent(entity -> {
			throw new RequestException(messageSource.getMessage("credit.exists", new Object[]{credit.getCreditNumber()},
					Locale.getDefault()), HttpStatus.CONFLICT);
		});
		return creditMapper.toCredit(creditRepository.save(creditMapper.fromCredit(credit)));
	}


	public Credit updateCredit(Credit credit) {
		return creditRepository.findByCreditNumberIgnoreCase(credit.getCreditNumber())
				.map(entity -> {
					return creditMapper.toCredit(
							creditRepository.save(creditMapper.fromCredit(credit)));
				}).orElseThrow(() -> new EntityNotFoundException(messageSource.getMessage("credit.notfound", new Object[]{credit.getCreditNumber()},
						Locale.getDefault())));
	}


	public void deleteCredit(String creditNumber) {
		try {
			creditRepository.deleteById(creditNumber);
		} catch (Exception e) {
			throw new RequestException(messageSource.getMessage("credit.errordeletion", new Object[]{creditNumber},
					Locale.getDefault()),
					HttpStatus.CONFLICT);
		}
	}

}
