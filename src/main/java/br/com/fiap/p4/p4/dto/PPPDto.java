package br.com.fiap.p4.p4.dto;

import br.com.fiap.p4.p4.entities.ItemPesquisa;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public record PPPDto(
        UUID id,
        String descricao,
        String responsavel,
        Date dataCriacao,
        List<ItemPesquisa> itensPesquisa
) {

}