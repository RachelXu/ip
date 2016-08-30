/**
 */
package logic;

import java.util.List;

import dao.ProductSetDAO;
import dao.model.ProductSet;
import form.ProductForm;
import util.CommonUtil;
import util.Contants;

/**
 */
public class ProductLogic {

	private ProductSetDAO productSetDao;

	
	public LogicDTO search(ProductForm form) throws Exception {
		LogicDTO dto = new LogicDTO();
		dto.setResult(true);
		int resultCount = productSetDao.getCount(form);
		if (resultCount == 0) {
			dto.setResult(false);
			dto.setErrorCode(Contants.E003);
		} else {
			List<ProductSet> productSetList = productSetDao.getList(form);
			
			form.setPageCount(CommonUtil.getTotalPage(Contants.PAGE_SIZE,
					resultCount));
			form.setResultCount(resultCount);
			form.setProducts(productSetList);
		}
		return dto;
	}
	
	public boolean delete(String productId) {
		Object o = productSetDao.findById(ProductSet.class, productId);
		if (o != null) {
			productSetDao.delete(o);
		}
		
		return true;
	}
	
	public ProductSet getProductSetById(String productId) {
		return (ProductSet) productSetDao.findById(ProductSet.class, productId);
	}
	
	public boolean create(ProductForm form) {
		productSetDao.create(form);
		return true;
	}

	public boolean update(ProductForm form) {
		productSetDao.update(form);
		return true;
	}


	public ProductSetDAO getProductSetDao() {
		return productSetDao;
	}


	public void setProductSetDao(ProductSetDAO productSetDao) {
		this.productSetDao = productSetDao;
	}



}
