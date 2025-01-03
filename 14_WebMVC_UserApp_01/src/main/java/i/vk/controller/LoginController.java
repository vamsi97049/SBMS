package i.vk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import i.vk.entity.LoginSource;
import i.vk.serviceimpl.LoginServiceImpl;

@Controller
public class LoginController  {

	@Autowired
	private LoginServiceImpl loginService;

	
	@GetMapping("/login")
	public String login(Model model) {
		LoginSource login = new LoginSource();
		model.addAttribute("login", login);
		return "login";
	}

	@PostMapping("/loginvalidation")
	public String loginValidation(@ModelAttribute("login") LoginSource login, Model model) {
		int validationStatus = loginService.loginValidation(login);
		if (validationStatus == 1) {
			model.addAttribute("userid", login.getUserId());
			return "userview";
		}
		if(validationStatus == 2) {
			return "redirect:/resetpage";
		}
		if(validationStatus == 3) {
			model.addAttribute("res","Incorrect Password");
			return "login";
		}
		if(validationStatus == 4) {
			model.addAttribute("res","TransactionFailure: Login Validation Unsucessful");
			return "login";
		}
		model.addAttribute("res", "Login Failed");
		return "login";
	}

	@GetMapping("/resetpage")
	public String redirectToResetPage() {
		return "resetpage";
	}

	@PostMapping("/resetid")
	public String redirectTOResetpage(@RequestParam("email") String email, Model model) {
		boolean checkId = loginService.checkId(email);
		if (checkId) {
			int otp = loginService.saveOtp(email);
			loginService.SendOtp(email, otp);
			model.addAttribute("ssmg", "OTP has been sent to your email address : " + email);
			model.addAttribute("email", email);
			return "resetpage";
		}
		model.addAttribute("emsg", "User not found");
		return "resetpage";
	}

	@PostMapping("/validateotp")
	public String validateOtpAndRedirectToUpdatePinPage(@RequestParam("email") String email, @RequestParam("otp") String otp, Model model) {
	    try {
	        int parsedOtp = Integer.parseInt(otp);
	        boolean validationStatus = loginService.validateOtp(email, parsedOtp);
	        if (validationStatus) {
	            model.addAttribute("email", email);
	            return "updatepin";
	        } else {
	            model.addAttribute("emsg", "Invalid OTP.");
	            model.addAttribute("email", email);
	            return "resetpage";
	        }
	        
	    } catch (NumberFormatException e) {
	        model.addAttribute("emsg", "Invalid OTP format.");
	        model.addAttribute("email", email);
	        return "resetpage";
	    } catch (Exception e) {
	        model.addAttribute("emsg1", "Transaction Failure, Please try again.");
	        model.addAttribute("email", email);
	        return "resetpage";
	    }
	}

	@PostMapping("/updatepin")
	public String updatePinController(@RequestParam("email") String email, @RequestParam("newPassword") String password,
			RedirectAttributes redirectAttributes) {
		boolean status = loginService.updatePassword(email, password);

		if (status) {
			redirectAttributes.addFlashAttribute("res", "Password Updated");
		} else {
			redirectAttributes.addFlashAttribute("res", "Transaction Failure: Failed to set password");
		}

		return "redirect:/login";
	}

}
