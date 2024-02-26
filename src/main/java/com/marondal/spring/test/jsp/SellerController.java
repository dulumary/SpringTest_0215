package com.marondal.spring.test.jsp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.marondal.spring.test.jsp.domain.Seller;
import com.marondal.spring.test.jsp.service.SellerService;

@RequestMapping("/jsp/seller")
@Controller
public class SellerController {
	
	@Autowired
	private SellerService sellerService;
	
	@PostMapping("/create")
	@ResponseBody
	public String createSeller(
			@RequestParam("nickname") String nickname
			, @RequestParam("temperature") double temperature
			, @RequestParam("profileImage") String profileImage) {
		
		int count = sellerService.addSeller(nickname, temperature, profileImage);
		
		return "수행 결과 : " + count;
		
	}
	
	@GetMapping("/input")
	public String inputSeller() {
		return "jsp/sellerInput";
	}
	
	@GetMapping("/info")
	public String sellerInfo(
			@RequestParam(value="id", required=false) Integer id
			, Model model) {
				
		Seller seller = null;
		// id 파라미터가 전달되면 id에 일치하는 판매자 정보 조회
		if(id != null) {			
			seller = sellerService.getSeller(id);
			
		} else {  // id 파라미터가 전달되지 않으면 가장 최근에 추가된 판매자 정보 조회 		 	
			seller = sellerService.getLastSeller();
			
		}
		
		model.addAttribute("seller", seller);
		return "jsp/sellerInfo";
	}
	
	

}
