package org.sample.data.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.sample.jpa.App;
import org.sample.jpa.data.model.Parameter;
import org.sample.jpa.service.ParameterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class DataTest {

	@Autowired
	ParameterService paramService;

	@Test
	public void executesQueryMethodsCorrectly() {
		Parameter city = this.paramService.findAll(new PageRequest(0, 1, Direction.ASC, "name")).getContent().get(0);
		assertThat(city.getName()).isEqualTo("PARAM1");

		//		Page<HotelSummary> hotels = this.repository.findByCity(city, new PageRequest(0, 10, Direction.ASC, "name"));
		//		Hotel hotel = this.repository.findByCityAndName(city, hotels.getContent().get(0).getName());
		//		assertThat(hotel.getName()).isEqualTo("Doubletree");
		//
		//		List<RatingCount> counts = this.repository.findRatingCounts(hotel);
		//		assertThat(counts).hasSize(1);
		//		assertThat(counts.get(0).getRating()).isEqualTo(Rating.AVERAGE);
		//		assertThat(counts.get(0).getCount()).isGreaterThan(1L);
	}
}
