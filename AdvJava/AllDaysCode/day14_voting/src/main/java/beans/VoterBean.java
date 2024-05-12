package beans;

import java.sql.SQLException;

import dao.VoterDaoImpl;
import pojos.Voter;

public class VoterBean {
	// dependency : voter dao
	private VoterDaoImpl voterDao;
	// clnt' state (req params)
	private String name;
	private String pass;
	// user details
	private Voter userDetails;
	// message
	private String message;

	// def ctor
	public VoterBean() throws SQLException {
		// create voter dao instance
		voterDao = new VoterDaoImpl();
		System.out.println("voter bean created....");
	}

	// getters n setters
	public VoterDaoImpl getVoterDao() {
		return voterDao;
	}

	public void setVoterDao(VoterDaoImpl voterDao) {
		this.voterDao = voterDao;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public Voter getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(Voter userDetails) {
		this.userDetails = userDetails;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	// add B.L method for authentication n role based auth , returning navigational
	// outcome
	public String validateUser() throws SQLException {
		System.out.println("in validate user " + name + " " + pass);
		// invoke dao's method
		try {
			userDetails = voterDao.authenticateUser(name, pass);
			// authentication success
			if (userDetails.getRole().equals("voter")) // => voter login
			{
				if (userDetails.isStatus()) // alrdy voted
				{
					message = "You have already voted !!!!!!!!!!!!!!!!!!";
					return "status";
				}
				// voter : not yet voted
				message = "Login Successful";
				return "candidate_list";
			} else {
				message = "Login Successful";
				return "admin";
			}
		} catch (RuntimeException e) {
			// invalid login
			message = "Invalid Login , Please retry....";
			return "login";
		}
		
	}

	// add B.L method to update voting status
	public String updateVotingStatus() throws SQLException {
		return voterDao.updateVotingStatus(userDetails.getId());
	}

}
