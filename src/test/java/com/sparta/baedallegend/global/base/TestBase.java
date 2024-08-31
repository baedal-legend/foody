package com.sparta.baedallegend.global.base;

import static com.sparta.baedallegend.global.base.TestBase.TEST;
import static org.springframework.test.context.TestConstructor.AutowireMode.ALL;

import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestConstructor;

@ActiveProfiles(TEST)
@TestConstructor(autowireMode = ALL)
public class TestBase {

	static final String TEST = "test";

}
