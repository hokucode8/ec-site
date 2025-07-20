//*******************************************
//　　　商品テーブルクラス
//*******************************************

package jp.co.internous.ecsite.model.domain;

import java.sql.Timestamp;

public class MstGoods {

	//商品ID（商品情報の主キー）
	private int goodsId;

	//商品名
	private String goodsName;

	//商品価格
	private int price;

	//商品情報追加日時
	private Timestamp createdAt;

	//商品情報更新日時
	private Timestamp updatedAt;

	 //カンマ区切りでフォーマットした金額文字列を取得・設定する
    private String formattedPrice;

	public int getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Timestamp getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getFormattedPrice() {
		return formattedPrice;
	}

	public void setFormattedPrice(String formattedPrice) {
		this.formattedPrice = formattedPrice;
	}

}
