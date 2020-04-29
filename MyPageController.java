package jp.co.internous.peace.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.internous.peace.model.domain.MstUser;
import jp.co.internous.peace.model.mapper.MstUserMapper;
import jp.co.internous.peace.model.session.LoginSession;

@Controller
@RequestMapping("/peace/my_page")
public class MyPageController {
	
	  @Autowired
	  MstUserMapper mstUserMapper;
	  
	  @Autowired
	  public LoginSession loginSession;
	
	//表示データ取得
	  @RequestMapping("/")
		public String index(Model m) {
	 		MstUser user = mstUserMapper.findByUserNameAndPassword(loginSession.getUserName(), loginSession.getPassword());		 
	 			m.addAttribute("user",user);
	 			m.addAttribute("loginSession",loginSession);
	 		
	 		return "my_page";
		   
		   
	  }
	  
}
