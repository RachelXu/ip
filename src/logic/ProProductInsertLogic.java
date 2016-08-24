/**
 * IPTV播控平台
 */
package logic;

import form.ProductForm;

/**
 * 用户检索主逻辑处理类
 * 
 * @author 郑悦
 * 
 */
public class ProProductInsertLogic {

	/**
	 * 用户检索逻辑主处理
	 * 
	 * @param form
	 *            用户信息表单
	 * @return UserDTO 用户信息DTO
	 */
	public LogicDTO doLogic(ProductForm form) throws Exception {
		LogicDTO dto = new LogicDTO();
		dto.setResult(true);

		return dto;
	}


}
