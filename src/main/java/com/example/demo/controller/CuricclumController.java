package com.example.demo.controller;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Kariki;
import com.example.demo.model.Progress;
import com.example.demo.model.Studywork;
import com.example.demo.model.Subject;
import com.example.demo.model.Targetuniver;
import com.example.demo.model.Textpage;
import com.example.demo.model.User;
import com.example.demo.service.KarikiService;
import com.example.demo.service.ProgressService;
import com.example.demo.service.StudyworkService;
import com.example.demo.service.SubjectService;
import com.example.demo.service.TargetuniverService;
import com.example.demo.service.UserService;
@Controller
public class CuricclumController
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
    KarikiService karikiService;




	@GetMapping("/kariki")
	//複数テーブル結合し必要なデータのみを運ぶkarikiモデルにデータを入れてどうにかこうにか
	//one to many とかなくてもイケルっぽい
	public String kariki( Model model)
	{
		User users=(User)session.getAttribute("Data");
		model.addAttribute("user",users);
		List<Kariki> kariki =karikiService.findId(users.getId());
		model.addAttribute("kariki", kariki);

		return "kariki";
	}

	//ajax 学習項目idと個人idから更新する進捗データ拾ってどうこう
	@GetMapping("/AjaxServlet")
	public String AjaxServlet(@RequestParam int id,int progress, Model model)
	{
		User users=(User)session.getAttribute("Data");
		model.addAttribute("user",users);
		Progress ajaxprogress= progressService.findUseridStudyid(users.getId(),id);
		ajaxprogress.setProgresspercent(progress);
		progressService.updateProgress(ajaxprogress);
		return "kariki";
	}




	//進捗を更新するくだり 進んだ分のページ数をtargetuniverのtextpageに入れてるけど冷静に考えると紛らわしい気がする
	//適当な入れ物（インスタンスじゃなくて単一の変数）に入れるでもよかったかも
	@PostMapping("/progress")
    public String progress(@Validated  @RequestParam String allpage,String studyworkid,@ModelAttribute  Textpage textpage,BindingResult result, Targetuniver targetuniver,
    		Model model)
	{
		User users=(User)session.getAttribute("Data");
		model.addAttribute("user",users);
		List<Kariki> kariki =karikiService.findId(users.getId());
		model.addAttribute("kariki", kariki);

		if (result.hasErrors()||textpage==null)
		{
        // エラーがある場合、戻る
        return "/Phrase";

		}



		int bunshi=textpage.getTextpage();
		int bunbo=Integer.parseInt(allpage);
		if(bunshi>bunbo)
		{
			return "/kariki";
		}
		int pageprogress=bunshi*100/bunbo;




		Studywork studywork =studyworkService.findById(Integer.parseInt(studyworkid));
		model.addAttribute("studywork", studywork);

		Progress progress= progressService.findUseridStudyid(users.getId(),studywork.getId());
		progress.setProgresspercent(pageprogress);

		progressService.updateProgress(progress);

	return "home";
	}






	//学習詳細画面にアクセス　項目idを拾えれば最初のマッピングだけでなんとかなる
	//
	@GetMapping("/phrase")
	public String Phrase1( Model model, @RequestParam int id, Textpage textpage)//数字の送り方に問題があるっぽい
	{

		Studywork studywork =studyworkService.findById(id);
		model.addAttribute("studywork", studywork);

		User users=(User)session.getAttribute("Data");
		model.addAttribute("user",users);

		Progress progress= progressService.findUseridStudyid(users.getId(),studywork.getId());
		model.addAttribute("progress",progress);

		Targetuniver targetuniver= targetuniverService.findTargetidSubjectid(users.getTarget(),studywork.getId());
		model.addAttribute("targetuniver",targetuniver);

		Subject subject= subjectService.findId(studywork.getSubjectid());
		model.addAttribute("subject",subject);

    return "Phrase";
    }


}