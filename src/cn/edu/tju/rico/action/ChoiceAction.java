package cn.edu.tju.rico.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;

  
/**        
 * Title: ע��/��¼   
 * Description: index.jsp��Ӧ�Ŀ�����
 * @author rico       
 * @created 2017��4��24�� ����9:02:12    
 */      
@Component("choice")
@Scope("prototype")  // ÿ�������Ӧһ��Action����
@SuppressWarnings("serial")
public class ChoiceAction extends ActionSupport {
	
	  
	/**     
	 * @description ѡ���¼����
	 * @author rico       
	 * @created 2017��4��24�� ����9:03:05     
	 * @return     
	 */
	public String login() {
		return "login";
	}
	  
	/**     
	 * @description ѡ��ע�����
	 * @author rico       
	 * @created 2017��4��24�� ����9:03:25     
	 * @return     
	 */
	public String regist() {
		return "regist";
	}
}
