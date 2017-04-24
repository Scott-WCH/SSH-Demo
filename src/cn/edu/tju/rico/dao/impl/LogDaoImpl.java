package cn.edu.tju.rico.dao.impl;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import cn.edu.tju.rico.dao.LogDao;
import cn.edu.tju.rico.model.entity.Log;

/**        
 * Title: LogDaoImpl.java    
 * Description: ��Spring����LogDao�ľ���ʵ�֣��ڴ��õ���Hibernate���־ò�
 * @author rico       
 * @created 2017��4��24�� ����9:14:19    
 */      
@Component("logDao")
public class LogDaoImpl implements LogDao {
	
	
	/**  ��Spring����   (@author: rico) */      
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	@Resource(name="hibernateTemplate")
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	  
	/** 
	 * @description ������Transient״̬�Ķ���־û���תΪPersistent״̬
	 * @author rico       
	 * @created 2017��4��24�� ����9:15:53      
	 * @param log     
	 * @see cn.edu.tju.rico.dao.LogDao#save(cn.edu.tju.rico.model.entity.Log)     
	 */  
	public void save(Log log) {
		// TODO Auto-generated method stub
		hibernateTemplate.save(log);
	}
}
