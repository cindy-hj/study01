package com.example.repository;

import java.util.List;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Memo;

public interface MemoRepository extends JpaRepository<Memo, Long>{

	List<Memo> findByMemoText(String memoText);

	List<Memo> findByIdOrMemoText(Long id, String memoText);

}
