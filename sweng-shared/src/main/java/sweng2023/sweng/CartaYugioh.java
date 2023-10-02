package sweng2023.sweng;

import java.io.Serializable;

public class CartaYugioh extends Carta implements Serializable{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private String type;
	private String desc;
	private String race;
	private String image_url;
	private String small_image_url;

	public String getName() {
		return name;
	}
	public String getType() {
		return type;
	}

	public String getDesc() {
		return desc;
	}

	public String getRace() {
		return race;
	}

	public String getImageUrl() {
		return image_url;
	}

	public String getSmallImageUrl() {
		return small_image_url;
	}
}
