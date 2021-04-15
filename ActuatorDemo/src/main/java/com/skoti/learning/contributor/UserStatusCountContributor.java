package com.skoti.learning.contributor;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.info.Info.Builder;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import com.skoti.learning.repositoy.UserRepository;

/*
 * This class is used to show dynamic values in "actuator/info" end point.
 * Below we are using to show number of active and inactive users as part of "/actuator/info" end point.
 */
@Component
public class UserStatusCountContributor implements InfoContributor{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void contribute(Builder builder) {
		Map<String, Long> userStatusMap = new HashMap<>();
		userStatusMap.put("active", userRepository.getUserStatusCount("active"));
		userStatusMap.put("inactive", userRepository.getUserStatusCount("inactive"));
		builder.withDetail("userStatus", userStatusMap);
	}

}
