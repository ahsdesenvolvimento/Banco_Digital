package ibank;

import java.util.Scanner;

public abstract class Conta implements Iconta {
	
	private static final int AGENCIA_PADRAO = 1001;
	private static int SEQUENCIAL = 1;

	protected int agencia;
	protected int numero;
	protected double saldo;
	protected Cliente cliente;
	protected static double taxaTransferencia = 5.80;
	protected double armazenador=0;

	public Conta(Cliente cliente) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
	}
	
	public double pagarConta() {
		System.out.println("Informe o valor da conta que deseja pagar");
		Scanner scan = new Scanner(System.in);
		double contaPaga= scan.nextDouble();
		if(this.saldo>=contaPaga) 
		{
		this.saldo-=contaPaga;
		} else
		{
			System.out.println("Você não possui saldo suficiente");
		}
		scan.close();
		return this.saldo;
	}
	
	@Override
	public void pix(double valor, Iconta contaDestino) {
		this.sacar(valor);
		contaDestino.depositar(valor);
	}

	@Override
	public void sacar(double valor) {
		saldo -= valor;
	}

	@Override
	public void depositar(double valor) {
		saldo += valor;
	}

	@Override
	public void transferir(double valor, Iconta contaDestino) {
		this.sacar(valor+taxaTransferencia);
		contaDestino.depositar(valor);
		armazenador++;
	}

	public int getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}

	protected void imprimirInfosComuns() {
		System.out.println(String.format("||   Titular: %s               ||", this.cliente.getNome()));
		System.out.println(String.format("||   Agencia: %d                ||", this.agencia));
		System.out.println(String.format("||   Numero: %d                    ||", this.numero));
		System.out.println(String.format("||   Saldo: %.2f                ||", this.saldo));
		
	}
}