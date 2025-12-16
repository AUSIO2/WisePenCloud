package com.oriole.wisepen.user.service;

import com.oriole.wisepen.user.api.domain.dto.UserInfoDTO;
import com.oriole.wisepen.user.domain.entity.User;

public interface UserService {
    User getUserCoreInfoByUsername(String username);
    UserInfoDTO getUserInfoById(Long userId);
    void updateUserStatus(Long userId, Integer status);
}