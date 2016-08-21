package action;

import main.ServerMain;
import util.Contents;
import form.EpgDetil;

public class PreEpgManAction extends MySuperAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1334398827287165610L;
	private EpgDetil epg;

	public String execute() throws Exception {
		epg = new EpgDetil();
		epg.setName(Contents.SERVER_NAME);
		epg.setMinPort(Contents.MIN_PORT);
		epg.setMaxPort(Contents.MAX_PORT);
		epg.setState(ServerMain.isFlag() ? "Æô¶¯" : "¹Ø±Õ");
		epg.setStateFlag(ServerMain.isFlag());
		return SUCCESS;
	}

	/**
	 * @return the epg
	 */
	public EpgDetil getEpg() {
		return epg;
	}

	/**
	 * @param epg
	 *            the epg to set
	 */
	public void setEpg(EpgDetil epg) {
		this.epg = epg;
	}

}
