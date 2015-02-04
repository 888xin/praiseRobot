package com.lifeix.robot.model;

import java.io.Serializable;

/**
 * Created by lhx on 15-2-4 下午2:28
 *
 * @project point-like-robot
 * @package com.lifeix.robot.dao
 * @Description
 * @blog http://blog.csdn.net/u011439289
 * @email 888xin@sina.com
 * @github https://github.com/888xin
 */
public class PraiseUser implements Serializable {

    private Integer id ;
    private Integer accountid ;
    private Boolean sex ;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAccountid() {
        return accountid;
    }

    public void setAccountid(Integer accountid) {
        this.accountid = accountid;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }
}
