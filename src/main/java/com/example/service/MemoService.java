package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Memo;
import com.example.repository.MemoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemoService {
	@Autowired
	MemoRepository memoRepository;

	public Memo findById(Long id) {
		Optional<Memo> memo = memoRepository.findById(id);
		if(memo.isPresent()) {
			return memo.get();
		}
		return null;
//		throw new Exception("Not find Memo");
	}
	
	public List<Memo> findAll() {
		List<Memo> list = memoRepository.findAll();
		return list;
	}
	
	public List<Memo> findByMemoText(String memoText) {
		List<Memo> list = memoRepository.findByMemoText(memoText);
		return list;
	}
	
	public Long update(Memo memo) {
		memoRepository.save(memo);
		return memo.getId();
	}

	public List<Memo> findByIdOrMemoText(Long id, String memoText) {
		return memoRepository.findByIdOrMemoText(id, memoText);
	}
}
