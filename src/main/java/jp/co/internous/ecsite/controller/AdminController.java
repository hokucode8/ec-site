//*******************************************
//　　　管理者ログイン・商品管理処理
//*******************************************

package jp.co.internous.ecsite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jp.co.internous.ecsite.model.domain.MstGoods;
import jp.co.internous.ecsite.model.domain.MstUser;
import jp.co.internous.ecsite.model.form.GoodsForm;
import jp.co.internous.ecsite.model.form.LoginForm;
import jp.co.internous.ecsite.model.mapper.MstGoodsMapper;
import jp.co.internous.ecsite.model.mapper.MstUserMapper;

@Controller
@RequestMapping("/ecsite/admin")
public class AdminController {

	@Autowired
	private MstUserMapper userMapper;

	@Autowired
	private MstGoodsMapper goodsMapper;

	@RequestMapping("/")
	public String index() {
		return "admintop";
	}

	//会員情報照会
	//入力パラメーター
	//受け取ったLoginFormのユーザー名とオアスワードでDB検索
	@PostMapping("/welcome")
	public String welcome(LoginForm form, Model model, RedirectAttributes redirectAttributes) {

		MstUser user = userMapper.findByUserNameAndPassword(form);

		//ユーザーがなければ、ログイン画面にエラー表示
		if (user == null) {

			// リダイレクト先に一時的にデータ（エラー文など）を渡すための入れ物
			redirectAttributes.addFlashAttribute("errMessage", "ユーザー名またはパスワードが違います。"); 

			//redirectにすることによって画面遷移せず「/ecsite/admin/」に言ってと指示
			return "redirect:/ecsite/admin/"; 
		}
		//ユーザーが管理者でなければ、ログイン画面にエラー表示
		if (user .getIsAdmin() == 0) {
			redirectAttributes.addFlashAttribute("errMessage", "管理者ではありません。");
			return "redirect:/ecsite/admin/";
		}

		//OKなら商品一覧を取得してモデルにセット
		List<MstGoods> goods = goodsMapper .findAll();
		model.addAttribute("userName", user .getUserName());
		model.addAttribute("password", user .getPassword());
		model.addAttribute("goods", goods);

		return "welcome";
	}

	//ユーザー名・パスワードを画面に渡して「/goodsMapper」を表示
	@PostMapping("/goodsMst")
	public String goodsMst(LoginForm f, Model m) {
		m.addAttribute("userName", f.getUserName());
		m.addAttribute("password", f.getPassword());

		return "goodsmst";
	}

	//商品追加情報
	@PostMapping("/addGoods")
	public String addGoods(GoodsForm goodsForm, LoginForm loginForm, Model m) {
		m.addAttribute("userName", loginForm.getUserName());
		m.addAttribute("password", loginForm.getPassword());

		MstGoods goods = new MstGoods();
		goods.setGoodsName(goodsForm.getGoodsName());
		goods.setPrice(goodsForm.getPrice());

		goodsMapper .insert(goods);

		return "forward:/ecsite/admin/welcome";
	}

}
