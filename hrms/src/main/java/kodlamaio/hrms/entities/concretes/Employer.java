package kodlamaio.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import kodlamaio.hrms.entities.abstracts.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "employers")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@PrimaryKeyJoinColumn(name = "id")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })

public class Employer extends User {
	
	@Column(name = "user_id")
	private int userId;

	@Column(name = "company_name")
	private String companyName;
	
	@Column(name = "web_site")
	private String webSite;
	
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@JsonIgnore
    @Column(name= "created_date")
    @CreationTimestamp
    @Temporal(javax.persistence.TemporalType.DATE)
	private Date createdDate;
	
	@Column(name = "is_active")
	private Boolean isActive;
	
	@OneToOne(mappedBy = "employer")
    private JobAdvertisement jobAdvertisement;
}
