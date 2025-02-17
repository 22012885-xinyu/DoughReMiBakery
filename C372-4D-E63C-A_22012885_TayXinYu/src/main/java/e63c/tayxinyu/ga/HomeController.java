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

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author txy81
 *
 */
@Controller
public class HomeController {
	
	@Autowired
	private ItemRepository itemRepository;
	
	@GetMapping("/")
	public String home() {
		return "index";
	}
	@GetMapping("/403")
	public String error403() {
		return "403";
	}

}
