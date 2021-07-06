package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "job_advertisements")
@NoArgsConstructor
@AllArgsConstructor

public class JobAdvertisement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "job_description")
	private String jobDescription;

	@Column(name = "salary_min")
	private int salaryMin;

	@Column(name = "salary_max")
	private int salaryMax;

	@Column(name = "open_position_count")
	private int openPositionCount;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@JsonFormat(pattern = "dd/MM/yyyy")
	@Column(name = "release_date")
	private LocalDate releaseDate;//yayın tarihi

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@JsonFormat(pattern = "dd/MM/yyyy")
	@Column(name = "dead_line")
	private LocalDate deadLine;//son başvuru tarihi

	@JsonIgnore
    @Column(name= "created_date")
    @CreationTimestamp
    @Temporal(javax.persistence.TemporalType.DATE)
	private Date createdDate;

	@Column(name = "is_active")
	private Boolean isActive;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "job_position_id", referencedColumnName = "id")
	private JobPosition jobPosition;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "city_id", referencedColumnName = "id")
	private City city;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "employer_id", referencedColumnName = "id")
	private Employer employer;
}
