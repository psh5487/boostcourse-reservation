package kr.or.connect.reservation.service;

import java.util.List;

import kr.or.connect.reservation.dto.ProductDto;

public interface ReservationService {
	public static final Integer LIMIT = 4;
	
	public List<ProductDto> getProducts(Integer start);
	public List<ProductDto> getProductsInCategory(Integer start, Integer category);
	public int getCountAll();
	public int getCountWithinCategory(Integer category);
	public List<ProductDto> getPromotion();
}