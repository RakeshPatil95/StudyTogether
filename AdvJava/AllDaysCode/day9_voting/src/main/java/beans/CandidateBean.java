package beans;

import java.sql.SQLException;
import java.util.List;

import dao.CandidateDaoImpl;
import pojos.Candidate;

public class CandidateBean {
	// dependency : dao
	private CandidateDaoImpl candidateDao;
	//request param : clnt' state candiate id
	private int cId;

	public CandidateBean() throws SQLException {
		// create dao instance
		candidateDao = new CandidateDaoImpl();
		System.out.println("candidate bean created....");

	}
	//getters n setters

	public CandidateDaoImpl getCandidateDao() {
		return candidateDao;
	}

	public void setCandidateDao(CandidateDaoImpl candidateDao) {
		this.candidateDao = candidateDao;
	}
	
	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	//Add B.L method to ret list of candidates.
	public List<Candidate> getAllCandidates() throws SQLException
	{
		return candidateDao.getAllCandidates();
	}
	//add B.L method to increment votes
	public String incrementVotes() throws SQLException
	{
		return candidateDao.incrementCandidateVotes(cId);
	}
}
