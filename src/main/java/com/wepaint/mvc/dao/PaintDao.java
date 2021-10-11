package com.wepaint.mvc.dao;

import com.wepaint.mvc.bean.Paint;

import java.util.List;

public interface PaintDao {
    public int addPaint(Paint paint);

    public int deletePaintById(Integer id);

    public int updatePaint(Paint paint);

    public Paint queryPaintById(Integer id);

    public List<Paint> queryPaints();

}
