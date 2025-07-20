//*******************************************
//　　　カートテーブル追加用
//*******************************************

package jp.co.internous.ecsite.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import jp.co.internous.ecsite.model.domain.TblCart;

@Mapper
public interface TblCartMapper {

	//tbl_cartに商品を追加
	@Insert("INSERT INTO tbl_cart (user_id, goods_id, item_count, total) " +
            "VALUES (#{user_id}, #{goods_id}, #{item_count}, #{total})")
    int insert(TblCart cart);

    // ユーザーIDでカート一覧を取得
    @Select("SELECT * FROM tbl_cart WHERE user_id = #{userId}")
    List<TblCart> findByUserId(int userId);
}
