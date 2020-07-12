package cn.com.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import cn.com.mapper.UserInfoMapper;
import cn.com.bean.UserInfo;
import cn.com.service.UserInfoService;

import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService{

    @Resource
    private UserInfoMapper userInfoMapper;

    @Override
    public List<UserInfo> findAll(UserInfo userInfo) {
        return userInfoMapper.findAll(userInfo);
    }

    @Override
    public int delByIds(Integer... ids) {
        return userInfoMapper.delByIds(ids);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return userInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(UserInfo record) {
        return userInfoMapper.insert(record);
    }

    @Override
    public int insertSelective(UserInfo record) {
        return userInfoMapper.insertSelective(record);
    }

    @Override
    public UserInfo selectByPrimaryKey(Integer id) {
        return userInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(UserInfo record) {
        return userInfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(UserInfo record) {
        return userInfoMapper.updateByPrimaryKey(record);
    }

}
