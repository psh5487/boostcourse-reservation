package kr.or.connect.reservation.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.or.connect.reservation.dto.ProductDto;
import kr.or.connect.reservation.service.ReservationService;

@RestController
@RequestMapping(path="/api")
public class ReservationApiController {
	@Autowired
	ReservationService reservationService;
	
	@GetMapping("/promotions")
	public Map<String, Object> listInPromotion() {
		List<ProductDto> listInPromotion = reservationService.getPromotion();
		
		Map<String, Object> map = new HashMap<>();
		map.put("list", listInPromotion);
		
		return map;
	}
	
	@GetMapping("/products")
	public Map<String, Object> list(@RequestParam(name="start", required=false, defaultValue="0") int start) {		
		List<ProductDto> list = reservationService.getProducts(start);
		
		// 전체 페이지수 구하기
		int count = reservationService.getCountAll();
		int pageCount = count / ReservationService.LIMIT;
		if(count % ReservationService.LIMIT > 0)
			pageCount++;
		
		// 페이지 수만큼 start의 값을 리스트로 저장
		// 예를 들면 페이지수가 3이면
		// 0, 4, 8 이렇게 저장된다.
		// list?start=0 , list?start=4, list?start=8 으로 링크가 걸린다.
		List<Integer> pageStartList = new ArrayList<>();
		for(int i = 0; i < pageCount; i++) {
			pageStartList.add(i * ReservationService.LIMIT);
		}
		
		Map<String, Object> map = new HashMap<>();
		map.put("list", list);
		map.put("count", count);
		map.put("pageStartList", pageStartList);
		
		return map;
	}
	
	@GetMapping("/products/{category}")
	public Map<String, Object> listInCategory(@PathVariable(name="category") int category, 
											  @RequestParam(name="start", required=false, defaultValue="0") int start) {
		List<ProductDto> listInCategory = reservationService.getProductsInCategory(start, category);
		
		// 카테고리에 속한 페이지수 구하기
		int countInCategory = reservationService.getCountWithinCategory(category);
		int pageCountInCategory = countInCategory / ReservationService.LIMIT;
		if(countInCategory % ReservationService.LIMIT > 0)
			pageCountInCategory++;
		
		// 페이지 수만큼 start의 값을 리스트로 저장
		List<Integer> pageStartListInCategory = new ArrayList<>();
		for(int i = 0; i < pageCountInCategory; i++) {
			pageStartListInCategory.add(i * ReservationService.LIMIT);
		}
		
		Map<String, Object> map = new HashMap<>();
		map.put("list", listInCategory);
		map.put("count", countInCategory);
		map.put("pageStartList", pageStartListInCategory);
		
		return map;
	}
	
}
