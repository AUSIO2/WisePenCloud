package com.oriole.wisepen.user.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.oriole.wisepen.user.api.domain.dto.UserInfoDTO;
import com.oriole.wisepen.user.domain.entity.User;
import com.oriole.wisepen.user.domain.entity.UserProfile;
import com.oriole.wisepen.user.service.UserService;
import com.oriole.wisepen.user.mapper.UserMapper;
import com.oriole.wisepen.user.mapper.UserProfileMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final UserProfileMapper userProfileMapper;

    @Override
    public User getUserCoreInfoByUsername(String username) {
        return userMapper.selectOne(Wrappers.<User>lambdaQuery().eq(User::getUsername, username));
    }

    @Override
    public UserInfoDTO getUserInfoById(Long userId) {
        // 查核心账号
        User user = userMapper.selectById(userId);

        if (user == null) {
            return null;
        }

        // 查档案详情
        UserProfile profile = userProfileMapper.selectById(user.getId());

        // 组装 DTO
        UserInfoDTO dto = new UserInfoDTO();
        BeanUtil.copyProperties(user, dto);

        if (profile != null) {
            BeanUtil.copyProperties(profile, dto);
        }

        return dto;
    }

    @Override
    public void updateUserStatus(Long userId, Integer status) {
        User user = new User();
        user.setId(userId);
        user.setStatus(status);
        userMapper.updateById(user);
    }
}