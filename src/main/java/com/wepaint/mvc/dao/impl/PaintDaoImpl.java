package com.wepaint.mvc.dao.impl;

import com.wepaint.mvc.bean.Paint;
import com.wepaint.mvc.dao.PaintDao;

import java.util.List;

public class PaintDaoImpl extends BaseDao implements PaintDao {
    @Override
    public int addPaint(Paint paint) {

        String sql = "insert into tb_paint(`paint_name`,`user_id`,`create_time`,`last_time`,`json_data`,`img_path`) values(?,?,?,?,?,?)";

        return update(sql, paint.getName(),paint.getUserID(),paint.getCreateTime(),paint.getLastTime(),paint.getJsonData(),paint.getImgPath());

    }

    @Override
    public int deletePaintById(Integer id) {
        String sql = "delete from tb_paint where `paint_id` = ?";
        return update(sql, id);
    }

    @Override
    public int updatePaint(Paint paint) {

        String sql = "update tb_paint set `paint_name`=?,`user_id`=?,`create_time`=?,`last_time`=?,`json_data`=?,`img_path`=? where `paint_id` = ?";
        return update(sql,paint.getName(),paint.getUserID(),paint.getCreateTime(),paint.getLastTime(),paint.getJsonData(),paint.getImgPath(),paint.getId());
    }

    @Override
    public Paint queryPaintById(Integer id) {
        String sql = "select `paint_id` id, `paint_name` name, `user_id` userID, `create_time` createTime, `last_time` lastTime, `json_data` jsonData, `img_path` imgPath from tb_paint where `paint_id` = ?";
        return queryForOne(Paint.class, sql,id);
    }

    @Override
    public List<Paint> queryPaints() {
        String sql = "select `paint_id` id, `paint_name` name, `user_id` userID, `create_time` createTime, `last_time` lastTime, `json_data` jsonData, `img_path` imgPath from tb_paint";
        return queryForList(Paint.class, sql);
    }
}
