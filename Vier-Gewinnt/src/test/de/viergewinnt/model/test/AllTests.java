package de.viergewinnt.model.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import viergewinnt.view.tests.MainViewModelTest;
import viergewinnt.view.tests.SpielerViewModelTest;

@RunWith(Suite.class)
@SuiteClasses({ LinienTest.class, SpielerTest.class, SpielbrettZelleTest.class, 
	FarbeTest.class, SpalteTest.class, SpielbrettFactoryTest.class, SpielerViewModelTest.class,
	MainViewModelTest.class})
public class AllTests {

}
