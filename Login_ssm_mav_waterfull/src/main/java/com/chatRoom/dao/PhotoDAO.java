package com.chatRoom.dao;

import com.chatRoom.model.Photo;
import java.math.BigDecimal;

public interface PhotoDAO {
    int deleteByPrimaryKey(BigDecimal id);

    int insert(Photo record);

    int insertSelective(Photo record);

    Photo selectByPrimaryKey(BigDecimal id);

    int updateByPrimaryKeySelective(Photo record);

    int updateByPrimaryKey(Photo record);
}