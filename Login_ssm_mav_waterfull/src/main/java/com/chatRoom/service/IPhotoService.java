package com.chatRoom.service;

import java.math.BigDecimal;

import com.chatRoom.model.Photo;

public interface IPhotoService {
   int insert(String pName);
   public Photo getPhotoById(BigDecimal photoId);
}
