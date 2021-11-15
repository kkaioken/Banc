package com.example.testingweb.pedido;

import java.util.List;

public interface PedidoRepository {
	List<Pedido> buscarPelo(int numeroDoPedido);
}
