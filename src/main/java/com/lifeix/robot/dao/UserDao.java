package com.lifeix.robot.dao;

import com.lifeix.robot.model.User;

/**
 * Created by lhx on 15-2-3 上午11:21
 *
 * @project springmybatis
 * @package com.lifeix.robot.dao
 * @Description
 * @blog http://blog.csdn.net/u011439289
 * @email 888xin@sina.com
 * @github https://github.com/888xin
 */
public interface UserDao {
    /**
     * 添加新用户
     * @param user
     * @return
     */
    public int insertUser(User user);
}
