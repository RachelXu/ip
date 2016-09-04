/**
 */
package logic;

import java.util.List;
import java.util.Set;

import org.springframework.transaction.annotation.Transactional;

import dao.ChannelDAO;
import dao.ProductSetDAO;
import dao.model.Channel;
import dao.model.ProductSet;
import form.ProductForm;
import util.CommonUtil;
import util.Contants;

/**
 */
@Transactional
public class ProductLogic {

	private ProductSetDAO productSetDao;
	private ChannelDAO channelDao;

	
	public LogicDTO search(ProductForm form) throws Exception {
		LogicDTO dto = new LogicDTO();
		dto.setResult(true);
		int resultCount = productSetDao.getCount(form);
		if (resultCount == 0) {
			dto.setResult(false);
			dto.setErrorCode(Contants.E003);
		} else {
			List<ProductSet> productSetList = productSetDao.getList(form.getProduct().getProductId(),
					form.getProduct().getProductName(), form.getCurrentPage());
			
			form.setPageCount(CommonUtil.getTotalPage(Contants.PAGE_SIZE,
					resultCount));
			form.setResultCount(resultCount);
			form.setProducts(productSetList);
		}
		return dto;
	}
	
	public List<ProductSet> getAllProductSet() {
		return productSetDao.getList(null, null, 0);
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

	public void initProductChannelForm(ProductForm form, String productId) {
		form.setChannels(channelDao.getAvailableChannels());
		ProductSet product = (ProductSet) productSetDao.findById(ProductSet.class, productId);
		form.setProduct(product);		
	}
	

	public ProductSetDAO getProductSetDao() {
		return productSetDao;
	}


	public void setProductSetDao(ProductSetDAO productSetDao) {
		this.productSetDao = productSetDao;
	}

	public ChannelDAO getChannelDao() {
		return channelDao;
	}

	public void setChannelDao(ChannelDAO channelDao) {
		this.channelDao = channelDao;
	}



}
