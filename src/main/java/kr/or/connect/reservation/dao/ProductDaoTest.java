package kr.or.connect.reservation.dao;

import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.connect.reservation.config.ApplicationConfig;
import kr.or.connect.reservation.dto.ProductDto;
import kr.or.connect.reservation.dao.ProductDao;

public class ProductDaoTest {
	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		ProductDao productDao = ac.getBean(ProductDao.class);
		ProductDto productDto = new ProductDto();
		
//		List<ProductDto> list = productDao.productAll(0, 10);
//		List<ProductDto> list = productDao.productInCategory(2, 0, 10);
		List<ProductDto> list = productDao.promotion();
		
		for(ProductDto product: list) {
			System.out.println(product);
		}
	}
}
