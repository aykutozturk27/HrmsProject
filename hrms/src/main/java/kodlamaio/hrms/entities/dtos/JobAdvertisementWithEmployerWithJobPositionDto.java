package kodlamaio.hrms.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisementWithEmployerWithJobPositionDto {

	private int id;
	private String companyName;
	private String jobDescriptionName;
	private int openPositionCount;
	private LocalDate releaseDate;
	private LocalDate deadLine;
	
}
