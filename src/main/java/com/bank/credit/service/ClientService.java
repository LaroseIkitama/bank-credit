package com.bank.credit.service;



import java.util.Locale;


import org.springframework.context.MessageSource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.bank.credit.domain.Client;
import com.bank.credit.exception.EntityNotFoundException;
import com.bank.credit.exception.RequestException;
import com.bank.credit.mapper.ClientMapper;
import com.bank.credit.repository.ClientRepository;

import lombok.AllArgsConstructor;



@Service
public class ClientService {
	ClientRepository clientRepository;
	ClientMapper clientMapper;
	MessageSource messageSource;



	public Client createClient(Client client) {
		clientRepository.findById(client.getId())
		.ifPresent(entity -> {
			throw new RequestException(messageSource.getMessage("client.exists", new Object[]{client.getId()},
					Locale.getDefault()), HttpStatus.CONFLICT);
		});
		return clientMapper.toClient(clientRepository.save(clientMapper.fromClient(client)));
	}

	public Client updateClient(Client client){
		return clientRepository.findById(client.getId())
				.map(entity -> {
					return clientMapper.toClient(
							clientRepository.save(clientMapper.fromClient(client)));
				}).orElseThrow(() -> new EntityNotFoundException(messageSource.getMessage("client.notfound", new Object[]{client.getId()},
						Locale.getDefault())));
		}

	public void deleteClientById(Long id) {
		try {
			clientRepository.deleteById(id);
		} catch (Exception e) {
			throw new RequestException(messageSource.getMessage("client.errordeletion", new Object[]{id},
					Locale.getDefault()),
					HttpStatus.CONFLICT);
		}
	}

	public Page<Client> getClients(Pageable pageable) {
		return clientRepository.findAll(pageable).map(clientMapper::toClient);
	}

	public Client getClientById(Long id) {
		return clientMapper.toClient(clientRepository.findById(id).orElseThrow(() ->
		new EntityNotFoundException(messageSource.getMessage("client.notfound", new Object[]{id},
				Locale.getDefault()))));
	}
	
	
}
