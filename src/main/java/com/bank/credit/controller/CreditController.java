package com.bank.credit.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bank.credit.domain.Credit;
import com.bank.credit.service.CreditService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/credits")
@AllArgsConstructor
public class CreditController {

	CreditService creditService;

	@GetMapping
	public List<Credit> getCredits() {
		return creditService.getCredits();
	}

	@GetMapping("/{creditNumber}")
	public ResponseEntity<Credit> getCredit(@PathVariable("creditNumber") String creditNumber) {
		return ResponseEntity.ok(creditService.getCredit(creditNumber));
	}

	@PostMapping
	public Credit createCredit(@Valid @RequestBody Credit credit) {
		return creditService.createCredit(credit);
	}

	@PutMapping
	public Credit updateCredit(@Valid @RequestBody Credit credit) {
		return creditService.updateCredit(credit);
	}

	@DeleteMapping("/{creditNumber}")
	public void deleteCredit(@PathVariable("creditNumber") String creditNumber) {
		creditService.deleteCredit(creditNumber);
	}
}
