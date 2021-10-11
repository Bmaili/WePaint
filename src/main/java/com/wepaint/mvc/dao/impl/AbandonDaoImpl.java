package com.wepaint.mvc.dao.impl;

import com.wepaint.mvc.bean.Abandon;
import com.wepaint.mvc.dao.AbandonDao;

import java.util.List;

public class AbandonDaoImpl extends BaseDao implements AbandonDao {
    @Override
    public int addAbandon(Abandon abandon) {
        String sql = "insert into tb_user_abandon_paint(`user_id`,`paint_id`)values(?,?)";
        return update(sql, abandon.getUserID(), abandon.getPaintID());
    }

    @Override
    public int deleteAbandonById(Abandon abandonID) {
        String sql = "delete from tb_user_abandon_paint where `abandon_id` = ?";
        return update(sql, abandonID);
    }

    @Override
    public int updateAbandon(Abandon abandon) {
        String sql = "update tb_user_abandon_paint set `user_id`=?,`paint_id`=? where `abandon_id` = ?";
        return update(sql, abandon.getUserID(), abandon.getPaintID(), abandon.getAbandonID());
    }

    @Override
    public Abandon queryAbandonById(Abandon abandonID) {
        String sql = "select `abandon_id` abandonID,`user_id` userID,`paint_id` paintID from tb_user_abandon_paint where `abandon_id` = ?";
        return queryForOne(Abandon.class, sql, abandonID);
    }

    @Override
    public List<Abandon> queryAbandons() {
        String sql = "select `abandon_id` abandonID,`user_id` userID, `paint_id` paintID from tb_user_abandon_paint";
        return queryForList(Abandon.class, sql);
    }

    @Override
    public List<Abandon> queryAbandonsByUserId(Integer userID) {
        String sql = "select `abandon_id` abandonID, `user_id` userID,`paint_id` paintID from tb_user_abandon_paint where `user_id`=?";
        return queryForList(Abandon.class, sql, userID);
    }
}
