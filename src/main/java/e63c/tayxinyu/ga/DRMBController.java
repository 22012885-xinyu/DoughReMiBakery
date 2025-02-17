/**
 * 
 * I declare that this code was written by me, txy81. 
 * I will not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: tay xin yu
 * Student ID: 22012885
 * Class: C372-4D-E63C-A
 * Date created: 2023-Oct-26 12:18:22 pm 
 * 
 */

package e63c.tayxinyu.ga;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
/**
 * @author txy81
 *
 */
public class DRMBController {
	@GetMapping("/reset")
	public String reset(){
 		return "reset";
	}
	@GetMapping("/BlackforestCake")
	public String BlackforestCake(){
 		return "bf";
	}
	@GetMapping("/FruitCake")
	public String FruitCake(){
 		return "fr";
	}
	@GetMapping("/LycheeRoseCake")
	public String LycheeRoseCake(){
 		return "lr";
	}
	@GetMapping("/RainbowCake")
	public String RainbowCake(){
 		return "rb";
	}
	@GetMapping("/RedVelvetCake")
	public String RedVelvetCake(){
 		return "rv";
	}
	@GetMapping("/payment")
	public String payment(){
 		return "payment";
	}
	@GetMapping("/register")
	public String register(){
 		return "register";
	}
	@GetMapping("/aboutus")
	public String aboutus(){
 		return "aboutus";
	}
}
