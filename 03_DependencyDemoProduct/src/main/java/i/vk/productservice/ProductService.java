package i.vk.productservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import i.vk.dao.ProductDao;

@Service
public class ProductService {
	private ProductDao dao;
	
	@Autowired
	public void setDao(ProductDao dao) {
		this.dao = dao;
	}

	public void saveProduct() {
		dao.saveProduct();
	}
}
