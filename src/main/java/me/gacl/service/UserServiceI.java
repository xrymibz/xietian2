package me.gacl.service;

import me.gacl.domain.User;

public interface UserServiceI {

    /**
     * ����û�
     * @param user
     */
    void addUser(User user);
    
    /**
     * �����û�id��ȡ�û�
     * @param userId
     * @return
     */
    User getUserById(String userId);
}