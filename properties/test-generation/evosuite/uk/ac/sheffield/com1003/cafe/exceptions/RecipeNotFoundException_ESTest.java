/*
 * This file was automatically generated by EvoSuite
 * Thu Sep 21 18:31:03 GMT 2023
 */

package uk.ac.sheffield.com1003.cafe.exceptions;

import org.junit.Test;
import static org.junit.Assert.*;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;
import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true) 
public class RecipeNotFoundException_ESTest extends RecipeNotFoundException_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      RecipeNotFoundException recipeNotFoundException0 = new RecipeNotFoundException();
  }
}
