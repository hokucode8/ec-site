//*******************************************
//　　　購入情報保持クラス
//*******************************************

package jp.co.internous.ecsite.model.domain;

import java.time.LocalDateTime;

public class TblPurchase {

	//商品ID
	private int purchaseId;

	//購入者ユーザーID
	private int userId;

	//購入商品ID
	private int goodsId;

	//購入商品の個数
	private int itemCount;

	//購入商品合計金額
	private int total;

	//購入日時
	private LocalDateTime createdAt;

	public int getPurchaseId() {
		return purchaseId;
	}

	public void setPurchaseId(int purchaseId) {
		this.purchaseId = purchaseId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}

	public int getItemCount() {
		return itemCount;
	}

	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
}
