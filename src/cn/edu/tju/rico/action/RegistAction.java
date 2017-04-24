package cn.edu.tju.rico.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cn.edu.tju.rico.dto.UserDTO;
import cn.edu.tju.rico.service.UserService;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

  
/**        
 * Title: RegistAction.java    
 * Description:regist.jsp ��Ӧ�Ŀ����� 
 * @author rico       
 * @created 2017��4��24�� ����9:05:47    
 */      
@Component("regist")
@Scope("prototype")// ÿ�������Ӧһ��Action����
@SuppressWarnings("serial")
public class RegistAction extends ActionSupport {

	private UserDTO userDTO;  // DTO��Data Transfer Object�����ڴ�ֵ�������־û�(����ȷ�������User)
	private UserService userService;

	public UserDTO getUserDTO() {
		return userDTO;
	}

	public void setUserDTO(UserDTO userDTO) {
		this.userDTO = userDTO;
	}

	public UserService getUserService() {
		return userService;
	}

	@Resource(name = "userService")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	public String execute() throws Exception {
		boolean flag = userService.regist(userDTO);
		return flag ? Action.SUCCESS : Action.ERROR;
	}
}