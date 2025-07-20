//*******************************************
//　　　商品テーブル操作用
//*******************************************

package jp.co.internous.ecsite.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import jp.co.internous.ecsite.model.domain.MstGoods;

@Mapper
public interface MstGoodsMapper {

	@Select(value = "select * from mst_goods")
	List<MstGoods> findAll();

	@Insert("insert into mst_goods (goods_name, price) values (#{goodsName}, #{price})")
	// 登録時に自動採番されたIDをMstGoodsオブジェクトにセット
	@Options(useGeneratedKeys=true, keyProperty= "id")
	int insert(MstGoods goods);

	@Update("delete from mst_goods where goods_id = #{id}")
	int deleteById(int id);

    @Select("SELECT * FROM mst_goods WHERE goods_id = #{id}")
    MstGoods findById(int id);


}
