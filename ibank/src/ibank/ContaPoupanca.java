package ibank;

import java.util.Scanner;

public class ContaPoupanca extends Conta {
	public double rendimento;

	public ContaPoupanca(Cliente cliente) {
		super(cliente);
		
	}

	@Override
	public void imprimirExtrato() {
		System.out.println("====== Extrato Conta Poupança ======");
		super.imprimirInfosComuns();
		System.out.println(String.format("||   Rendimentos R$: %.2f         ||", this.rendimento));
		System.out.println(String.format("||   Saldo ant. R$: %.2f        ||", this.saldo-(this.rendimento)));
		System.out.println("====================================");
		System.out.println("\n");
		
	}

	@Override
	public void virarMes() {
		// TODO Auto-generated method stub
	    double rendimento = this.saldo*(0.05);
	    this.rendimento =  rendimento;
		this.saldo = saldo+= rendimento;
		}
	
	@Override
	public double pagarConta() {
		System.out.println("Deseja pagar uma conta atraves do saldo na conta poupança?");
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
		} else
		{
			System.out.println("Você não possui saldo suficiente");
			scan.close();
			scan1.close();
		}
		}
		
		return this.saldo;
		
	}

	}