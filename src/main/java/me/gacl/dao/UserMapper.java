package me.gacl.dao;



import java.util.List;

import org.apache.ibatis.annotations.Param;

import me.gacl.domain.User;

public interface UserMapper {
    int deleteByPrimaryKey(String userId);

    int insert(User record);

    int insertSelective(User record);

    /**
     * 根据id号查询信息
     * @param userId
     * @return
     */
    User selectByPrimaryKey(String userId);
    
    /**
     * 查询所有的信息
     * @return
     */
    List<User>selectAllUser();
    
    

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}