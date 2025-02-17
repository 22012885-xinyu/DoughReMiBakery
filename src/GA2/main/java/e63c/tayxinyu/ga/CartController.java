/**
 * 
 * I declare that this code was written by me, txy81. 
 * I will not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: tay xin yu
 * Student ID: 22012885
 * Class: C372-4D-E63C-A
 * Date created: 2023-Dec-28 12:11:24 am 
 * 
 */

package e63c.tayxinyu.ga;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author txy81
 *
 */
@Controller
public class CartController {
	@Autowired 
	private CartRepository cartRepository;
	
	@GetMapping("/cart")
	public String viewcart(Model model) {
		
		List<Cart>listCart = cartRepository.findAll();
		model.addAttribute("listCart", listCart);
		return "cart";
	}
	// add
	@GetMapping("/cart/add")
	public String addCart(Model model) {
		model.addAttribute("cart", new Cart());
		return "add_cart";
	}

	@PostMapping("/cart/save")
	public String saveCart(Cart cart) {
		cartRepository.save(cart);
		return "redirect:/cart";
	}

	// edit

	@GetMapping("/cart/edit/{id}")
	public String editCart(@PathVariable("id") Integer id, Model model) {

		Cart cart = cartRepository.getReferenceById(id);
		model.addAttribute("cart", cart);

		return "edit_cart";
	}

	@PostMapping("/cart/edit/{id}")
	public String saveUpdatedCart(@PathVariable("id") Integer id, Cart cart) {

		cartRepository.save(cart);
		return "redirect:/cart";
	}
	// delete

	@GetMapping("/cart/delete/{id}")
	public String deletecart(@PathVariable("id") Integer id) {

		cartRepository.deleteById(id);
	

		return "redirect:/cart";
	}

}
