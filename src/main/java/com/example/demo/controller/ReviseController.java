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

import com.example.demo.model.Univercity_Name;
import com.example.demo.model.User;
import com.example.demo.service.ProgressService;
import com.example.demo.service.StudyworkService;
import com.example.demo.service.SubjectService;
import com.example.demo.service.TargetuniverService;
import com.example.demo.service.Univercity_NameService;
import com.example.demo.service.UserService;

@Controller
public class ReviseController
{



    @Autowired //← コンストラクタが１つの場合、@Autowiredは省略できます
    HttpSession session;
    @Autowired
    StudyworkService studyworkService;
    @Autowired
    ProgressService progressService;
    @Autowired
    TargetuniverService targetuniverService;
    @Autowired
    SubjectService subjectService;
    @Autowired
    UserService userService;
    @Autowired
    Univercity_NameService univercity_NameService;

    @GetMapping("/revise")
	public String revise(@ModelAttribute User user, Model model)
	{
		User users=(User)session.getAttribute("Data");
		model.addAttribute("user",users);
		Univercity_Name univercity_Name=
				univercity_NameService.findId
				(users.getTarget());
		model.addAttribute("univercity_Name",univercity_Name);
		return "revise";
	}






  //下二つでtargetフィールド（志望校）の編集
  	@GetMapping("/target")
  	public String target(@ModelAttribute User user, Model model)
  	{
  		User users=(User)session.getAttribute("Data");
  		model.addAttribute("user",users);
  		return "target";
  	}

  	@PostMapping("/revisetarget")
  	public String revisetarget(@Validated @ModelAttribute User user,BindingResult result, Model model)
  	{
  		if (result.hasErrors())
        {
            return "target";
        }
  		User users=(User)session.getAttribute("Data");
  		users.setTarget(user.getTarget());
  		userService.updateUser(users);

  		return "revisedone";
  	}

  //下二つでgradeフィールド（志望校）の編集
  	@GetMapping("/grade")
  	public String grade(@ModelAttribute User user, Model model)
  	{
  		User users=(User)session.getAttribute("Data");
  		model.addAttribute("user",users);
  		return "grade";
  	}

  	@PostMapping("/revisegrade")
  	public String revisegrade(@Validated @ModelAttribute User user,BindingResult result, Model model)
  	{
  		if (result.hasErrors())
        {
            return "grade";
        }
  		User users=(User)session.getAttribute("Data");
  		users.setGrade(user.getGrade());
  		userService.updateUser(users);

  		return "revisedone";
  	}

  	//性別フィールドの更新
  	@GetMapping("/sex")
  	public String sex(@ModelAttribute User user, Model model)
  	{
  		User users=(User)session.getAttribute("Data");
  		model.addAttribute("user",users);
  		return "sex";
  	}


  	@PostMapping("/revisesex")
  	public String revisesex(@Validated @ModelAttribute User user,BindingResult result, Model model)
  	{
  		if (result.hasErrors())
        {
            return "sex";
        }
  		User users=(User)session.getAttribute("Data");
  		users.setSex(user.getSex());
  		userService.updateUser(users);

  		return "revisedone";
  	}


  //苗字フィールドの更新
  	@GetMapping("/lastname")
  	public String lastname(@ModelAttribute User user, Model model)
  	{
  		User users=(User)session.getAttribute("Data");
  		model.addAttribute("user",users);
  		return "lastname";
  	}

  	@PostMapping("/reviselastname")
  	public String reviselastname(@Validated @ModelAttribute User user,BindingResult result, Model model)
  	{
  		if (result.hasErrors())
        {
            return "lastname";
        }
  		User users=(User)session.getAttribute("Data");
  		users.setLastname(user.getLastname());
  		userService.updateUser(users);

  		return "revisedone";
  	}

  //苗字フィールドの更新
  	@GetMapping("/firstname")
  	public String firstname(@ModelAttribute User user, Model model)
  	{
  		User users=(User)session.getAttribute("Data");
  		model.addAttribute("user",users);
  		return "firstname";
  	}

  	@PostMapping("/revisefirstname")
  	public String revisefirstname(@Validated @ModelAttribute User user,BindingResult result, Model model)
  	{
  		if (result.hasErrors())
        {
            return "firstname";
        }
  		User users=(User)session.getAttribute("Data");
  		users.setFirstname(user.getFirstname());
  		userService.updateUser(users);

  		return "revisedone";
  	}

  	@GetMapping("/address")
  	public String address(@ModelAttribute User user, Model model)
  	{

  		User users=(User)session.getAttribute("Data");
  		model.addAttribute("user",users);
  		return "address";
  	}

  	@PostMapping("/reviseaddress")
  	public String reviseaddress(@Validated @ModelAttribute User user,BindingResult result, Model model)
  	{
  		if (result.hasErrors())
        {
            return "address";
        }
  		User users=(User)session.getAttribute("Data");
  		users.setAddress(user.getAddress());
  		userService.updateUser(users);

  		return "revisedone";
  	}

  	@GetMapping("/email")
  	public String email(@ModelAttribute User user, Model model)
  	{
  		User users=(User)session.getAttribute("Data");
  		model.addAttribute("user",users);
  		return "email";
  	}

  	@PostMapping("/reviseemail")
  	public String reviseemail(@Validated @ModelAttribute User user,BindingResult result, Model model)
  	{
  		if (result.hasErrors())
        {
            return "email";
        }
  		User users=(User)session.getAttribute("Data");
  		users.setEmail(user.getEmail());
  		userService.updateUser(users);

  		return "revisedone";
  	}

  	@GetMapping("/hensachi")
  	public String hensachi(@ModelAttribute User user, Model model)
  	{
  		User users=(User)session.getAttribute("Data");
  		model.addAttribute("user",users);
  		return "hensachi";
  	}

  	@PostMapping("/revisehensachi")
  	public String revisehensachi(@Validated @ModelAttribute User user,BindingResult result, Model model)
  	{
  		if (result.hasErrors())
        {
            return "hensachi";
        }
  		User users=(User)session.getAttribute("Data");
  		users.setHensachi(user.getHensachi());
  		userService.updateUser(users);

  		return "revisedone";
  	}


  	@GetMapping("/password")
  	public String password(@ModelAttribute User user, Model model)
  	{
  		User users=(User)session.getAttribute("Data");
  		model.addAttribute("user",users);
  		return "password";
  	}

  	@PostMapping("/revisepassword")
  	public String revisepassword(@Validated @ModelAttribute User user,BindingResult result, Model model)
  	{
  		if (result.hasErrors())
        {
            return "password";
        }
  		User users=(User)session.getAttribute("Data");
  		users.setPassword(user.getPassword());
  		userService.updateUser(users);

  		return "revisedone";
  	}

	@GetMapping("/postnumber")
  	public String postnumber(@ModelAttribute User user, Model model)
  	{
  		User users=(User)session.getAttribute("Data");
  		model.addAttribute("user",users);
  		return "postnumber";
  	}

  	@PostMapping("/revisepostnumber")
  	public String revisepostnumber(@Validated @ModelAttribute User user,BindingResult result, Model model)
  	{
  		if (result.hasErrors())
        {
            return "postnumber";
        }
  		User users=(User)session.getAttribute("Data");
  		users.setPostnumber(user.getPostnumber());
  		userService.updateUser(users);

  		return "revisedone";
  	}

}



