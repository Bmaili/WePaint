package com.wepaint.mvc.dao;

import com.wepaint.mvc.bean.Publish;

import java.util.List;

public interface PublishDao {
    public int addPublish(Publish publish);

    public int deletePublishById(Integer id);

    public int updatePublish(Publish publish);

    public Publish queryPublishById(Integer id);

    public List<Publish> queryPublishs();

    public List<Publish> queryPublishsByUserId(Integer userID);
}
