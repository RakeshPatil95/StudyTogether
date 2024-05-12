package dao;

import java.util.List;

import pojos.Candidate;

public interface ICandidateDao {
//add a method to ret list of all candidates 
	List<Candidate> getAllCandidates();

	// add a method to incr votes for a specific candidate
	String incrementCandidateVotes(int candidateId) ;

}
