package me.gacl.service;



import java.util.List;

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
    
    /**
     * ��ѯ���е��û�
     * @return
     */
    
    List<User> QueryAllUser();
}