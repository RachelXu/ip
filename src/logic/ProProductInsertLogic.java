/**
 * IPTV����ƽ̨
 */
package logic;

import form.ProductForm;

/**
 * �û��������߼�������
 * 
 * @author ֣��
 * 
 */
public class ProProductInsertLogic {

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


}
