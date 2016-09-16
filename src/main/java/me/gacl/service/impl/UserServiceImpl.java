package me.gacl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import me.gacl.dao.UserMapper;
import me.gacl.domain.User;
import me.gacl.service.UserServiceI;

/**
 * @author gacl
 * ʹ��@Serviceע�⽫UserServiceImpl���עΪһ��service
 * service��id��userService
 */
@Service("userService")
public class UserServiceImpl implements UserServiceI {

    /**
     * ʹ��@Autowiredע���עuserMapper������
     * ����Ҫʹ��UserMapperʱ��Spring�ͻ��Զ�ע��UserMapper
     */
    @Autowired
    private UserMapper userMapper;//ע��dao

  /**
   * ��Ӷ���
   */
    public void addUser(User user) {
        userMapper.insert(user);
    }

    /**
     * ����id ��ѯ����
     */
    public User getUserById(String userId) {
        return userMapper.selectByPrimaryKey(userId);
    }
    /**
     * ��ѯ���ж���
     */
	public List<User> QueryAllUser() {

		return userMapper.selectAllUser();
	}
}