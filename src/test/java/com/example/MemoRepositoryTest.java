package com.example;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.model.Memo;
import com.example.repository.MemoRepository;

@SpringBootTest
public class MemoRepositoryTest {
	
	@Autowired
	MemoRepository memoRepository;
	
	@Test
	public void InsertDummies() {
		for(int i=1; i<=10; i++) {
			Memo memo = Memo.builder()
							.memoText("sample"+i)
							.build();
			memoRepository.save(memo);
		}
	}
	
	@Test
	public void SelectDummies() {
		Long id = 10L;
		Optional<Memo> result = memoRepository.findById(id);
		System.out.println("=======================");
		
		if(result.isPresent()) {
			Memo memo = result.get();
			System.out.println(memo);
		}
	}
	
	@Test
	public void UpdateDummies() {
		Memo memo = Memo.builder()
						.id(10L)
						.memoText("Update Text")
						.build();
		memoRepository.save(memo);
	}
	
	@Test
	public void DeletDummies() {
		Long id = 10L;
		memoRepository.deleteById(id);
	}
	
	
}
