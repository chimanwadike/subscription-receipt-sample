package com.receipt_generator.demo.subscription;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.io.source.ByteArrayOutputStream;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

@Service
public class SubscriptionService {
	
	public ResponseEntity<byte[]> downloadSubscriptionReceipts(){
		
		List<Subscription> subscriptions = new ArrayList<>() {};
		subscriptions.add(
				new Subscription(1, "Gold Package", LocalDate.of(2024, 7, 9),
				LocalDate.of(2025, 7,9), "Annual Subscription", 20000.0 ));
		
		
		String subscriptionPdfHtml = parseSubscriptionTemplate(subscriptions);
		
		byte[] pdf = generatePdfFromHtml(subscriptionPdfHtml);
		String fileName = "subscription_receipt.pdf";
		
		HttpHeaders header = new HttpHeaders();
		header.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename="+fileName);
		header.add("Cache-Control", "no-cache, no-store, must-revalidate");
		header.add("Pragma", "no-cache");
		header.add("Expires", "0");
		
		return ResponseEntity.ok()
				.headers(header)
				.contentType(MediaType.APPLICATION_PDF)
				.body(pdf);
	}
	
	private String parseSubscriptionTemplate(List<Subscription> subscriptions){
		
		ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
		templateResolver.setTemplateMode(TemplateMode.HTML);
		templateResolver.setSuffix(".html");

		Context context = new Context();
		Map<String, Object> templateVariables = Map.of(
				"subscriptions", subscriptions,
				"userFirstName", "Foo",
				"userLastName","Bar",
				"userCompanyName", "BarFoo Services Ltd");
		
		context.setVariables(templateVariables);
		
		SpringTemplateEngine templateEngine = new SpringTemplateEngine();
		templateEngine.setTemplateResolver(templateResolver);
		
		return templateEngine.process("templates/SubscriptionReceiptTemplate", context);
	}
	
	private byte[] generatePdfFromHtml(String html){
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		HtmlConverter.convertToPdf(html, output);
		return output.toByteArray();
	}
}
