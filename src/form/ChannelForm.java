package form;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.model.Channel;
import util.Contants;

public class ChannelForm implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7775954600654251028L;
	private Channel channel;
	private List<Channel> channelSet;
	private Integer currentPage;
	private Integer pageCount;
	private Integer resultCount;
	private Boolean resultFlag;
	private List<LabelValueStrBean> typeList = new ArrayList<LabelValueStrBean>();
	private Map<String, String> languageMap = new HashMap<String, String>();
	private Map<String, String> areaMap = new HashMap<String, String>();
	private Map<String, String> catalogMap = new HashMap<String, String>();
	
	public void initView(boolean resultFlag) {
		this.languageMap.put("EN","EN");
		this.languageMap.put("CN", "Chinese");
		
		this.areaMap.put("SH", "上海");
		this.areaMap.put("BJ", "北京");
		
		// 节目的状态
		this.typeList.add(new LabelValueStrBean(Contants.CHECK_TYPE_1, "1"));
		this.typeList.add(new LabelValueStrBean(Contants.CHECK_TYPE_2, "2"));
		this.typeList.add(new LabelValueStrBean(Contants.CHECK_TYPE_3, "3"));
		// 检索结果显示标示
		this.resultFlag = resultFlag;
	}

	public Channel getChannel() {
		return channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}

	public List<Channel> getChannelSet() {
		return channelSet;
	}

	public void setChannelSet(List<Channel> channelSet) {
		this.channelSet = channelSet;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getPageCount() {
		return pageCount;
	}

	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}

	public Integer getResultCount() {
		return resultCount;
	}

	public void setResultCount(Integer resultCount) {
		this.resultCount = resultCount;
	}

	public Boolean getResultFlag() {
		return resultFlag;
	}

	public void setResultFlag(Boolean resultFlag) {
		this.resultFlag = resultFlag;
	}

	public List<LabelValueStrBean> getTypeList() {
		return typeList;
	}

	public void setTypeList(List<LabelValueStrBean> typeList) {
		this.typeList = typeList;
	}

	public Map<String, String> getLanguageMap() {
		return languageMap;
	}

	public void setLanguageMap(Map<String, String> languageMap) {
		this.languageMap = languageMap;
	}

	public Map<String, String> getAreaMap() {
		return areaMap;
	}

	public void setAreaMap(Map<String, String> areaMap) {
		this.areaMap = areaMap;
	}

	public Map<String, String> getCatalogMap() {
		return catalogMap;
	}

	public void setCatalogMap(Map<String, String> catalogMap) {
		this.catalogMap = catalogMap;
	}
	
}
