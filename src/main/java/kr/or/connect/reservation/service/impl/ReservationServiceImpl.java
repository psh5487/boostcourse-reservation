package kr.or.connect.reservation.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.connect.reservation.dao.ProductDao;
import kr.or.connect.reservation.dto.ProductDto;

import kr.or.connect.reservation.service.ReservationService;

@Service
public class ReservationServiceImpl implements ReservationService{
	@Autowired
	ProductDao productDao;
	
	@Override
	@Transactional
	public List<ProductDto> getProducts(Integer start) {
		List<ProductDto> list = productDao.productAll(start, ReservationService.LIMIT);
		return list;
	}
	
	@Override
	@Transactional
	public List<ProductDto> getProductsInCategory(Integer start, Integer category) {
		List<ProductDto> list = productDao.productInCategory(category, start, ReservationService.LIMIT);
		return list;
	}

	@Override
	public int getCountAll() {
		return productDao.countAll();
	}
	
	@Override
	public int getCountWithinCategory(Integer category) {
		return productDao.countWithinCategory(category);
	}
	
	@Override
	@Transactional
	public List<ProductDto> getPromotion() {
		List<ProductDto> list = productDao.promotion();
		return list;
	}
}
