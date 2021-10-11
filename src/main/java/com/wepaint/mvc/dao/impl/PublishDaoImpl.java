package com.wepaint.mvc.dao.impl;

import com.wepaint.mvc.bean.Publish;
import com.wepaint.mvc.dao.PublishDao;

import java.util.List;

public class PublishDaoImpl extends BaseDao implements PublishDao {
    @Override
    public int addPublish(Publish publish) {
        String sql = "insert into tb_publish(`publish_name`,`user_id`,`username`,`collect_num`,`like_num`,`publish_time`,`json_data`,`img_path`) values(?,?,?,?,?,?,?,?)";
        return update(sql, publish.getPublishName(), publish.getUserID(), publish.getUserName(), publish.getCollectNum(), publish.getLikeNum(), publish.getPublishTime(), publish.getJsonData(), publish.getImgPath());
    }

    @Override
    public int deletePublishById(Integer publishID) {
        String sql = "delete from tb_publish where `publish_id` = ?";
        return update(sql, publishID);
    }

    @Override
    public int updatePublish(Publish publish) {
        String sql = "update tb_publish set `publish_name`=?,`user_id`=?,`username`=?,`collect_num`=?,`like_num`=?,`publish_time`=? ,`json_data`=?,`img_path`=? where `publish_id` = ?";
        return update(sql, publish.getPublishName(), publish.getUserID(), publish.getUserName(), publish.getCollectNum(), publish.getLikeNum(), publish.getPublishTime(), publish.getJsonData(), publish.getImgPath(), publish.getPublishID());
    }

    @Override
    public Publish queryPublishById(Integer publishID) {
        String sql = "select `publish_id` publishID, `publish_name` publishName, `user_id` userID, `username` userName, `collect_num` collectNum, `like_num` likeNum, `publish_time` publishTime, `json_data` jsonData , `img_path` imgPath from tb_publish where `publish_id` = ?";
        return queryForOne(Publish.class, sql, publishID);
    }

    @Override
    public List<Publish> queryPublishs() {
        String sql = "select `publish_id` publishID, `publish_name` publishName, `user_id` userID, `username` userName, `collect_num` collectNum, `like_num` likeNum, `publish_time` publishTime, `json_data` jsonData , `img_path` imgPath from tb_publish";
        return queryForList(Publish.class, sql);
    }

    @Override
    public List<Publish> queryPublishsByUserId(Integer userID) {
        String sql = "select `publish_id` publishID, `publish_name` publishName, `user_id` userID, `username` userName, `collect_num` collectNum, `like_num` likeNum, `publish_time` publishTime, `json_data` jsonData , `img_path` imgPath from tb_publish where `user_id` = ?";
        return queryForList(Publish.class, sql, userID);
    }
}
