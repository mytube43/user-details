package com.channel.service.user.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.channel.service.user.entity.User;
import com.channel.service.user.entity.UserPK;
import com.channel.service.user.entity.Video;
import com.channel.service.user.entity.VideoPK;

@Repository
public interface VideoFeedRepository extends CrudRepository<Video, VideoPK> {
	 
}

