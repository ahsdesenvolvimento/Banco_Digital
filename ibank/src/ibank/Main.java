package ibank;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cliente Pedro = new Cliente();
		Pedro.setNome("Pedro");
		Pedro.setSalario(1000.00);
		
		Conta cc = new ContaCorrente(Pedro);
		Conta poupanca = new ContaPoupanca(Pedro);
       	cc.depositar(1200);
		cc.transferir(200, poupanca);
		cc.transferir(100, poupanca);
		cc.pix(100.00, poupanca);
		poupanca.pagarConta();
		cc.imprimirExtrato();
		poupanca.imprimirExtrato();
		
		
		Cliente Manuel = new Cliente();
		Manuel.setNome("Manuel");
		Manuel.setSalario(1500.00);
		
		Conta cc1 = new ContaCorrente(Manuel);
		Conta poupanca1 = new ContaPoupanca(Manuel);

		cc1.depositar(1200);
		cc1.transferir(200, poupanca1);
		cc1.virarMes();
		poupanca1.virarMes();
		
		cc1.imprimirExtrato();
		poupanca1.imprimirExtrato();
	

	}

}
