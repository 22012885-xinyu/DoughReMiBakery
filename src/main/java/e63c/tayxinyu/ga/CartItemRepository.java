/**
 * 
 * I declare that this code was written by me, txy81. 
 * I will not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: tay xin yu
 * Student ID: 22012885
 * Class: C372-4D-E63C-A
 * Date created: 2023-Dec-28 12:12:30 am 
 * 
 */

package e63c.tayxinyu.ga;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author txy81
 *
 */
public interface CartItemRepository extends JpaRepository<CartItem, Integer>{

	public List<CartItem> findByMemberId(int id);
	public CartItem findByMemberIdAndItemId(int memberId, int itemId);
}


