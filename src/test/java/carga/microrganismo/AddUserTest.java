package carga.microrganismo;

import inicializacao.InicializacaoSpring;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.service.IFuncaoService;

public class AddUserTest {
	
	static IFuncaoService service;

  @BeforeClass
  public static void setUpClass() {
      InicializacaoSpring.setUpClass();
      service = (IFuncaoService) InicializacaoSpring.ctx.getBean("FuncaoService");
  }

  @BeforeMethod
  public void setUp() {
      System.out.println("================================================");
  }

  @AfterTest
  public void afterTest() {
  }


  @Test
  public void main() {
    throw new RuntimeException("Test not implemented****************");
  }
}
