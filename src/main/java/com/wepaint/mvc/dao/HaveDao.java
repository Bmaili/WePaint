package com.wepaint.mvc.dao;

import com.wepaint.mvc.bean.Have;

import java.util.List;

public interface HaveDao {
    public int addHave(Have have);

    public int deleteHaveById(Have haveID);

    public int updateHave(Have have);

    public Have queryHaveById(Have haveID);

    public List<Have> queryHaves();

    public List<Have> queryHavesByUserId(Integer userID);
}
