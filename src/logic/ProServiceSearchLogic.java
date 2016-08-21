/**
 * IPTV播控平台
 */
package logic;

import java.util.List;

import util.CommonUtil;
import util.Contants;
import dao.ServiecType;
import dao.ServiecTypeDAO;
import form.ServiceForm;

/**
 * 充值卡检索主逻辑处理类
 * 
 * @author 郑悦
 * 
 */
public class ProServiceSearchLogic {

	private ServiecTypeDAO dao;

	/**
	 * 充值卡检索逻辑主处理
	 * 
	 * @param form
	 *            充值卡信息表单
	 * @return UserDTO 用户信息DTO
	 */
	public LogicDTO doLogic(ServiceForm form) throws Exception {
		LogicDTO dto = new LogicDTO();
		dto.setResult(true);
		ServiecType entity = new ServiecType();
		if (!CommonUtil.isEmpty(form.getServiceName())) {
			entity.setServiceName(form.getServiceName());
		}
		entity.setServiceDay(form.getServiceDay());
		List<ServiecType> serviecTypeList = dao.findByExample(entity);
		int resultCount = serviecTypeList.size();
		// 检索结果数量为0
		if (resultCount == 0) {
			dto.setResult(false);
			dto.setErrorCode(Contants.E003);
		} else {

			// 总页数
			form.setPageCount(CommonUtil.getTotalPage(Contants.PAGE_SIZE,
					resultCount));
			// 记录数
			form.setResultCount(resultCount);
			form.setResultList(serviecTypeList);
		}
		return dto;
	}

	/**
	 * @return the dao
	 */
	public ServiecTypeDAO getDao() {
		return dao;
	}

	/**
	 * @param dao
	 *            the dao to set
	 */
	public void setDao(ServiecTypeDAO dao) {
		this.dao = dao;
	}

}
