package cn.edu.tju.rico.dao;

import cn.edu.tju.rico.model.entity.Log;
  
/**        
 * Title: LogDao.java    
 * Description: ��Խӿڱ�̣����ξ�������ݿ���ʲ���
 * @author rico       
 * @created 2017��4��24�� ����9:11:27    
 */      
public interface LogDao {
	
	/**     
	 * @description ��־�־û�
	 * @author rico       
	 * @created 2017��4��24�� ����9:12:10     
	 * @param log     
	 */
	public void save(Log log);
}
