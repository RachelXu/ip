package form;

import java.io.Serializable;
import java.util.List;

import dao.model.Channel;
import dao.model.ProductCard;
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
	
	public void initView(boolean resultFlag) {
		// 节目的状态
//		this.typeList.add(new LabelValueStrBean(Contants.CHECK_TYPE_1, "1"));
//		this.typeList.add(new LabelValueStrBean(Contants.CHECK_TYPE_2, "2"));
//		this.typeList.add(new LabelValueStrBean(Contants.CHECK_TYPE_3, "3"));
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
	
	

}
