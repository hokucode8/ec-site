//*******************************************
//　　　カート情報保持クラス
//*******************************************

package jp.co.internous.ecsite.model.domain;

import java.time.LocalDateTime;

public class TblCart {

	//カート情報ID
	private int cartId;

	//購入者ユーザーID
	private int user_id;

	//商品ID
	private int goods_id;

	//アイテム数
	private int item_count;

	//合計金額
	private int total;

	//カート挿入日時
	private LocalDateTime created_at;

	public int getCartId() {
		return cartId;
	}

	public void setcartId(int cartId) {
		this.cartId = cartId;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getGoods_id() {
		return goods_id;
	}

	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}

	public int getItem_count() {
		return item_count;
	}

	public void setItem_count(int item_count) {
		this.item_count = item_count;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public LocalDateTime getCreated_at() {
		return created_at;
	}

	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}

}
