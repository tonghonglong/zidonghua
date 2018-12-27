package com.dongnao.autotest.service.impl;

import static org.junit.Assert.fail;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.dongnao.autotest.service.mapper.CaseGroupMapper;
import com.dongnao.autotest.web.App;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class CaseGroupServiceImplTest {
	
	@Autowired
	private CaseGroupMapper caseGroupMapper;

	@Test
	public void testAdd() {
		System.out.println("caseGroupMapper:"+caseGroupMapper);
		

		Map<String, Object> groupMap = new HashMap<>();
		groupMap.put("name", "aaa");
		groupMap.put("type", "2");
		groupMap.put("url", "http://www.baidu.com");
		
		
		int id = caseGroupMapper.insert(groupMap);
		
		System.out.println("id========："+id);
		System.out.println("id========："+groupMap.get("id"));
				
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

}
