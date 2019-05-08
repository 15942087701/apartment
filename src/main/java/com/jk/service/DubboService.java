package com.jk.service;

import com.jk.model.LoginUser;
import com.jk.util.MenuTree;

import java.util.HashMap;
import java.util.List;

public interface DubboService {

    HashMap<String, Object> findUserByNamePwd(LoginUser loginUser);

    List<MenuTree> getTree(String jobId);
}
