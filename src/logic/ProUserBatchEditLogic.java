/**
 * IPTV播控平台
 */
package logic;

import java.util.ArrayList;
import java.util.List;

import util.CommonUtil;
import util.Contants;
import dao.User;
import dao.UserDAOplus;
import form.UserDetil;
import form.UserForm;

/**
 * 用户检索主逻辑处理类
 * 
 * @author 郑悦
 * 
 */
public class ProUserBatchEditLogic {

	private UserDAOplus dao;

	/**
	 * 用户检索逻辑主处理
	 * 
	 * @param form
	 *            用户信息表单
	 * @return UserDTO 用户信息DTO
	 */
	public LogicDTO doLogic(UserForm form) throws Exception {
		LogicDTO dto = new LogicDTO();
		dto.setResult(true);
		int resultCount = dao.batchEditCount(form);
		// 检索结果数量为0
		if (resultCount == 0) {
			dto.setResult(false);
			dto.setErrorCode(Contants.E003);
		} else {
			List<User> userList = dao.batchEditSearch(form);
			List<UserDetil> resultList = new ArrayList<UserDetil>();
			UserDetil userDetil = null;
			for (User user : userList) {
				userDetil = new UserDetil();
				// id
				userDetil.setId(user.getId());
				// 姓名
				userDetil.setName(user.getName());
				// 状态
				if (!CommonUtil.isEmpty(user.getState())) {
					userDetil
							.setState(user.getState() == 1 ? Contants.USER_STATE_1
									: Contants.USER_STATE_2);
				}
				// 类型
				if (!CommonUtil.isEmpty(user.getType())) {
					userDetil
							.setType(user.getType() == 1 ? Contants.USER_TYPE_1
									: Contants.USER_TYPE_2);
				}
				// 剩余天数
				userDetil.setRestday(CommonUtil.formatIntegerToString(user
						.getRestDay()));
				// 所属批次
				userDetil.setGroup(user.getPici());
				resultList.add(userDetil);
			}
			form.setResultList(resultList);
		}
		return dto;
	}

	/**
	 * @return the dao
	 */
	public UserDAOplus getDao() {
		return dao;
	}

	/**
	 * @param dao
	 *            the dao to set
	 */
	public void setDao(UserDAOplus dao) {
		this.dao = dao;
	}

}
