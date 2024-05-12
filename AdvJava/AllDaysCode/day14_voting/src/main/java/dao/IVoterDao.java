package dao;

import pojos.Voter;

public interface IVoterDao {
//add a method decl for user auth.
	Voter authenticateUser(String name,String pwd);
	//add a method : to change voting status
	String updateVotingStatus(int voterId);
}
