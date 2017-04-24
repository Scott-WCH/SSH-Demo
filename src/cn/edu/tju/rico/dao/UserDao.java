package cn.edu.tju.rico.dao;

import java.util.List;

import cn.edu.tju.rico.model.entity.User;

  
/**        
 * Title: UserDao.java    
 * Description: ��Խӿڱ�̣����ξ�������ݿ���ʲ���
 * @author rico       
 * @created 2017��4��24�� ����9:12:27    
 */      
public interface UserDao {
	
	  
	/**     
	 * @description ����uname��ȡ��Ӧ��User
	 * @author rico       
	 * @created 2017��4��24�� ����9:12:45     
	 * @param uname
	 * @return     
	 */
	public List<User> getUserByName(String uname);
	
	/**     
	 * @description �� user�־û�
	 * @author rico       
	 * @created 2017��4��24�� ����9:13:17     
	 * @param user     
	 */
	public void save(User user);
	
	
	/**     
	 * @description ��ȡ/���س־ò��ض�Id��User
	 * @author rico       
	 * @created 2017��4��24�� ����9:13:34     
	 * @param id
	 * @return     
	 */
	public User loadUser(int id);
}
