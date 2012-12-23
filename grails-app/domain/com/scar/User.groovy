package com.scar

class User {

	transient springSecurityService

	String username
	String password
	String name
	boolean enabled
	boolean accountExpired
	boolean accountLocked
	boolean passwordExpired
	byte[] image
	Role role

	static belongsTo = Role

	static constraints = {
		username blank: false, unique: true
		password blank: false
		name blank: false, unique: true
		image maxSize: 8388608, nullable: true
	}

	static mapping = {
		password column: '`password`'
	}

	Set<Role> getAuthorities() {
		UserRole.findAllByUser(this).collect { it.role } as Set
	}

	def beforeInsert() {
		encodePassword()
	}

	def beforeUpdate() {
		if (isDirty('password')) {
			encodePassword()
		}
	}

	protected void encodePassword() {
		password = springSecurityService.encodePassword(password)
	}
}
