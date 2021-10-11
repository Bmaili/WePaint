package com.wepaint.mvc.dao;

import com.wepaint.mvc.bean.Collect;
import java.util.List;

public interface CollectDao {
    public int addCollect(Collect collect);

    public int deleteCollectById(Collect collectID);

    public int updateCollect(Collect collect);

    public Collect queryCollectById(Collect collectID);

    public List<Collect> queryCollects();

    public List<Collect> queryCollectsByUserId(Integer userID);
}
