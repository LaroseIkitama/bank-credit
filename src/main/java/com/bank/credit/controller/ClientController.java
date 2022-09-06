package com.bank.credit.controller;

import javax.validation.Valid;



import org.springframework.web.bind.annotation.*;

import com.bank.credit.domain.Client;
import com.bank.credit.service.ClientService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/clients")
@AllArgsConstructor
public class ClientController {

	ClientService clientService;

	@PostMapping
	public Client createClient(@Valid @RequestBody Client client) {
		return clientService.createClient(client);
	}

	@PutMapping
	public Client updateClient(@Valid @RequestBody Client client) {
		return clientService.updateClient(client);
	}

	@DeleteMapping("{id}")
	public void deleteClientById(@PathVariable("id") Long id) {
		clientService.deleteClientById(id);
	}

	@GetMapping("{id}")
	public Client getClientById(@PathVariable("id") Long id) {
		return clientService.getClientById(id);
	}
}
