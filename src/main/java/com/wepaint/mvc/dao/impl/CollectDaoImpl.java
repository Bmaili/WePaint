package com.wepaint.mvc.dao.impl;

import com.wepaint.mvc.bean.Collect;
import com.wepaint.mvc.dao.CollectDao;

import java.util.List;

public class CollectDaoImpl extends BaseDao implements CollectDao {
    @Override
    public int addCollect(Collect collect) {
        String sql = "insert into tb_user_collect_paint(`user_id`,`publish_id`)values(?,?)";
        return update(sql,collect.getUserID(),collect.getPublishID());
    }

    @Override
    public int deleteCollectById(Collect collectID) {
        String sql = "delete from tb_user_collect_paint where `collect_id` = ?";
        return update(sql,collectID);
    }

    @Override
    public int updateCollect(Collect collect) {
        String sql = "update tb_user_collect_paint set `user_id`=?,`publish_id`=? where `collect_id` = ?";
        return update(sql,collect.getUserID(),collect.getPublishID(),collect.getCollectID());
    }

    @Override
    public Collect queryCollectById(Collect collectID) {
        String sql = "select `collect_id` collectID,`user_id` userID,`publish_id` publishID from tb_user_collect_paint where `collect_id` = ?";
        return queryForOne(Collect.class, sql,collectID);
    }

    @Override
    public List<Collect> queryCollects() {
        String sql = "select `collect_id` collectID,`user_id` userID, `publish_id` publishID from tb_user_collect_paint";
        return queryForList(Collect.class,sql);
    }

    @Override
    public List<Collect> queryCollectsByUserId(Integer userID) {
        String sql = "select `collect_id` collectID, `user_id` userID,`publish_id` publishID from tb_user_collect_paint where `user_id`=?";
        return queryForList(Collect.class,sql,userID);
    }
}
