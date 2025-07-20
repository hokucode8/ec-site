//*******************************************
//　　　通常会員ログイン・商品管理処理
//*******************************************

package jp.co.internous.ecsite.controller;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpSession;
import jp.co.internous.ecsite.model.domain.MstGoods;
import jp.co.internous.ecsite.model.domain.MstUser;
import jp.co.internous.ecsite.model.domain.TblCart;
import jp.co.internous.ecsite.model.form.LoginForm;
import jp.co.internous.ecsite.model.mapper.MstGoodsMapper;
import jp.co.internous.ecsite.model.mapper.MstUserMapper;
import jp.co.internous.ecsite.model.mapper.TblCartMapper;

@Controller
@RequestMapping("/ecsite/login")
public class UserController {

	@Autowired
	private MstUserMapper userMapper;

	@Autowired
	private MstGoodsMapper goodsMapper;

    @Autowired
    private TblCartMapper cartMapper;

	@RequestMapping("/")
	public String index() {
		return "usertop";
	}

	//会員情報照会
	//入力パラメーター
	//受け取ったLoginFormのユーザー名とオアスワードでDB検索
	@PostMapping("/home")
	public String home(LoginForm form, Model model,
		RedirectAttributes redirectAttributes,
		//sessionを作成
		 HttpSession session) {

		MstUser user = userMapper .findByUserNameAndPassword(form);

		//ユーザーがなければ、ログイン画面にエラー表示
		if (user == null) {

			// リダイレクト先に一時的にデータ（エラー文など）を渡すための入れ物
			redirectAttributes.addFlashAttribute("errMessage", "ユーザー名またはパスワードが違います。"); 

			//redirectにすることによって画面遷移せず「/ecsite/admin/」に言ってと指示
			return "redirect:/ecsite/login/"; 
		}

		//OKなら商品一覧を取得してモデルにセット
		List<MstGoods> goods = goodsMapper .findAll();
		NumberFormat formatter = NumberFormat.getNumberInstance(Locale.JAPAN);
		for (MstGoods item : goods) {
			item.setFormattedPrice(formatter.format(item.getPrice()) + "円");
		}
		
		//sessionに格納
		session.setAttribute("userId", user.getUserId());
		session.setAttribute("userName", user.getUserName());

		//画面に引き渡している
		model.addAttribute("userName", user .getUserName());
		model.addAttribute("goods", goods);

		return "home";
	}

	//カートに商品を入れる
	@PostMapping("/addCart")
	public String addCart(@RequestParam int goodsId,
			@RequestParam int itemCount,
			RedirectAttributes redirectAttributes) {
		TblCart cart = new TblCart();
		cart.setGoods_id(goodsId);
		cart.setItem_count(itemCount);
	    // 商品の単価をDBから取得
	    MstGoods goods = goodsMapper.findById(goodsId);
	    int total = goods.getPrice() * itemCount;
	    cart.setTotal(total);
		cartMapper.insert(cart);
		
	    redirectAttributes.addFlashAttribute("message", "カートに追加しました。");
	    return "redirect:/ecsite/login/home";
	}

	//ユーザー名を画面に渡して「/goodsMapper」を表示
	@PostMapping("/viewcart")
	public String viewCart(HttpSession session, Model model) {
	    Integer userId = (Integer) session.getAttribute("userId");

	    if (userId == null) {
	        return "redirect:/ecsite/login/";
	    }

	    List<TblCart> cartList = cartMapper.findByUserId(userId);
	    model.addAttribute("cartList", cartList);

	    return "cart"; // カート表示画面
	}

}
