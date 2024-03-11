package com.marondal.spring.test.ajax;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.marondal.spring.test.ajax.domain.Booking;
import com.marondal.spring.test.ajax.service.BookingService;

@RequestMapping("/ajax/booking")
@Controller
public class BookingController {
	
	@Autowired
	private BookingService bookingService;
	
	@GetMapping("/list")
	public String bookingList(Model model) {
		
		List<Booking> bookingList = bookingService.getBookingList();
		
		model.addAttribute("bookingList", bookingList);
		
		return "ajax/booking/list";
	}
	
	@GetMapping("/input")
	public String inputBooking() {
		return "ajax/booking/input";
	}
	
	@GetMapping("/main")
	public String bookingMain() {
		return "ajax/booking/main";
	}
	
	@GetMapping("/delete")
	@ResponseBody
	public Map<String, String> deleteBooking(@RequestParam("id") int id) {
		int count = bookingService.deleteBooking(id);
		
		// 성공 : {"result":"success"}
		// 실패 : {"result":"fail"}
		
		Map<String, String> resultMap = new HashMap<>();
		
		if(count == 1) {
			resultMap.put("result", "success");
		} else {
			resultMap.put("result", "fail");
		}
		
		return resultMap;
	}
	
	@GetMapping("/create")
	@ResponseBody
	public Map<String, String> createBooking( 
			@RequestParam("name") String name
			, @DateTimeFormat(pattern="yyyy년 MM월 dd일") @RequestParam("date") Date date  // 2024년 03월 11일
			, @RequestParam("day") int day
			, @RequestParam("headcount") int headcount
			, @RequestParam("phoneNumber") String phoneNumber) {
		
		int count = bookingService.addBooking(name, date, day, headcount, phoneNumber);
		
		// 성공 : {"result":"success"}
		// 실패 : {"result":"fail"}
		Map<String, String> resultMap = new HashMap<>();
		
		if(count == 1) {
			resultMap.put("result", "success");
		} else {
			resultMap.put("result", "fail");
		}
		
		return resultMap;
		
	}
	
	// 예약 조회 API
	// 이름과 전화번호를 전달 받고, 대응되는 예약 정보를 Response 에 담는다
	@GetMapping("/search")
	@ResponseBody
	public Map<String, Object> searchBooking(
			@RequestParam("name") String name
			, @RequestParam("phoneNumber") String phoneNumber) {
		
		Booking booking = bookingService.searchBooking(name, phoneNumber);
		
		// 조회 결과가 있는 경우 : {"result":"success", "booking":{"id":9,"name":"장나라","headcount":2,"day":1,"date":"2025-09-11T15:00:00.000+00:00","phoneNumber":"010-2222-0000","state":"확정","createdAt":"2024-01-22T07:58:30.000+00:00","updatedAt":"2024-01-22T07:58:30.000+00:00"}}
		// 조회 결과가 없는 경우 : {"result":"fail"}
		
		Map<String, Object> resultMap = new HashMap<>();
		if(booking != null) {
			resultMap.put("result", "success");
			resultMap.put("booking", booking);
		} else {
			resultMap.put("result", "fail");
		}
		return resultMap;
	}
	
	
	
	
	

}
