package e63c.tayxinyu.ga;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Integer> {
	
	public Member findByUsername(String username);
	
}


