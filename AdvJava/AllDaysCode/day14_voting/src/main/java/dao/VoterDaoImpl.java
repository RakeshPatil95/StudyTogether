package dao;

import pojos.Voter;
import static utils.HibernateUtils.getFactory;
import org.hibernate.*;

public class VoterDaoImpl implements IVoterDao {

	@Override
	public Voter authenticateUser(String name, String pwd) {
		Voter voter = null;
		String jpql = "select v from Voter v where v.name=:nm and v.password=:pass";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			voter = session.createQuery(jpql, Voter.class).setParameter("nm", name).setParameter("pass", pwd)
					.getSingleResult();
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return voter;
	}

	@Override
	public String updateVotingStatus(int voterId) {
		String mesg="Updating voting status failed";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			Voter voter=session.get(Voter.class, voterId);
			if(voter != null)
			{
				//voter : PERSISTENT
				voter.setStatus(true);
				mesg="Updated voting status of Voter : "+voter.getName();
			}
			tx.commit();//update
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}

}
