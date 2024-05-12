package com.app.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class TutorialDaoImpl implements ITutorialDao {
	//dep : entity mgr
	@Autowired
	private EntityManager mgr;

	@Override
	public List<String> getTutorialNamesByTopic(long topicId) {
		String jpql="select t.tutName from Tutorial t where t.topic.id =:id";
		return mgr.createQuery(jpql, String.class).setParameter("id", topicId).getResultList();
	}

}
