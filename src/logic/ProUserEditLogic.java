/**
 * IPTV����ƽ̨
 */
package logic;

import util.CommonUtil;
import dao.User;
import dao.UserDAOplus;
import form.UserForm;

/**
 * �û��������߼�������
 * 
 * @author ֣��
 * 
 */
public class ProUserEditLogic {

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
		User user = new User();
		user.setId(form.getId());
		user.setName(form.getName());
		user.setAddress(form.getAddress());
		user.setAge(form.getAge());
		user.setRestDay(CommonUtil.formatStringToInteger(form.getRestDay()));
		user.setComment(form.getComment());
		user.setPhone(form.getPhone());
		user.setPici(form.getGroup());
		user.setPwd(form.getPwd());
		user.setState(form.getState());
		user.setType(form.getType());
		dao.update(user);
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
