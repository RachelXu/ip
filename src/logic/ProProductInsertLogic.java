/**
 * IPTV����ƽ̨
 */
package logic;

import dao.ProductDAO;
import form.ProductForm;
import util.CommonUtil;
import util.Contants;

/**
 * �û��������߼�������
 * 
 * @author ֣��
 * 
 */
public class ProProductInsertLogic {

	private ProductDAO daoProduct;

	/**
	 * �û������߼�������
	 * 
	 * @param form
	 *            �û���Ϣ��
	 * @return UserDTO �û���ϢDTO
	 */
	public LogicDTO doLogic(ProductForm form) throws Exception {
		LogicDTO dto = new LogicDTO();
		dto.setResult(true);

		return dto;
	}

	public ProductDAO getDaoProduct() {
		return daoProduct;
	}

	public void setDaoProduct(ProductDAO daoProduct) {
		this.daoProduct = daoProduct;
	}


}
