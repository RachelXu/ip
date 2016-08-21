package action;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import util.CommonUtil;
import util.Contants;
import dao.User;
import form.UserDetil;

public class ProUserUploadAction extends MySuperAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1841919829450192876L;
	private File upload;
	private String uploadFileName;
	private String uploadContentType;
	List<User> userList = new ArrayList<User>();
	List<UserDetil> userErrorList = new ArrayList<UserDetil>();
	private boolean showError;
	private boolean showNomal;

	public String execute() throws Exception {
		if (CommonUtil.isEmpty(uploadFileName)) {
			this.addFieldError("field", getText(Contants.E015));
			return INPUT;
		}
		String extString = CommonUtil.getFileExt(uploadFileName);
		if (!Contants.CSV.equals(extString)) {
			this.addFieldError("field", getText(Contants.E004));
			return INPUT;
		}
		int recordCount = 0;
		FileInputStream fis = new FileInputStream(getUpload());
		BufferedReader inBuffer = new BufferedReader(new InputStreamReader(fis));
		String strRecord = null;
		User user = null;
		boolean errorFlag = false;
		while ((strRecord = inBuffer.readLine()) != null) {
			errorFlag = false;
			recordCount++;
			if (recordCount == 1) {
				continue;
			}
			String strRecordTmp = strRecord;
			if (strRecord.endsWith(",")) {
				strRecordTmp = strRecordTmp + " ";
			}
			String[] strs = strRecordTmp.split("[,]");
			user = new User();
			// 用户姓名
			if (CommonUtil.isEmpty(strs[0])) {
				errorFlag = true;
				userErrorList.add(new UserDetil(recordCount, this
						.getText(Contants.E005)));
			} else {
				user.setName(strs[0]);
			}
			// 用户密码
			if (CommonUtil.isEmpty(strs[1])) {
				errorFlag = true;
				userErrorList.add(new UserDetil(recordCount, this
						.getText(Contants.E006)));
			} else {
				user.setPwd(strs[1]);
			}
			// 用户年龄
			if (!CommonUtil.isEmpty(strs[2]) && !CommonUtil.isNumber(strs[2])) {
				errorFlag = true;
				userErrorList.add(new UserDetil(recordCount, this
						.getText(Contants.E011)));
			} else {
				user.setAge(Integer.valueOf(strs[2]));
			}
			// 用户电话
			user.setPhone(strs[3]);
			// 用户住址
			user.setAddress(strs[4]);
			// 用户状态
			if (!CommonUtil.isEmpty(strs[5]) && !CommonUtil.isNumber(strs[5])) {
				errorFlag = true;
				userErrorList.add(new UserDetil(recordCount, this
						.getText(Contants.E008)));
			} else if (!Contants.STRING_1.equals(strs[5])
					&& !Contants.STRING_2.equals(strs[5])) {
				errorFlag = true;
				userErrorList.add(new UserDetil(recordCount, this
						.getText(Contants.E008)));
			} else {
				user.setState(Integer.valueOf(strs[5]));
			}
			// 用户类型
			if (!CommonUtil.isEmpty(strs[6]) && !CommonUtil.isNumber(strs[6])) {
				errorFlag = true;
				userErrorList.add(new UserDetil(recordCount, this
						.getText(Contants.E007)));
			} else if (!Contants.STRING_1.equals(strs[6])
					&& !Contants.STRING_2.equals(strs[6])) {
				errorFlag = true;
				userErrorList.add(new UserDetil(recordCount, this
						.getText(Contants.E007)));
			} else {
				user.setType(Integer.valueOf(strs[6]));
			}
			// 剩余天数
			if (!CommonUtil.isEmpty(strs[7]) && !CommonUtil.isNumber(strs[7])) {
				errorFlag = true;
				userErrorList.add(new UserDetil(recordCount, this
						.getText(Contants.E009)));
			} else {
				user.setRestDay(CommonUtil.formatStringToInteger(strs[7]));
			}
			// 用户批次
			if (!CommonUtil.isEmpty(strs[8]) && !CommonUtil.isNumber(strs[8])) {
				errorFlag = true;
				userErrorList.add(new UserDetil(recordCount, this
						.getText(Contants.E012)));
			} else {
				user.setPici(Integer.valueOf(strs[8]));
			}
			// 备注
			user.setComment(strs[9]);
			if (errorFlag == false) {
				userList.add(user);
			}
		}
		if (userErrorList.size() != 0) {
			showError = true;
			return INPUT;
		} else {
			this.request.getSession().setAttribute("userupload", userList);
			showNomal = true;
			return SUCCESS;
		}
	}

	/**
	 * @return the upload
	 */
	public File getUpload() {
		return upload;
	}

	/**
	 * @param upload
	 *            the upload to set
	 */
	public void setUpload(File upload) {
		this.upload = upload;
	}

	/**
	 * @return the uploadFileName
	 */
	public String getUploadFileName() {
		return uploadFileName;
	}

	/**
	 * @param uploadFileName
	 *            the uploadFileName to set
	 */
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	/**
	 * @return the uploadContentType
	 */
	public String getUploadContentType() {
		return uploadContentType;
	}

	/**
	 * @param uploadContentType
	 *            the uploadContentType to set
	 */
	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	/**
	 * @return the userList
	 */
	public List<User> getUserList() {
		return userList;
	}

	/**
	 * @param userList
	 *            the userList to set
	 */
	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	/**
	 * @return the userErrorList
	 */
	public List<UserDetil> getUserErrorList() {
		return userErrorList;
	}

	/**
	 * @param userErrorList
	 *            the userErrorList to set
	 */
	public void setUserErrorList(List<UserDetil> userErrorList) {
		this.userErrorList = userErrorList;
	}

	/**
	 * @return the showError
	 */
	public boolean isShowError() {
		return showError;
	}

	/**
	 * @param showError
	 *            the showError to set
	 */
	public void setShowError(boolean showError) {
		this.showError = showError;
	}

	/**
	 * @return the showNomal
	 */
	public boolean isShowNomal() {
		return showNomal;
	}

	/**
	 * @param showNomal
	 *            the showNomal to set
	 */
	public void setShowNomal(boolean showNomal) {
		this.showNomal = showNomal;
	}

}
