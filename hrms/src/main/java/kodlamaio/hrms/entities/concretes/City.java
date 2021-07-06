package kodlamaio.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "cities")
@AllArgsConstructor
@NoArgsConstructor

public class City {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "city_name")
	private String cityName;
	
	@JsonIgnore
    @Column(name= "created_date")
    @CreationTimestamp
    @Temporal(javax.persistence.TemporalType.DATE)
	private Date createdDate;

	@Column(name = "is_active")
	private Boolean isActive;
	
	@JsonIgnore
	@OneToOne(mappedBy = "city")
    private JobAdvertisement jobAdvertisement;
	
}
