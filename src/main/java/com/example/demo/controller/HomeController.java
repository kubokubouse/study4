package com.example.demo.controller;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Login;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
@Controller
public class HomeController
{
	private final UserRepository repository;
    @Autowired //← コンストラクタが１つの場合、@Autowiredは省略できます
    HttpSession session;
    @Autowired
    UserService userService;
    public HomeController(UserRepository repository)
    {
        this.repository = repository;

    }


		//トップページは特段渡す数字とかないから引数渡さんでよい
	    @GetMapping("/")
	    public String index()
	    {
	        return "index";
	    }

	    @GetMapping("/home")
	    public String home(@ModelAttribute User user, Model model)
	    {
	    	User users=(User)session.getAttribute("Data");
	    	model.addAttribute("user",users);
	    	return "home";
	    }

	@GetMapping("/register")
    public String register(@ModelAttribute User user)
	{
        return "register";
    }

	@GetMapping("/login")
	  public String login(@ModelAttribute Login login)
	{
		return "login";
	}







	@PostMapping("/")

    public String confirm(@Validated @ModelAttribute User user,
            BindingResult result)
	{
		if (result.hasErrors())
		{
            // エラーがある場合、index.htmlに戻る
            return "register";
        }
	return "confirm";
}


	//ログイン時の処理
	@PostMapping("/login")
	 public String sucsess(@Validated  @ModelAttribute Login login,
	            BindingResult result)
	{
		User users=userService.findEmailPassword(login.getEmail(),login.getPassword());

			if (result.hasErrors()||users==null)
			{
	            // エラーがある場合、login.htmlに戻る
	            return "login";
	        }

		session.setAttribute("Data",users);
		return "sucsess";
	}



	@PostMapping("/revisedone")
	public String revisedone(@Validated @ModelAttribute User user,
			BindingResult result)
	{
			/*if (result.hasErrors()) {
	            // エラーがある場合、login.htmlに戻る
	            return "login";
	        }*/
		return "sucsess";
	}





	@PostMapping("/regist")
    public String addComment(@Validated @ModelAttribute User user, BindingResult result, Model model)
	{
		model.addAttribute("user", repository.findAll());
        if (result.hasErrors())
        {
            return "confirm";
        }
        // COMMENTテーブル：コメント登録
        repository.save(user);
        // ルートパス("/") にリダイレクトします
        return "done";
    }
}