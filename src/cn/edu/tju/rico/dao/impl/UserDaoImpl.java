package cn.edu.tju.rico.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import cn.edu.tju.rico.dao.UserDao;
import cn.edu.tju.rico.model.entity.User;

/**
 * Title: UserDaoImpl.java Description: ��Spring����LogDao�ľ���ʵ�֣��ڴ��õ���Hibernate���־ò�
 * 
 * @author rico
 * @created 2017��4��24�� ����9:18:24
 */
@Component("userDao")
public class UserDaoImpl implements UserDao {

	/** ��Spring���� (@author: rico) */
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	@Resource(name = "hibernateTemplate")
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	/**
	 * @description ORM����������uname��ȡ��Ӧ��User
	 * @author rico
	 * @created 2017��4��24�� ����9:19:08
	 * @param uname
	 * @return
	 * @see cn.edu.tju.rico.dao.UserDao#getUserByName(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	public List<User> getUserByName(String uname) {
		// TODO Auto-generated method stub
		List<User> list = hibernateTemplate
				.find("from User u where u.uname = '" + uname + "'");
		return list;
	}

	/**
	 * @description ORM�������� user�־û�
	 * @author rico
	 * @created 2017��4��24�� ����9:19:42
	 * @param user
	 * @see cn.edu.tju.rico.dao.UserDao#save(cn.edu.tju.rico.model.entity.User)
	 */
	public void save(User user) {
		// TODO Auto-generated method stub
		hibernateTemplate.save(user);
	}

	/**
	 * @description ORM��������ȡ/���س־ò��ض�Id��User
	 * @author rico
	 * @created 2017��4��24�� ����9:19:52
	 * @param id
	 * @return
	 * @see cn.edu.tju.rico.dao.UserDao#loadUser(int)
	 */
	@SuppressWarnings("unchecked")
	public User loadUser(int id) {
		// TODO Auto-generated method stub
		User user = (User) hibernateTemplate.load(User.class, id);
		return user;
	}
}
