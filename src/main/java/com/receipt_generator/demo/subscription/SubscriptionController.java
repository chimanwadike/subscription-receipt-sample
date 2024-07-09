package com.receipt_generator.demo.subscription;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/subscription")
public class SubscriptionController {
	
	private final SubscriptionService subscriptionService;
	
	public SubscriptionController(SubscriptionService subscriptionService) {
		this.subscriptionService = subscriptionService;
	}
	
	@GetMapping("/receipt-binary")
	public ResponseEntity<byte[]> downloadSubscriptionReceipt() {
		return subscriptionService.downloadSubscriptionReceipts();
	}
}
