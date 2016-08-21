/**
 * IPTV����ƽ̨
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
 * �û��������߼�������
 * 
 * @author ֣��
 * 
 */
public class ProUserBatchEditLogic {

	private UserDAOplus dao;

	/**
	 * �û������߼�������
	 * 
	 * @param form
	 *            �û���Ϣ��
	 * @return UserDTO �û���ϢDTO
	 */
	public LogicDTO doLogic(UserForm form) throws Exception {
		LogicDTO dto = new LogicDTO();
		dto.setResult(true);
		int resultCount = dao.batchEditCount(form);
		// �����������Ϊ0
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
				// ����
				userDetil.setName(user.getName());
				// ״̬
				if (!CommonUtil.isEmpty(user.getState())) {
					userDetil
							.setState(user.getState() == 1 ? Contants.USER_STATE_1
									: Contants.USER_STATE_2);
				}
				// ����
				if (!CommonUtil.isEmpty(user.getType())) {
					userDetil
							.setType(user.getType() == 1 ? Contants.USER_TYPE_1
									: Contants.USER_TYPE_2);
				}
				// ʣ������
				userDetil.setRestday(CommonUtil.formatIntegerToString(user
						.getRestDay()));
				// ��������
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
