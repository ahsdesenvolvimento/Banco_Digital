package ibank;

import java.util.Scanner;

public class ContaCorrente extends Conta {
	double taxaManutencao;
	double valor=.2f;

	

	public ContaCorrente(Cliente cliente) {
		super(cliente);
	}

	
	// Metodo para definir valor do cheque especial disponivel
	public double chequeEspecial() {
		if(cliente.getSalario()>=2000) {
			this.valor = cliente.getSalario()*0.30;
			} else if (cliente.getSalario()<2000 && cliente.getSalario()>=1000) {
				this.valor = cliente.getSalario()*0.10;
								
			} else {
				this.valor =0.00;
				   }
		return this.valor;
		
	}
	 
	// Metodo para possibilitar o cliente realizar pagamento de contas
	@Override
	public double pagarConta() {
		System.out.println("Deseja pagar uma conta atraves da sua conta corrente?");
		System.out.println("digite s caso deseje continuar");
		Scanner scan = new Scanner(System.in);
		String continuar = scan.next();
		if(continuar.equals("s")) {
		System.out.println("Informe o valor da conta que deseja pagar");
		Scanner scan1 = new Scanner(System.in);
		double contaPaga= scan1.nextDouble();
		if(this.saldo>=contaPaga) 
		{
		this.saldo-=contaPaga;
		} else if(this.saldo + chequeEspecial()>=contaPaga) {
          this.valor-=contaPaga;
		  this.saldo-=contaPaga;
		} else
		{
			System.out.println("Você não possui saldo suficiente");
			scan.close();
			scan1.close();
		}
		}
		
		return this.saldo;
		
	}

	
	@Override
	public void imprimirExtrato() {
		System.out.println("\n");
		System.out.println("====== Extrato Conta Corrente ======");
		super.imprimirInfosComuns();
		System.out.println(String.format("||   Tx manu.: %.2f               ||", this.taxaManutencao));
		System.out.println(String.format("||   Tx transf.: %.2f            ||", this.armazenador*(taxaTransferencia)));
		System.out.println("||   Cheque Esp R$ "+ ((chequeEspecial()+"          ||")));
		System.out.println("====================================");
		
	}

	//metodo para atualizar as finanças da conta com salario e valores 
	@Override
	public void virarMes() {
		// TODO Auto-generated method stub
		double taxaManutencao = 45.00;
		this.taxaManutencao =  taxaManutencao;
		this.saldo -=taxaManutencao;
		this.saldo +=cliente.getSalario();
		}
	

	
	
}