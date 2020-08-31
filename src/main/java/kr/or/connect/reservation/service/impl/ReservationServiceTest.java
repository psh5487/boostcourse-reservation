package kr.or.connect.reservation.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.connect.reservation.config.ApplicationConfig;
import kr.or.connect.reservation.dto.ProductDto;
import kr.or.connect.reservation.service.ReservationService;

public class ReservationServiceTest {
	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class); 
		ReservationService reservationService = ac.getBean(ReservationService.class);
		
//		List<ProductDto> list = reservationService.getProducts(0);
//		
//		for(ProductDto product: list) {
//			System.out.println(product);
//		}
		
//		List<ProductDto> list = reservationService.getProductsInCategory(0, 2);
//		
//		for(ProductDto product: list) {
//			System.out.println(product);
//		}
		
//		int result = reservationService.getCountAll();
//		System.out.println(result);
		
//		int result = reservationService.getCountWithinCategory(2);
//		System.out.println(result);
		
		List<ProductDto> list = reservationService.getPromotion();
		
		for(ProductDto product: list) {
			System.out.println(product);
		}
		
	}
}
