package com.example.demo.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entities.Music;
import com.example.demo.services.MusicService;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import com.razorpay.Utils;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PaymentController {

	@Autowired
	MusicService musser;

	@PostMapping("/createOrder")
	@ResponseBody
	public String createOrder() {
		Order order = null;
		try {
			RazorpayClient razorpay = new RazorpayClient("rzp_test_XVRC4SyQBd4DSA", "MTJvCotfrwa9HgEdjjOxBKht");

			JSONObject orderRequest = new JSONObject();
			orderRequest.put("amount", 50000);
			orderRequest.put("currency", "INR");
			orderRequest.put("receipt", "receipt#1");
			JSONObject notes = new JSONObject();
			notes.put("notes_key_1", "Tea, Earl Grey, Hot");
			orderRequest.put("notes", notes);

			order = razorpay.orders.create(orderRequest);
		} catch (Exception e) {
			System.out.println("exception while crteating order");
		}
		return order.toString();
	}

	@PostMapping("/verify")
	@ResponseBody
	public boolean verifyPayment(@RequestParam String orderId, @RequestParam String paymentId,
			@RequestParam String signature) {
		try {
			// Initialize Razorpay client with your API key and secret
			@SuppressWarnings("unused")
			RazorpayClient razorpayClient = new RazorpayClient("rzp_test_XVRC4SyQBd4DSA", "MTJvCotfrwa9HgEdjjOxBKht");
			// Create a signature verification data string
			String verificationData = orderId + "|" + paymentId;

			// Use Razorpay's utility function to verify the signature
			boolean isValidSignature = Utils.verifySignature(verificationData, signature, "0BqRP7065kuUDvV6ZaimqRSa");

			return isValidSignature;
		} catch (RazorpayException e) {
			e.printStackTrace();
			return false;
		}
	}

	@GetMapping("/payment-success")
	public String paymentSuccess(HttpSession session) {
		String mail = (String) session.getAttribute("mail");
		Music mus = musser.getUser(mail);
		mus.setPremium(true);
		musser.updateUser(mus);
		return "login";
	}

	@GetMapping("/payment-failure")
	public String paymentFailed() {
		return "login";
	}

}
