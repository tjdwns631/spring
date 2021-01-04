package co.company.spring;

import co.company.spring.controller.MemberVO;

public class LombokTest {
	MemberVO member = MemberVO.builder().name("허성준").id("sj").pw("1234").build();
}
