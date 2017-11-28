package de.viergewinnt.model.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import de.viergewinnt.view.test.MainViewModelTest;
import de.viergewinnt.view.test.SpielerViewModelTest;

@RunWith(Suite.class)
@SuiteClasses({ LinienTest.class, SpielerTest.class, SpielbrettZelleTest.class, 
	FarbeTest.class, SpalteTest.class, SpielbrettFactoryTest.class, SpielerViewModelTest.class,
	MainViewModelTest.class})
public class AllTests {

}
