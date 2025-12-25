package com.oriole.wisepen.user.service;

import com.oriole.wisepen.user.api.domain.dto.UserInfoDTO;
import com.oriole.wisepen.user.domain.entity.User;
import com.oriole.wisepen.user.domain.entity.UserProfile;

public interface UserService {
    User getUserCoreInfoByUsername(String username);
    User getUserCoreInfoByAccount(String account);
    UserInfoDTO getUserInfoById(Long userId);
    void updateUserStatus(Long userId, Integer status);

    boolean verifyExistUsername(String username);
    boolean verifyExistCampusNum(String campusNum);
    boolean insertUser(User user);
    boolean insertUserProfile(UserProfile userProfile);

    Long getUserIdByCampusNum(String campusNum);
    String getUserEmailByCampusNum(String campusNum);
}