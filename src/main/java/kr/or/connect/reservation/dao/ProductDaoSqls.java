package kr.or.connect.reservation.dao;

public class ProductDaoSqls {
	
	//이미지, 제목, 장소, 설명 노출 되어야 
	public static final String PRODUCT_ALL = "SELECT P.id, P.category_id, P.description, P.content, DI.place_name, FI.save_file_name "
			+ "FROM product P JOIN display_info DI ON (P.id = DI.product_id) JOIN product_image PI ON (P.id = PI.product_id) JOIN file_info FI ON (PI.file_id = FI.id) "
			+ "WHERE PI.type = 'th' ORDER BY P.id DESC limit :start, :limit";


	public static final String PRODUCT_IN_CATEGORY = "SELECT P.description, P.content, DI.place_name, FI.save_file_name "
			+ "FROM product P JOIN display_info DI ON (P.id = DI.product_id) JOIN product_image PI ON (P.id = PI.product_id) JOIN file_info FI ON (PI.file_id = FI.id) "
			+ "WHERE PI.type = 'th' AND P.category_id = :category ORDER BY P.id DESC limit :start, :limit";

	public static final String COUNT_ALL = "SELECT count(*) FROM product";

	public static final String COUNT_WITHIN_CATEGORY = "SELECT count(*) FROM product WHERE category_id = :category";
	
	public static final String PROMOTION = "SELECT FI.save_file_name "
			+ "FROM file_info FI JOIN product_image PI ON (FI.id = PI.file_id), promotion "
			+ "WHERE PI.product_id = promotion.product_id && PI.type = 'th'";
	
}
