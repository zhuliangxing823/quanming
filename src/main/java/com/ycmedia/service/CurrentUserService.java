package com.ycmedia.service;

import com.ycmedia.entity.CurrentUser;


public interface CurrentUserService {

    boolean canAccessUser(CurrentUser currentUser, Long userId);

}
