package com.ycmedia.service;

import org.springframework.stereotype.Service;

import com.ycmedia.entity.CurrentUser;

@Service
public class CurrentUserServiceImpl implements CurrentUserService {


    @Override
    public boolean canAccessUser(CurrentUser currentUser, Long userId) {
        return currentUser != null
                && (currentUser.getRole() == "ROLE_ADMIN"|| currentUser.getId().equals(userId));
    }

}
