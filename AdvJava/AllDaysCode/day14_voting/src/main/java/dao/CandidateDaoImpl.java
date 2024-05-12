package dao;

import java.util.List;

import pojos.Candidate;
import static utils.HibernateUtils.getFactory;
import org.hibernate.*;

public class CandidateDaoImpl implements ICandidateDao {

	@Override
	public List<Candidate> getAllCandidates() {
		String jpql="select c from Candidate c";
		List<Candidate> candidates=null;
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			candidates=session.createQuery(jpql, Candidate.class).getResultList();					
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return candidates;
	}

	@Override
	public String incrementCandidateVotes(int candidateId) {
		String mesg="Votes increment failed!!!!!!!!!!!";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			Candidate candidate=session.get(Candidate.class, candidateId);
			if(candidate != null)
			{
				//candidate : persistent
				candidate.setVotes(candidate.getVotes()+1);
				mesg="Votes incremented for the candidate "+candidate.getName();
			}
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}

}
