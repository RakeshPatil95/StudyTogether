package com.app.dao;

import java.util.List;

public interface ITutorialDao {
	List<String> getTutorialNamesByTopic(long topicId);
}
