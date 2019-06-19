package Account;

import Login.Hashing;


public class Staff {

	private String username;
	private String password;
	private String role;
        private String name;
        // variable to determine whether a staff member is logged in or not
        private boolean loggedIn;
        private int id;

	/**
	 * 
	 * @param id
	 * @param pass
	 * @param role
	 */
	public Staff (String username, String password, String role, String name) {
		this.username = username;
                this.password = password;
                this.role = role;
                this.name = name;
	}

        public Staff() {}    
        
        
	public String getUsername() {
		return this.username;

	}

	/**
	 * 
	 * @param id
	 */
        
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	/**
	 * 
	 * @param password
	 */
	public void setPassword(String password) {
                Hashing hashing = new Hashing(10);
		this.password = hashing.hashPassword(password);
	}
        

	public String getRole() {
		return this.role;
	}

	/**
	 * 
	 * @param role
	 */
	public void setRole(String role) {
		this.role = role;
	}

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public boolean isLoggedIn() {
            return loggedIn;
        }

        public void setLoggedIn(boolean loggedIn) {
            this.loggedIn = loggedIn;
        }

        

	public void checkAlerts() {
		// TODO - implement Staff.checkAlerts
		throw new UnsupportedOperationException();
	}

        // Login stuff
        
        
        
}