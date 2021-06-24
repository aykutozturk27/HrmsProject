package kodlamaio.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import kodlamaio.hrms.entities.abstracts.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "candidates")
@EqualsAndHashCode(callSuper = false)

public class Candidate extends User {

	@Column(name = "user_id")
	private int userId;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Pattern(regexp = "^[1-9][0-9]{9}[02468]$", message = "National identity can't start with 0 or contain text.")
	@Column(name = "national_identity")
	private String nationalIdentity;
	
	@Column(name = "birth_date")
	@CreationTimestamp
    @Temporal(javax.persistence.TemporalType.DATE)
	//@Convert(converter = LocalDateConverter.class)
	private Date birthDate;
	
	@JsonIgnore
	@Column(name = "created_date")
	@CreationTimestamp
    @Temporal(javax.persistence.TemporalType.DATE)
	private Date createdDate;
	
	@Column(name = "is_active")
	private Boolean isActive;
	
}
