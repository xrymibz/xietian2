package me.gacl.service.impl;

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

  
    public void addUser(User user) {
        userMapper.insert(user);
    }

    
    public User getUserById(String userId) {
        return userMapper.selectByPrimaryKey(userId);
    }
}