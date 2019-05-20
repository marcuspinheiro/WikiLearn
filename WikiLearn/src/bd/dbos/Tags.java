package bd.dbos;

public class Tags {
	private String tag;
	private int idTag;

	public Tags(int idTag, String tag) {
		this.idTag = idTag;
		this.tag = tag;
	}

	public Tags() {

	}

	public String getTag() {
		return tag;
	}

	/**
	 * @param tag
	 *            the tag to set
	 */
	public void setTag(String tag) {
		this.tag = tag;
	}

	/**
	 * @return the idTag
	 */
	public int getIdTag() {
		return idTag;
	}

	/**
	 * @param idTag
	 *            the idTag to set
	 */
	public void setIdTag(int idTag) {
		this.idTag = idTag;
	}

}
