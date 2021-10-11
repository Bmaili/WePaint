package com.wepaint.mvc.dao.impl;

import com.wepaint.mvc.bean.Have;
import com.wepaint.mvc.bean.Paint;
import com.wepaint.mvc.dao.HaveDao;

import java.util.List;

public class HavaDaoImpl extends BaseDao implements HaveDao {
    @Override
    public int addHave(Have have) {
        String sql = "insert into tb_user_have_paint(`user_id`,`paint_id`)values(?,?)";
        return update(sql,have.getUserID(),have.getPaintID());
    }

    @Override
    public int deleteHaveById(Have haveID) {
        String sql = "delete from tb_user_have_paint where `have_id` = ?";
        return update(sql,haveID);
    }

    @Override
    public int updateHave(Have have) {
        String sql = "update tb_user_have_paint set `user_id`=?,`paint_id`=? where `have_id` = ?";
        return update(sql,have.getUserID(),have.getPaintID(),have.getHaveID());
    }

    @Override
    public Have queryHaveById(Have haveID) {
        String sql = "select `have_id` haveID,`user_id` userID,`paint_id` paintID from tb_user_have_paint where `have_id` = ?";
        return queryForOne(Have.class, sql,haveID);
    }

    @Override
    public List<Have> queryHaves() {
        String sql = "select `have_id` haveID,`user_id` userID, `paint_id` paintID from tb_user_have_paint";
        return queryForList(Have.class,sql);
    }

    @Override
    public List<Have> queryHavesByUserId(Integer userID) {
        String sql = "select `have_id` haveID, `user_id` userID,`paint_id` paintID from tb_user_have_paint where `user_id`=?";
        return queryForList(Have.class,sql,userID);
    }
}
