package cn.edu.tju.rico.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.tju.rico.dao.LogDao;
import cn.edu.tju.rico.dao.UserDao;
import cn.edu.tju.rico.dto.UserDTO;
import cn.edu.tju.rico.model.entity.Log;
import cn.edu.tju.rico.model.entity.User;
import cn.edu.tju.rico.service.UserService;

@Component("userService")
public class UserServiceImpl implements UserService {

	private UserDao userDao;
	private LogDao logDao;

	public UserDao getUserDao() {
		return userDao;
	}

	@Resource(name = "userDao")
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public LogDao getLogDao() {
		return logDao;
	}

	@Resource(name = "logDao")
	public void setLogDao(LogDao logDao) {
		this.logDao = logDao;
	}

	// @Transactional(propagation=Propagation.REQUIRED)
	public boolean login(String uname, String passwd) {
		// TODO Auto-generated method stub
		boolean flag = false;
		List<User> list = userDao.getUserByName(uname);
		Log log = new Log();
		log.setDate(new Date());
		if (list.size() == 1 && list.get(0).getPasswd().equals(passwd)) {
			log.setMsg("�û� " + list.get(0).getUname() + " ��¼�ɹ�...");
			flag = true;
		} else if (list.size() != 1) {
			log.setMsg("�û� " + uname + " ������...");
		} else {
			log.setMsg("�û� " + uname + " �������...");
		}
		logDao.save(log);
		return flag;
	}

	// @Transactional(propagation=Propagation.REQUIRED)
	public boolean regist(UserDTO userDto) {
		// TODO Auto-generated method stub
		boolean flag = false;
		Log log = new Log();
		log.setDate(new Date());
		if (!userDto.getPasswd().equals(userDto.getPasswd1())) {
			log.setMsg("�û� " + userDto.getUname() + " ��ע��ʱ�������������벻һ��...");
		} else if (userDao.getUserByName(userDto.getUname()).size() != 0) {
			log.setMsg("�û� " + userDto.getUname() + " ��ע��ʱ�����û����ѱ�ռ��...");
		} else {
			User user = new User(userDto);
			userDao.save(user);
			log.setMsg("�û� " + userDto.getUname() + " ע��ɹ�...");
			flag = true;
		}
		logDao.save(log);
		return flag;
	}

	
	public User getUser(int id) {
		// TODO Auto-generated method stub
		return userDao.loadUser(id);
	}
}
