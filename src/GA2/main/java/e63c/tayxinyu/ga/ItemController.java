/**
 * 
 * I declare that this code was written by me, txy81. 
 * I will not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: tay xin yu
 * Student ID: 22012885
 * Class: C372-4D-E63C-A
 * Date created: 2023-Nov-16 9:40:07 pm 
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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.Valid;

/**
 * @author txy81
 *
 */
@Controller
public class ItemController {
	@Autowired
	private ItemRepository itemRepository;

	
	@GetMapping("/items")
	public String viewItems(Model model) {
		
		List<Item> listItems = itemRepository.findAll();
		
		model.addAttribute("listItems", listItems);
		return "view_items";
	}
	@GetMapping("/items/add")
	public String addItem(Model model) {
		model.addAttribute("item", new Item());
		
		  List<Item> catList = itemRepository.findAll(); 
		  model.addAttribute("catList", catList); 
		  
		return "add_item";
	}
 
	@PostMapping("/items/save")
	public String saveItem( Item item, @RequestParam("itemImage") MultipartFile imgFile) {

	    String imageName = imgFile.getOriginalFilename();

	    // Set the image name in the item object
	    item.setImgName(imageName);
	    Item savedItem = itemRepository.save(item);  

	    try {
	        // Preparing the directory path
	        String uploadDir = "uploads/items/" + savedItem.getId(); // Assuming getId() is a method in your Item class to get the ID
	        Path uploadPath = Paths.get(uploadDir);
	        System.out.println("Directory path: " + uploadPath);

	        // Checking if the upload path exists, if not it will be created.
	        if (!Files.exists(uploadPath)) {
	            Files.createDirectories(uploadPath);
	        }

	        // Prepare path for the file
	        Path fileToCreatePath = uploadPath.resolve(imageName);
	        System.out.println("File path: " + fileToCreatePath);

	        // Copy the file to the upload location
	        Files.copy(imgFile.getInputStream(), fileToCreatePath, StandardCopyOption.REPLACE_EXISTING);

	        // Save the item object to the database after successfully saving the file
			/* Item savedItem = itemRepository.save(item); */

	    } catch (IOException io) {
	        io.printStackTrace();
	    }

	    return "redirect:/items";
	}
	
	@GetMapping("/items/edit/{id}")
	public String editItem(@PathVariable("id") Integer id, Model model) {
		Item item = itemRepository.getReferenceById(id);
		model.addAttribute("item", item);
		return "edit_item";
	}
	@PostMapping("/items/edit/{id}/save")
	public String saveUpdatedItem(@PathVariable("id") Integer id, Item item) {
		itemRepository.save(item);
		return "redirect:/items";
	}
	@GetMapping("/items/delete/{id}")
	public String deleteItem(@PathVariable("id") Integer id, Item item) {
		itemRepository.deleteById(id);
		return "redirect:/items";
	}
}
