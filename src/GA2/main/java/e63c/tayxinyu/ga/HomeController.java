/**
 * 
 * I declare that this code was written by me, txy81. 
 * I will not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: tay xin yu
 * Student ID: 22012885
 * Class: C372-4D-E63C-A
 * Date created: 2023-Nov-30 2:22:19 pm 
 * 
 */

package e63c.tayxinyu.ga;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author txy81
 *
 */
@Controller
public class HomeController {
	@GetMapping("/home")
	public String home() {
		return "index";
	}

}
