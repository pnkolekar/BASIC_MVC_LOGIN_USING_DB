package com.msedcl.mvc.main.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;
import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

//package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.msedcl.mvc.main.entity.AppUsers;
import com.msedcl.mvc.main.repository.MVCUsersRepository;
import com.msedcl.mvc.main.service.MVCUserServiceImpl;
import com.msedcl.mvc.main.util.CommonUtils;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {
	@Autowired
	private MVCUserServiceImpl impl;

	@GetMapping("/login")
	public String showLoginPage() {
		return "login"; // looks for templates/login.html
	}

	@PostMapping("/login")
	public String processLogin(@RequestParam String username, @RequestParam String password, HttpSession session,
			Model model) throws MalformedURLException, IOException {
		boolean result = false;

		if (true) {

			List<AppUsers> lst = impl.getAllMVCUsers();

			for (AppUsers appUsers : lst) {
				if ((appUsers.getUsernames().equalsIgnoreCase(username)))
					result = true;
			}

			/*
			 * foreach(AppUsers appUsers : lst) { //System.out.println);
			 * if((appUsers.getUsernames().equalsIgnoreCase(username)) result=true; }
			 */

			if (result) {

				String generatedOTP = impl.generateOTP();
				// For demo: print to console. In real app you'd SMS/email this
				System.out.println("Generated OTP for " + username + ": " + generatedOTP);
				session.setAttribute("OTP", generatedOTP);
				
				String mbody = generatedOTP+" is the OTP for Login to MTSKPY portal. This OTP is valid till 15 min. MSEDCL";
//fetching email
	        	AppUsers existingUser = impl.getByUsername(username);
				//model.addAttribute("emailIDD",existingUser.getEmailID());
	            //CommonUtils.sendEmail("mtskp_support@mahadiscom.in", "p1zmnj",existingUser.getEmailID() , "OTP for login to MTSKPY portal", mbody);
CommonUtils.postOTPURL(generatedOTP);
	            //----------
				
				// add expiry time also in session
				session.setAttribute("OTP_EXPIRY", Instant.now().plus(Duration.ofMinutes(5)));

			
				session.setAttribute("USERNAME", username);

				// model.addAttribute("user", username);
				return "redirect:/otp"; // go to OTP page
			} else {
				model.addAttribute("error", "Invalid username or password");

				return "login";

			}
		} else {
			model.addAttribute("error", "Invalid username or password");
			return "login";
		}
	}

	@GetMapping("/")
	public String home() {
		return "redirect:/login";
	}

	@GetMapping("/otp")
	public String showOtpPage(HttpSession session, Model model) {
		// If no OTP in session, send back to login
		if (session.getAttribute("OTP") == null) {
			return "redirect:/login";
		}
		return "otp";
	}
	
	

	@PostMapping("/verify-otp")
	public String verifyOtp(@RequestParam String enteredOtp, HttpSession session, Model model) {
		Instant expiry = (Instant) session.getAttribute("OTP_EXPIRY");

		String sessionOtp = (String) session.getAttribute("OTP");
		String username = (String) session.getAttribute("USERNAME");

		if (Instant.now().isAfter(expiry)) {
			model.addAttribute("error", "Invalid OTP. Try again.");
			return "otp";
			// expired
		} else {

			if (sessionOtp != null && sessionOtp.equalsIgnoreCase(enteredOtp)) {
				// OTP correct - clear it from session
				session.removeAttribute("OTP");
				model.addAttribute("user", username);
				
				AppUsers existingUser = impl.getByUsername(username);
				model.addAttribute("emailIDD",existingUser.getEmailID());
				return "success";
			}

			else {
				model.addAttribute("error", "Invalid OTP. Try again.");
				return "otp";
			}
		}
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}
}