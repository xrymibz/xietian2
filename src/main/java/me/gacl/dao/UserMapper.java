package me.gacl.dao;



import java.util.List;

import org.apache.ibatis.annotations.Param;

import me.gacl.domain.User;

public interface UserMapper {
    int deleteByPrimaryKey(String userId);

    int insert(User record);

    int insertSelective(User record);

    /**
     * ����id�Ų�ѯ��Ϣ
     * @param userId
     * @return
     */
    User selectByPrimaryKey(String userId);
    
    /**
     * ��ѯ���е���Ϣ
     * @return
     */
    List<User>selectAllUser();
    
    

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}