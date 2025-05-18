
ALTER TABLE modelo_carro MODIFY categoria VARCHAR(255);
ALTER TABLE pessoa ADD COLUMN dtype VARCHAR(31);

INSERT INTO modelo_carro (id_modelo, descricao, categoria)
VALUES (1, 'Sedan médio automático','SEDAN_MEDIO');

INSERT INTO carro (
    id_carro,
    chassi,
    cor,
    placa,
    valor_diaria,
    modelo_carro_id_modelo
) VALUES (
    1,
    '9BWZZZ377VT004251',
    'Preto',
    'ABC1D23',
    150.00,
    1
);

INSERT INTO acessorio (id_acessorio, descricao)
VALUES (1, 'Cilhos');

INSERT INTO carro_acessorio (id_carro, id_acessorio)
VALUES (1, 1);

INSERT INTO aluguel (
    data_pedido,
    data_entrega,
    data_devolucao,
    valor_total,
    carro_id
) VALUES (
    '2025-05-15',
    '2025-05-16',
    '2025-05-20',
    1200.50,
    1
);

INSERT INTO pessoa ( nome, data_nascimento, cpf, email, numerocnh, tipo_pessoa, dtype )
VALUES ( 'João Silva', '1985-03-15', '12345678900', 'joao.silva@email.com', 'CNH1234567', 'MOTORISTA', 'Motorista' );

INSERT INTO apolice_seguro (valor_franquia, protecao_terceiro, protecao_causas_naturais, protecao_roubo, aluguel_id)
VALUES (500.00, TRUE, TRUE, FALSE, 1);