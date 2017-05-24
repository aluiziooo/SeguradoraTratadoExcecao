public class Seguradora {
	
	public float calcularSeguro(Contratos contrato) {
		float valorSeguro = 0.0f;
		try {

			if(contrato.isTipoConta())
				valorSeguro = calculaSeguroResidencial(contrato);
			else
				valorSeguro = calculaSeguroEmpresarial(contrato);
			
		} catch (NullPointerException e) {
			// TODO: handle exception
			System.out.println("Erro de execução por: ");
			e.printStackTrace();
		}catch (ArithmeticException e) {
			// TODO: handle exception
			System.out.println("Erro de execução por: ");
			e.printStackTrace();
		}
		
		return valorSeguro;
		
	}

	private float calculaSeguroEmpresarial(Contratos contrato) {
	
		float total = contrato.getValorImovel();
		try {
			Residencial res = new Residencial();
			
			total += (total * 0.02);
			
			if (res.getZonaImovel() == "Zona Urbana")
				total += (total * 0.01);
			else if(res.getZonaImovel() == "Zona Suburbana")
				total += (total * 0.005);
			
			if(res.isTipoResidencia())
				total += (total * 0.005);
			
		} catch (NullPointerException e) {
			System.out.println("Erro de execução por: ");
			e.printStackTrace();
			// TODO: handle exception
		}catch (ArithmeticException e) {
			// TODO: handle exception
			System.out.println("Erro de execução por: ");
			e.printStackTrace();
		}
			
		return total;
		
	}

	private float calculaSeguroResidencial(Contratos contrato) {
		
		float total = contrato.getValorImovel();
		
		try {
			Empresarial emp = new Empresarial();
			
			total += (total * 0.04);
			
			total += (int)( emp.getQtdFuncionarios() / 10 ) + (total * 0.02);
			
			total += (int)( emp.getQtdVisitasDiarias() / 200 ) + (total * 0.03);
			
			if(emp.getRamo() == "Industria")
				total += (total * 0.01);
			else if(emp.getRamo() == "Comércio")
				total += (total * 0.005);
			
		} catch (NullPointerException e) {
			// TODO: handle exception
			System.out.println("Erro de execução por: ");
			e.printStackTrace();
		}catch (ArithmeticException e) {
			// TODO: handle exception
			System.out.println("Erro de execução por: ");
			e.printStackTrace();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Erro de execução por: ");
			e.printStackTrace();
		}
		
			
		return total;
		
	}
}

