package com.marondal.spring.test.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.marondal.spring.test.jpa.domain.Recruit;
import com.marondal.spring.test.jpa.repository.RecruitRepository;

@RequestMapping("/jpa/recruit")
@Controller
public class RecruitController {
	
	@Autowired
	private RecruitRepository recruitRepository;
	
	@GetMapping("/1")
	@ResponseBody
	public Recruit jpaTest01() {
		Optional<Recruit> optionalRecruit = recruitRepository.findById(8);
		Recruit recruit = optionalRecruit.orElse(null);
		
		return recruit;
	}
	
	@GetMapping("/2")
	@ResponseBody
	public List<Recruit> jpaTest02(@RequestParam("companyId") int companyId) {
		List<Recruit> recruitList = recruitRepository.findByCompanyId(companyId);
		return recruitList;
	}
	
	@GetMapping("/3")
	@ResponseBody
	public List<Recruit> jpaTest03() {
//		웹 back-end 개발자 이고 정규직인 공고를 조회
//		List<Recruit> recruitList = recruitRepository.findByPositionAndType("웹 back-end 개발자", "정규직");
		List<Recruit> recruitList = null;
//		정규직이거나 연봉이 9000 이상인 공고를 조회
		recruitList = recruitRepository.findByTypeOrSalaryGreaterThanEqual("정규직", 9000);
		
		return recruitList;
	}

}
