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
public class ProductSetLogic {

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


	public ProductSetDAO getProductSetDao() {
		return productSetDao;
	}


	public void setProductSetDao(ProductSetDAO productSetDao) {
		this.productSetDao = productSetDao;
	}



}
