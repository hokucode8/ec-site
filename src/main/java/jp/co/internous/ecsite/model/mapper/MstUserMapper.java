//*******************************************
//　　　ログイン認証：ユーザーテーブル参照用
//*******************************************

package jp.co.internous.ecsite.model.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import jp.co.internous.ecsite.model.domain.MstUser;
import jp.co.internous.ecsite.model.form.LoginForm;

@Mapper
public interface MstUserMapper {

	@Select(value="select * from mst_user where user_name = #{userName} and password = #{password}")
	MstUser findByUserNameAndPassword(LoginForm form);

}