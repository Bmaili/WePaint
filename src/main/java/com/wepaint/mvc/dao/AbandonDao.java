package com.wepaint.mvc.dao;

import com.wepaint.mvc.bean.Abandon;

import java.util.List;

public interface AbandonDao {
    public int addAbandon(Abandon abandon);

    public int deleteAbandonById(Abandon abandonID);

    public int updateAbandon(Abandon abandon);

    public Abandon queryAbandonById(Abandon abandonID);

    public List<Abandon> queryAbandons();

    public List<Abandon> queryAbandonsByUserId(Integer userID);
}
