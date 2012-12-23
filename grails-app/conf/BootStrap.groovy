import com.scar.*

class BootStrap {

    def init = { servletContext ->

    	// Roles
		def userRole = Role.findByAuthority("ROLE_USER") ?: new Role(authority: "ROLE_USER").save(failOnError: true)
		def adminRole = Role.findByAuthority("ROLE_ADMIN") ?: new Role(authority: "ROLE_ADMIN").save(failOnError: true)
		//def rolePackageRole = Role.findByAuthority("ROLE_ROLE_PACKAGE") ?: new Role(authority: "ROLE_ROLE_PACKAGE").save(failOnError: true)
		def policemanRole = Role.findByAuthority("ROLE_POLICEMAN") ?: new Role(authority: "ROLE_POLICEMAN").save(failOnError: true)
		
		// Users
		def userAdmin = User.findByUsername("admin") ?: new User(username: "admin",
																 password: "alvaro",
																 name: "Admin",
																 enabled: true,
																 accountExpired: false,
																 accountLocked: false,
																 passwordExpired: false,
																 role: adminRole).save(failOnError: true)

		def user = User.findByUsername("user") ?: new User(username: "user",
																 password: "alvaro",
																 name: "Normal User",
																 enabled: true,
																 accountExpired: false,
																 accountLocked: false,
																 passwordExpired: false,
																 role: userRole).save(failOnError: true)

		def userPoliceman = User.findByUsername("policeman") ?: new User(username: "policeman",
																 password: "alvaro",
																 name: "Policeman",
																 enabled: true,
																 accountExpired: false,
																 accountLocked: false,
																 passwordExpired: false,
																 role: policemanRole).save(failOnError: true)

		UserRole.create user, userRole, true
		UserRole.create userAdmin, adminRole, true
		UserRole.create userPoliceman, policemanRole, true
    }

    def destroy = {
    }
}
