package com.rp.demo.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rp.demo.model.Tag;

public interface TagRepository extends JpaRepository<Tag,Long> {

}
