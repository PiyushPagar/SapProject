package com.SapPortal.models;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.SapPortal.dto.AdminUserDto;


@NamedNativeQueries(

        {
                @NamedNativeQuery(name =
                        "User.findAllAdminUser",
                        query = "SELECT users.id ,users.email,users.name,users.mobile_number,users.status,admin_details.department,admin_details.position FROM sap_portal.users join admin_details on users.id=admin_details.user_id where status=:status",
                        resultClass = AdminUserDto.class,
                        resultSetMapping = "AdminUserDtoMapping"
                ),
                
        })

@SqlResultSetMappings({
    @SqlResultSetMapping(
            name = "AdminUserDtoMapping",
            classes = {
                    @ConstructorResult(
                            targetClass = AdminUserDto.class,
                            columns = {
                                    @ColumnResult(name = "id", type = Long.class),
                                    @ColumnResult(name = "email", type = String.class),
                                    @ColumnResult(name = "name", type = String.class),
                                    @ColumnResult(name = "mobile_number", type = String.class),
                                    @ColumnResult(name = "status", type = String.class), 
                                    @ColumnResult(name = "department", type = String.class),
                                    @ColumnResult(name = "position", type = String.class)
                            }
                    )
            }
    ),
})
    
@Entity
@Table(name = "users", uniqueConstraints = { @UniqueConstraint(columnNames = "email") })
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	@Size(max = 20)
	@Column(name = "name", nullable = false, length = 60)
	private String name;
	@NotBlank
	@Size(max = 50)
	@Email
	private String email;
	@NotBlank
	@Size(max = 120)
	private String password;
	@NotBlank
	@Size(max = 120)
	private String mobileNumber;
	@NotBlank
	@Size(max = 120)
	private String Status;
	
	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();

	public User() {
	}

	public User(String name, String email, String password,String mobileNumber,String Status) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.mobileNumber=mobileNumber;
		this.Status=Status;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
}