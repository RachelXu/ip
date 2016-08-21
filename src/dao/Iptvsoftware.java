package dao;

/**
 * Iptvsoftware entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Iptvsoftware implements java.io.Serializable {

	// Fields

	private Integer id;
	private String content;
	private String upDate;
	private String version;
	private String usedate;
	private String filename;

	// Constructors

	/** default constructor */
	public Iptvsoftware() {
	}

	/** minimal constructor */
	public Iptvsoftware(Integer id, String version, String filename) {
		this.id = id;
		this.version = version;
		this.filename = filename;
	}

	/** full constructor */
	public Iptvsoftware(Integer id, String content, String upDate,
			String version, String usedate, String filename) {
		this.id = id;
		this.content = content;
		this.upDate = upDate;
		this.version = version;
		this.usedate = usedate;
		this.filename = filename;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUpDate() {
		return this.upDate;
	}

	public void setUpDate(String upDate) {
		this.upDate = upDate;
	}

	public String getVersion() {
		return this.version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getUsedate() {
		return this.usedate;
	}

	public void setUsedate(String usedate) {
		this.usedate = usedate;
	}

	public String getFilename() {
		return this.filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

}