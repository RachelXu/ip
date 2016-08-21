package dao.model;

/**
 * 
 */

public class Channel implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String channelId;
	private String channelName;
	private String channelIP;
	private String channelPic;
	private String channelUrl;
	private String urlType;
	private String channelType;
	private String languageID;
	private ProductSet productSet;
	
        
	/** default constructor */
	public Channel() {
	}

	public Channel(String channelId, String channelName) {
		this.channelId = channelId;
		this.channelName = channelName;
	}

	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public String getChannelIP() {
		return channelIP;
	}

	public void setChannelIP(String channelIP) {
		this.channelIP = channelIP;
	}

	public String getChannelPic() {
		return channelPic;
	}

	public void setChannelPic(String channelPic) {
		this.channelPic = channelPic;
	}

	public String getChannelUrl() {
		return channelUrl;
	}

	public void setChannelUrl(String channelUrl) {
		this.channelUrl = channelUrl;
	}

	public String getUrlType() {
		return urlType;
	}

	public void setUrlType(String urlType) {
		this.urlType = urlType;
	}

	public String getLanguageID() {
		return languageID;
	}

	public void setLanguageID(String languageID) {
		this.languageID = languageID;
	}

	public ProductSet getProductSet() {
		return productSet;
	}

	public void setProductSet(ProductSet productSet) {
		this.productSet = productSet;
	}

	public String getChannelType() {
		return channelType;
	}

	public void setChannelType(String channelType) {
		this.channelType = channelType;
	}




}