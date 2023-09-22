/**
 * Scaffolding file used to store all the setups needed to run 
 * tests automatically generated by EvoSuite
 * Thu Sep 21 21:02:46 GMT 2023
 */

package uk.ac.sheffield.com1003.cafe;

import org.evosuite.runtime.annotation.EvoSuiteClassExclude;
import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.After;
import org.junit.AfterClass;
import org.evosuite.runtime.sandbox.Sandbox;
import org.evosuite.runtime.sandbox.Sandbox.SandboxMode;

@EvoSuiteClassExclude
public class Cafe_ESTest_scaffolding {

  @org.junit.Rule
  public org.evosuite.runtime.vnet.NonFunctionalRequirementRule nfr = new org.evosuite.runtime.vnet.NonFunctionalRequirementRule();

  private static final java.util.Properties defaultProperties = (java.util.Properties) java.lang.System.getProperties().clone(); 

  private org.evosuite.runtime.thread.ThreadStopper threadStopper =  new org.evosuite.runtime.thread.ThreadStopper (org.evosuite.runtime.thread.KillSwitchHandler.getInstance(), 3000);


  @BeforeClass
  public static void initEvoSuiteFramework() { 
    org.evosuite.runtime.RuntimeSettings.className = "uk.ac.sheffield.com1003.cafe.Cafe"; 
    org.evosuite.runtime.GuiSupport.initialize(); 
    org.evosuite.runtime.RuntimeSettings.maxNumberOfThreads = 100; 
    org.evosuite.runtime.RuntimeSettings.maxNumberOfIterationsPerLoop = 10000; 
    org.evosuite.runtime.RuntimeSettings.mockSystemIn = true; 
    org.evosuite.runtime.RuntimeSettings.sandboxMode = org.evosuite.runtime.sandbox.Sandbox.SandboxMode.RECOMMENDED; 
    org.evosuite.runtime.sandbox.Sandbox.initializeSecurityManagerForSUT(); 
    org.evosuite.runtime.classhandling.JDKClassResetter.init();
    setSystemProperties();
    initializeClasses();
    org.evosuite.runtime.Runtime.getInstance().resetRuntime(); 
  } 

  @AfterClass
  public static void clearEvoSuiteFramework(){ 
    Sandbox.resetDefaultSecurityManager(); 
    java.lang.System.setProperties((java.util.Properties) defaultProperties.clone()); 
  } 

  @Before
  public void initTestCase(){ 
    threadStopper.storeCurrentThreads();
    threadStopper.startRecordingTime();
    org.evosuite.runtime.jvm.ShutdownHookHandler.getInstance().initHandler(); 
    org.evosuite.runtime.sandbox.Sandbox.goingToExecuteSUTCode(); 
    setSystemProperties(); 
    org.evosuite.runtime.GuiSupport.setHeadless(); 
    org.evosuite.runtime.Runtime.getInstance().resetRuntime(); 
    org.evosuite.runtime.agent.InstrumentingAgent.activate(); 
  } 

  @After
  public void doneWithTestCase(){ 
    threadStopper.killAndJoinClientThreads();
    org.evosuite.runtime.jvm.ShutdownHookHandler.getInstance().safeExecuteAddedHooks(); 
    org.evosuite.runtime.classhandling.JDKClassResetter.reset(); 
    resetClasses(); 
    org.evosuite.runtime.sandbox.Sandbox.doneWithExecutingSUTCode(); 
    org.evosuite.runtime.agent.InstrumentingAgent.deactivate(); 
    org.evosuite.runtime.GuiSupport.restoreHeadlessMode(); 
  } 

  public static void setSystemProperties() {
 
    java.lang.System.setProperties((java.util.Properties) defaultProperties.clone()); 
    java.lang.System.setProperty("user.dir", "/home/ruizhen/Projects/APR-as-AAT/com1003_cafe_8"); 
    java.lang.System.setProperty("java.io.tmpdir", "/tmp"); 
  }

  private static void initializeClasses() {
    org.evosuite.runtime.classhandling.ClassStateSupport.initializeClasses(Cafe_ESTest_scaffolding.class.getClassLoader() ,
      "uk.ac.sheffield.com1003.cafe.ingredients.Ingredient",
      "uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException",
      "uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException",
      "uk.ac.sheffield.com1003.cafe.Recipe$Size",
      "uk.ac.sheffield.com1003.cafe.Cafe",
      "uk.ac.sheffield.com1003.cafe.Recipe",
      "uk.ac.sheffield.com1003.cafe.exceptions.CafeOutOfCapacityException",
      "uk.ac.sheffield.com1003.cafe.Order"
    );
  } 

  private static void resetClasses() {
    org.evosuite.runtime.classhandling.ClassResetter.getInstance().setClassLoader(Cafe_ESTest_scaffolding.class.getClassLoader()); 

    org.evosuite.runtime.classhandling.ClassStateSupport.resetClasses(
      "uk.ac.sheffield.com1003.cafe.Cafe",
      "uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException",
      "uk.ac.sheffield.com1003.cafe.Recipe",
      "uk.ac.sheffield.com1003.cafe.Order",
      "uk.ac.sheffield.com1003.cafe.exceptions.CafeOutOfCapacityException"
    );
  }
}
