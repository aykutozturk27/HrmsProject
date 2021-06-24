package kodlamaio.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "confirm_by_employees")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)

public class ConfirmByEmployee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "is_confirmed")
	private Boolean isConfirmed;
	
	@Column(name = "confirm_date")
	@CreationTimestamp
    @Temporal(javax.persistence.TemporalType.DATE)
	private Date confirmDate;
	
	@ManyToOne()
	@JoinColumn(name="employee_id")
	private Employee employee;
	
	@ManyToOne()
	@JoinColumn(name="employer_id")
	private Employer employer;
}
