package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Memo;
import com.example.service.MemoService;

@RestController
@RequestMapping("/api")
public class MemoController {
	
	@Autowired
	private MemoService memoService;
	
	@GetMapping("/find/{id}")
	public Memo findById(@PathVariable Long id) {
		return memoService.findById(id);
	}
	
	@GetMapping("/findall")
	public List<Memo> findAll(){
		return memoService.findAll();
	}
	
	@GetMapping("/findbymemotext/{memotext}")
	public List<Memo> findByMemoText(@PathVariable String memotext) {
		return memoService.findByMemoText(memotext);
	}
	
	@PostMapping("/update")
	public Long update(@RequestBody Memo memo) {
		return memoService.update(memo);
	}
	
	@GetMapping("/findbyidormemotext")
	public List<Memo> findByIdOrMemoText(@RequestParam("id")Long id,@RequestParam("memoText")String memoText) {
		return memoService.findByIdOrMemoText(id, memoText);
	}
}
