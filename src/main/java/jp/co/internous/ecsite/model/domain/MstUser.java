//*******************************************
//　　　ユーザーテーブルクラス
//*******************************************

package jp.co.internous.ecsite.model.domain;

public class MstUser {

	//ユーザーID（ユーザー情報の主キー）
	private int userId;

	//ユーザー名
	private String userName;

	//ユーザーPW
	private String password;

	//画面表示用フルネーム
	private String fullName;

	//管理者フラグ
	private int isAdmin;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public int getIsAdmin() {
		return isAdmin;
	}


	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}
}
