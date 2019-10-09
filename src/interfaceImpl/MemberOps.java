/**
 * 
 */
package interfaceImpl;

import java.util.List;

import entity.Member;
import entity.Profile;

/**
 * @author Lenevo
 *
 */
public interface MemberOps {
	
	List<Member> getAllMembers();
	
	Member getMemberById(String mob);
	
	Profile getMemberProfile(String mobile);
	
	boolean setMember(Member member);

}
